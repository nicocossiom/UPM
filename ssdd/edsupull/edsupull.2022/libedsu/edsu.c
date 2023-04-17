#include "edsu.h"

#include <arpa/inet.h>
#include <netdb.h>
#include <netinet/in.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <unistd.h>

#include "comun.h"

struct sockaddr_in server_addr;
int client_fd;
UUID_t client_UUID;

// se ejecuta antes que el main de la aplicación
__attribute__((constructor)) void inicio(void) {
    if (begin_clnt() < 0) {
        // fprintf(stderr, "Error al iniciarse aplicación\n");
        //  terminamos con error la aplicación antes de que se inicie
        //  en el resto de la biblioteca solo usaremos return
        _exit(1);
    }
}

// se ejecuta después del exit de la aplicación
__attribute__((destructor)) void fin(void) {
    if (end_clnt() < 0) {
        // fprintf(stderr, "Error al terminar la aplicación\n");
        //  terminamos con error la aplicación
        //  en el resto de la biblioteca solo usaremos return
        _exit(1);
    }
}
// connects the client to the broker which registers the client
int begin_clnt(void) {
    // create client socket
    // socket creation
    if ((client_fd = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
        perror("socket creation failed");
        exit(EXIT_FAILURE);
    }
    // socket address configuration
    // env vars for broker host and port
    char *BROKER_HOST = getenv("BROKER_HOST");
    char *BROKER_PORT = getenv("BROKER_PORT");
    struct addrinfo *res;
    if (getaddrinfo(BROKER_HOST, BROKER_PORT, NULL, &res) != 0) {
        perror("error en getaddrinfo");
        close(client_fd);
        return 1;
    }
    // connection to server socket
    if (connect(client_fd, res->ai_addr, res->ai_addrlen) < 0) {
        close(client_fd);
        perror("connection with the server failed...\n");
        exit(EXIT_FAILURE);
    }
    // generate uuid
    if (generate_UUID(client_UUID) < 0) {
        perror("error generating client uuid");
        close(client_fd);
        exit(EXIT_FAILURE);
    }
    // fprintf(stderr, "Client UUID generated: %s", client_UUID);
    struct iovec iov[2];
    int op_code = htonl(9);
    // UUID_t uuid = "8e02ff632040b1b258b835e6628227e1";
    // iov[0].iov_base = &uuid;
    // iov[0].iov_len = sizeof(uuid);
    iov[0].iov_base = &client_UUID;
    iov[0].iov_len = sizeof(client_UUID);
    iov[1].iov_base = &op_code;
    iov[1].iov_len = sizeof(op_code);
    // client sends uuid so server can register on the map
    if (writev(client_fd, iov, 2) < 0) {
        perror("error en writev");
        close(client_fd);
        exit(EXIT_FAILURE);
    }
    int tmp2, response;
    recv(client_fd, &tmp2, sizeof(tmp2), MSG_WAITALL);
    response = ntohl(tmp2);
    return response;
}
// operation 8
// ends the client's connection to the server, requesting unsubscription from all topics and freeing all resources allocated to the client
int end_clnt(void) {
    // fprintf(stderr, "\nEnding client conection, requesting unsubscription from all topics and freeing all resources allocated to the client\n");
    int op_code = htonl(8);
    struct iovec iov[2];
    iov[0].iov_base = &client_UUID;
    iov[0].iov_len = sizeof(client_UUID);
    iov[1].iov_base = &op_code;
    iov[1].iov_len = sizeof(op_code);
    // client sends uuid so server can register on the map
    if (writev(client_fd, iov, 2) < 0) {
        perror("error en writev");
        close(client_fd);
        exit(EXIT_FAILURE);
    }
    uint32_t response;
    recv(client_fd, &response, sizeof(response), MSG_WAITALL);
    return response;
}
// operation 0
// subscribes the client to given topic.Returns 0 if success -1 if not
int subscribe(const char *topic) {
    // fprintf(stderr, "Requesting subscription to topic '%s'\n", topic);
    int op_code = htonl(0);
    struct iovec iov[4];
    // op code
    iov[0].iov_base = &client_UUID;
    iov[0].iov_len = sizeof(client_UUID);
    iov[1].iov_base = &op_code;
    iov[1].iov_len = sizeof(op_code);
    // size of topic name
    int topic_len = strlen(topic);
    int arg_size = htonl(topic_len);
    iov[2].iov_base = &arg_size;
    iov[2].iov_len = sizeof(arg_size);
    // topic name
    iov[3].iov_base = topic;
    iov[3].iov_len = topic_len;

    if ((writev(client_fd, iov, 4)) < 0) {
        perror("error en sending subscription request");
        close(client_fd);
        exit(EXIT_FAILURE);
    }
    int response;
    recv(client_fd, &response, sizeof(response), MSG_WAITALL);
    return response;
}
// operation 1
// unsubscribes the client to given topic.Returns 0 if success -1 if not
int unsubscribe(const char *topic) {
    // fprintf(stderr, "Requesting unsubscription to topic '%s'\n", topic);
    int op_code = htonl(1);
    struct iovec iov[4];
    int result = -1;
    // op code
    iov[0].iov_base = &client_UUID;
    iov[0].iov_len = sizeof(client_UUID);
    iov[1].iov_base = &op_code;
    iov[1].iov_len = sizeof(op_code);
    // size of topic name
    int topic_len = strlen(topic);
    int arg_size = htonl(topic_len);
    iov[2].iov_base = &arg_size;
    iov[2].iov_len = sizeof(arg_size);
    // topic name
    iov[3].iov_base = topic;
    iov[3].iov_len = topic_len;

    if ((writev(client_fd, iov, 4)) < 0) {
        perror("error en sending subscription request");
        close(client_fd);
        exit(EXIT_FAILURE);
    }
    int response;
    recv(client_fd, &response, sizeof(response), MSG_WAITALL);
    return response;
}
// operation 2
// publishes the given event to the topic. Returns 0 if success -1 if not
int publish(const char *topic, const void *event, uint32_t event_size) {
    // fprintf(stderr, "Publishing item to topic %s'\n", topic);
    int op_code = htonl(2);
    struct iovec iov[6];
    // client uuid
    iov[0].iov_base = &client_UUID;
    iov[0].iov_len = sizeof(client_UUID);
    // op code
    iov[1].iov_base = &op_code;
    iov[1].iov_len = sizeof(op_code);
    // size of topic name
    int topic_len = strlen(topic);
    int arg_size = htonl(topic_len);
    iov[2].iov_base = &arg_size;
    iov[2].iov_len = sizeof(arg_size);
    // topic name
    iov[3].iov_base = topic;
    iov[3].iov_len = topic_len;
    // size of event
    int event_size_nl = htonl(event_size);
    iov[4].iov_base = &event_size_nl;
    iov[4].iov_len = sizeof(event_size_nl);
    // fprintf(stderr, "\tSending event of size '%d'\n", event_size);
    //  event
    iov[5].iov_base = event;
    iov[5].iov_len = event_size;

    if ((writev(client_fd, iov, 6)) < 0) {
        perror("error en sending subscription request\n");
        close(client_fd);
        exit(EXIT_FAILURE);
    }
    int response;
    recv(client_fd, &response, sizeof(response), MSG_WAITALL);
    return response;
}
// operation 3
// gets the next event from the client's event queue. Returns 0 if success -1 if not
int get(char **ptr_topic, void **ptr_event, uint32_t *ptr_event_size) {
    // fprintf(stderr, "Getting latest event for client\n");

    // op code
    int op_code = htonl(3);
    struct iovec iov[2];
    // client uuid
    iov[0].iov_base = &client_UUID;
    iov[0].iov_len = sizeof(client_UUID);
    // op code
    iov[1].iov_base = &op_code;
    iov[1].iov_len = sizeof(op_code);
    if ((writev(client_fd, iov, 2)) < 0) {
        perror("error en sending subscription request");
        close(client_fd);
        return -1;
    }
    int op_succes;
    recv(client_fd, &op_succes, sizeof(op_succes), MSG_WAITALL);  // reception of op success
    if (op_succes == 0) {
        int rec_topic_size, rec_event_size;
        // topic name size
        recv(client_fd, &rec_topic_size, sizeof(rec_topic_size), MSG_WAITALL);  // reception of topic name size
        rec_topic_size = ntohl(rec_topic_size);                                 // conversion to host
        char *topic_name = malloc(rec_topic_size + 1);                          // allocation for incoming topic name
        recv(client_fd, topic_name, rec_topic_size, MSG_WAITALL);               // reception of topic name
        topic_name[rec_topic_size] = '\0';
        *ptr_topic = topic_name;  // assignment pf given pointer to event_size
        // event size
        recv(client_fd, &rec_event_size, sizeof(rec_event_size), MSG_WAITALL);  // reception of event size
        rec_event_size = ntohl(rec_event_size);                                 // conversion to host
        *ptr_event_size = rec_event_size;                                       // assignment of given pointer to event_size
        void *event = malloc(rec_event_size);                                   // allocation for incoming event message
        // event
        recv(client_fd, event, rec_event_size, MSG_WAITALL);  // reception of event
        *ptr_event = event;                                   // assignment of given pointer to event
    } else {
        *ptr_event_size = op_succes;  // event
    }
    return op_succes;
}
// operation 4
// returns the amount of topics present in the system
int topics() {
    // fprintf(stderr, "Requesting amount of topics registered\n");
    int op_code = htonl(4);
    struct iovec iov[2];
    // client uuid
    iov[0].iov_base = &client_UUID;
    iov[0].iov_len = sizeof(client_UUID);
    // op code
    iov[1].iov_base = &op_code;
    iov[1].iov_len = sizeof(op_code);

    if ((writev(client_fd, iov, 2)) < 0) {
        perror("error en sending subscription request");
        close(client_fd);
        return -1;
    }
    uint32_t tmp, response;
    recv(client_fd, &tmp, sizeof(tmp), MSG_WAITALL);
    response = ntohl(tmp);
    return response;
}
// operation 5
// returns the amount of clients present in the system
int clients() {
    // fprintf(stderr, "Requesting amount of clients registered\n");
    int op_code = htonl(5);
    struct iovec iov[2];
    // client uuid
    iov[0].iov_base = &client_UUID;
    iov[0].iov_len = sizeof(client_UUID);
    // op code
    iov[1].iov_base = &op_code;
    iov[1].iov_len = sizeof(op_code);

    if ((writev(client_fd, iov, 2)) < 0) {
        perror("error en sending subscription request");
        close(client_fd);
        return -1;
    }
    int tmp, response;
    recv(client_fd, &tmp, sizeof(tmp), MSG_WAITALL);
    response = ntohl(tmp);
    return response;
}
// operation 6
// returns the amount of subscribers to the given topic present in the system
int subscribers(const char *topic) {
    // fprintf(stderr, "Requesting amount of subscribed clients to topic '%s'\n", topic);
    int op_code = htonl(6);
    struct iovec iov[4];
    // op code
    // client uuid
    iov[0].iov_base = &client_UUID;
    iov[0].iov_len = sizeof(client_UUID);
    // op code
    iov[1].iov_base = &op_code;
    iov[1].iov_len = sizeof(op_code);
    // size of topic name
    int topic_len = strlen(topic);
    int arg_size = htonl(topic_len);
    iov[2].iov_base = &arg_size;
    iov[2].iov_len = sizeof(arg_size);
    // topic name
    iov[3].iov_base = topic;
    iov[3].iov_len = topic_len;

    if ((writev(client_fd, iov, 4)) < 0) {
        perror("error en sending subscription request");
        close(client_fd);
        return -1;
    }
    int response;
    recv(client_fd, &response, sizeof(response), MSG_WAITALL);
    return ntohl(response);
}
// operation 7
// returns the amount of events pending for the user
int events() {
    // fprintf(stderr, "Requesting amount of events in queue for client\n");
    int op_code = htonl(7);
    struct iovec iov[2];
    // client uuid
    iov[0].iov_base = &client_UUID;
    iov[0].iov_len = sizeof(client_UUID);
    // op code
    iov[1].iov_base = &op_code;
    iov[1].iov_len = sizeof(op_code);
    if ((writev(client_fd, iov, 2)) < 0) {
        perror("error en sending subscription request");
        close(client_fd);
        return -1;
    }
    int response;
    recv(client_fd, &response, sizeof(response), MSG_WAITALL);
    return ntohl(response);
}
