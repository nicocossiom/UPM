#include <arpa/inet.h>
#include <netdb.h>
#include <netinet/in.h>
#include <pthread.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <unistd.h>

#include "comun.h"
#include "map.h"
#include "queue.h"
#include "set.h"

typedef struct Topic {
    char* topic_name;
    set* set_subscribed;
} Topic;
typedef struct Client {
    char* uuid;
    queue* event_queue;
    set* client_subbed_topics;
} Client;
typedef struct Event {
    void* event_value;
    int counter;
    Topic* event_topic;
    int event_size;
} Event;

void destroy_client(Client* client);
static map* clients_map;
static map* topics_map;

int server_fd;

void sighandler() {
    close(server_fd);
    // fprintf(stderr, "\n\n\t\tCLOSING BROKER\n\n");
    exit(0);
}

// instiantiates a new topic and its values given its name
Topic* topic_create(char* topic_name) {
    Topic* newTopic = malloc(sizeof(struct Topic));
    newTopic->topic_name = strdup(topic_name);
    newTopic->set_subscribed = set_create(0);
    return newTopic;
}
Event* event_create(int event_size, Topic* topic) {
    Event* newEvent = (Event*)malloc(sizeof(Event));
    newEvent->event_value = malloc(event_size);
    newEvent->counter = 0;
    newEvent->event_topic = topic;
    newEvent->event_size = event_size;
    return newEvent;
}

// returns a pointer to a map of topics -> topics<char* topic_name, Topic topic>
map* load_topics(char* topics_file) {
    FILE* p_topics_file = fopen(topics_file, "r");
    if (p_topics_file == NULL) {
        // fprintf(stderr, "error reading topics file '%s'", topics_file);
        exit(EXIT_FAILURE);
    }
    map* map_topics;
    if ((map_topics = map_create(key_string, 0)) == NULL) {
        // fprintf(stderr, "error creating topics map while reading topics file '%s'", topics_file);
        exit(EXIT_FAILURE);
    }
    char* line = NULL;
    while (fscanf(p_topics_file, "%ms", &line) != EOF) {
        Topic* newTopic = topic_create(line);
        map_put(map_topics, newTopic->topic_name, newTopic);
    }
    fclose(p_topics_file);
    if (line) free(line);
    // fprintf(stderr, "Topics successfully loaded from file %s\n", topics_file);
    return map_topics;
}

void destroy_event(Event* event) {
    free(event->event_value);
    free(event);
}

void destroy_event_if_last(void* e) {
    Event* event = (Event*)e;
    if (event->counter == 1) {
        destroy_event(event);
    } else {
        event->counter--;
    }
}

void destroy_client(Client* client) {
    // destroy the queue and the event if it the client is the last to get it
    queue_destroy(client->event_queue, destroy_event_if_last);
    // destroy the set not the topics themselves
    set_destroy(client->client_subbed_topics, NULL);
    map_remove_entry(clients_map, client->uuid, NULL);
    free(client);
}

int register_client(char* client_uuid, int client_socket) {
    int error;
    int response = 0;
    map_get(clients_map, client_uuid, &error);
    if (error != -1) {
        send(client_socket, &response, sizeof(response), 0);
        return 1;
    }
    // client is already registered
    // client is not registered
    Client* client = malloc(sizeof(struct Client));
    client->uuid = strdup(client_uuid);
    client->event_queue = queue_create(0);
    client->client_subbed_topics = set_create(0);

    if (map_put(clients_map, client_uuid, client) < 0) {
        // fprintf(stderr, "Error putting new client into clients_map");
        destroy_client(client);
        close(client_socket);
        return -1;
    }
 
    send(client_socket, &response, sizeof(response), 0);
    return 0;
}

// return the client if in the clients_map, else returns NULL and sends the appropiate response to the server
Client* get_and_check_client(char* client_uuid, int client_socket) {
    int map_op, response;
    Client* client = map_get(clients_map, client_uuid, &map_op);
    // if (map_op == -1) {
    //     // client is not registered
    //     //// fprintf(stderr, "\tClient is not registered, sending response\n");
    //     response = -1;
    //     send(client_socket, &response, sizeof(response), 0);
    //     return NULL;
    // }
    return client;
}
// return the client if in the clients_map, else returns NULL and sends the appropiate response to the server
Topic* get_and_check_topic(char* topic_name, int option, int client_socket) {
    int map_op, response;
    Topic* topic = map_get(topics_map, topic_name, &map_op);
    if (map_op == -1 && option == 1) {
        // client is not registered
        // fprintf(stderr, "\tTopic does not exist, sending response\n");
        response = -1;
        send(client_socket, &response, sizeof(response), 0);
        return NULL;
    }
    return topic;
}

void print_event(void* ev) {
    Event* event = ev;
    // fprintf(stderr, "\nIMPRIMIENDO TOPIC DE EVENTO\n %s", event->event_topic->topic_name);
}

// returns the topic name, recieves the size of the topic, allocates for it and then recieves the topic name itself
char* get_topic_by_rec_size_nthen_name(int client_socket) {
    int topic_name_size;
    recv(client_socket, &topic_name_size, sizeof(int), MSG_WAITALL);
    int size = ntohl(topic_name_size);
    char* topic_name = malloc(size + 1);
    recv(client_socket, topic_name, size, MSG_WAITALL);
    topic_name[size] = '\0';
    return topic_name;
}

void* service(void* socket) {
    int client_socket;
    client_socket = (long)socket;
    // client sends operation code
    char client_uuid[37];
    while (recv(client_socket, &client_uuid, sizeof(client_uuid), MSG_WAITALL) > 0) {
        int msg2;
        recv(client_socket, &msg2, sizeof(msg2), MSG_WAITALL);
        // shared variables from all/most operations
        int op_code = ntohl(msg2);
        // printf("%s requested operation %d: \n", client_uuid, op_code);
        int response;
        Topic* topic;
        Client* client = get_and_check_client(client_uuid, client_socket);
        switch (op_code) {
            // subscribe
            case 0: {
                char* topic_name = get_topic_by_rec_size_nthen_name(client_socket);
                // fprintf(stderr, "\tSubscribing to topic %s\n", topic_name);
                if ((topic = get_and_check_topic(topic_name, 1, client_socket)) != NULL) {
                    if ((set_contains(client->client_subbed_topics, topic) == 1) &&
                        (set_contains(topic->set_subscribed, client) == 1)) {
                        // client is already subscribed to topic
                        // fprintf(stderr, "\tClient is already subscribed to topic, sending response\n");
                        response = -1;
                        send(client_socket, &response, sizeof(response), 0);
                    } else if (set_add(client->client_subbed_topics, topic) == 0 &&
                               set_add(topic->set_subscribed, client) == 0) {
                        // Client correct suscription
                        response = 0;
                        send(client_socket, &response, sizeof(response), 0);
                        // fprintf(stderr, "\tSuccesfully subscribed to topic, sending response\n");
                    }
                }
            } break;

            // unsubscribe
            case 1: {
                response = -1;
                if ((topic = get_and_check_topic(get_topic_by_rec_size_nthen_name(client_socket), 1, client_socket)) == NULL) {
                    break;
                }
                // fprintf(stderr, "\tUnsubscribing to topic %s\n", topic->topic_name);
                if ((set_contains(client->client_subbed_topics, topic) == 1) &&
                    (set_contains(topic->set_subscribed, client) == 1)) {
                    // client is subscribed to topic, let's remove it from sets
                    if ((set_remove(client->client_subbed_topics, topic, NULL) == 0) &&
                        (set_remove(topic->set_subscribed, client, NULL) == 0)) {
                        response = 0;
                        send(client_socket, &response, sizeof(response), 0);
                        // fprintf(stderr, "\tSuccesfully unsubscribed to topic, sending response\n");
                    } else {
                        perror("Fail removing client from sets");
                        response = -1;
                        send(client_socket, &response, sizeof(response), 0);
                    }
                } else {
                    // fprintf(stderr, "\tClient is not subscribed to topic, sending response\n");
                    send(client_socket, &response, sizeof(response), 0);
                }
            } break;

            // publish
            case 2: {
                topic = get_and_check_topic(get_topic_by_rec_size_nthen_name(client_socket), 0, client_socket);
                // // fprintf(stderr, "\tPublishing to topic %s\n", topic->topic_name);
                //  first we recieve the event size
                int event_size;
                recv(client_socket, &event_size, sizeof(int), MSG_WAITALL);
                event_size = ntohl(event_size);
                // fprintf(stderr, "\tRecieving event of size '%d'\n", event_size);
                Event* event = event_create(event_size, topic);
                // then we store the event in the event structure
                recv(client_socket, event->event_value, event_size, MSG_WAITALL);
                if (topic) {
                    set_iter* i = set_iter_init(topic->set_subscribed);
                    for (; set_iter_has_next(i); set_iter_next(i)) {
                        Client* client = (Client*)set_iter_value(i);
                        queue_push_back(client->event_queue, event);
                        // we add one to the counter that keeps track of how many clients are subbed to the topic
                        event->counter++;
                        // queue_visit(client->event_queue, print_event);
                    }
                    set_iter_exit(i);
                    response = 0;
                    // fprintf(stderr, "\tSuccesfully recieved and created event, sending response\n");
                    send(client_socket, &response, sizeof(response), 0);
                } else {
                    response = -1;
                    // fprintf(stderr, "\tError, topic doesn't exist, sending response\n");
                    send(client_socket, &response, sizeof(response), 0);
                }

            } break;
            // get
            case 3: {
                int op_status;
                response = -1;
                // if there are no events in the client's queue we simply return 0 on the last return val
                // fprintf(stderr, "\tGetting client's '%s' latest event in queue\n", client->uuid);
                if (queue_length(client->event_queue) == 0) {
                    send(client_socket, &response, sizeof(response), 0);
                } else {
                    Event* event = queue_pop_front(client->event_queue, &op_status);
                    if (op_status == -1) {
                        // fprintf(stderr, "\tError getting event from client's event queue\n");
                        send(client_socket, &response, sizeof(response), 0);
                    } else {
                        char* event_topic = event->event_topic->topic_name;
                        response = 0;  // op_success
                        struct iovec iov[5];
                        iov[0].iov_base = &response;
                        iov[0].iov_len = sizeof(response);
                        int topic_size = htonl(sizeof(event_topic));
                        iov[1].iov_base = &topic_size;
                        iov[1].iov_len = sizeof(topic_size);
                        iov[2].iov_base = event_topic;
                        iov[2].iov_len = sizeof(event_topic);
                        int event_size = htonl(event->event_size);
                        iov[3].iov_base = &event_size;
                        iov[3].iov_len = sizeof(event_size);
                        iov[4].iov_base = event->event_value;
                        iov[4].iov_len = event->event_size;
                        // fprintf(stderr, "\tSuccesfully aquired event from client's event queue, sending response\n");
                        if ((writev(client_socket, iov, 5)) < 0) {
                            perror("error en sending subscription request");
                            close(client_socket);
                            break;
                        }
                        event->counter--;
                        if (event->counter == 0) {
                            destroy_event(event);
                        }
                    }
                }
            } break;

            // topics
            case 4: {
                response = htonl(map_size(topics_map));
                // fprintf(stderr, "\tSending amount of registered topics");
                send(client_socket, &response, sizeof(response), 0);
            } break;
            // clients
            case 5: {
                response = htonl(map_size(clients_map));
                // fprintf(stderr, "\tSending amount of registered clients");
                send(client_socket, &response, sizeof(response), 0);
            } break;

            // subscribers
            case 6: {
                topic = get_and_check_topic(get_topic_by_rec_size_nthen_name(client_socket), 1, client_socket);
                // fprintf(stderr, "\tGetting subscribed clients of topic %s\n", topic->topic_name);
                if (topic) {
                    int subscribed = set_size(topic->set_subscribed);
                    response = htonl(subscribed);
                    // fprintf(stderr, "\tSuccess, sending response\n");
                    send(client_socket, &response, sizeof(response), 0);
                }
            } break;
            // events
            case 7: {
                response = htonl(queue_length(client->event_queue));
                send(client_socket, &response, sizeof(response), 0);
            } break;
            case 8: {
                set_iter* i = set_iter_init(client->client_subbed_topics);
                for (; set_iter_has_next(i); set_iter_next(i)) {
                    Topic* topic = (Topic*)set_iter_value(i);
                    set_remove(topic->set_subscribed, client, NULL);
                }
                destroy_client(client);
                response = htonl(0);
                send(client_socket, &response, sizeof(response), 0);
                close(client_socket);
                // fprintf(stderr, "Ending client's '%s' connection\n", client_uuid);
                pthread_exit(NULL);
            } break;
            case 9: {
                // printf("New connection: ");
                //  client sends first connection message with uuid
                if (register_client(client_uuid, client_socket) == 0)
                    printf("new client'%s' successfully registered\n", client_uuid);
                else
                    printf("client'%s' is already registered\n", client_uuid);
            } break;
            default:
                // fprintf(stderr, "Client '%s' sent an incorrect operation code\n", client_uuid);
                break;
        }
    }
    close(client_socket);
    return 0;
}

int main(int argc, char* argv[]) {
    if (argc != 3) {
        // fprintf(stderr, "Uso: %s puerto fichero_temas\n", argv[0]);
        return 1;
    }
    if (signal(SIGINT, &sighandler) == SIG_ERR) {
        // fprintf(stderr, "Could not set signal handler\n");
        exit(EXIT_FAILURE);
    }
    int ret, option, fd_new_socket;
    struct sockaddr_in server_addr, client_addr;
    unsigned int addrlen = sizeof(server_addr);
    // socket creation
    if ((server_fd = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
        perror("socket creation failed");
        exit(EXIT_FAILURE);
    }

    // socket reusability
    if (setsockopt(server_fd, SOL_SOCKET, SO_REUSEADDR, &option, sizeof(option)) < 0) {
        perror("error in setsockopt");
        exit(EXIT_FAILURE);
    }
    // socket address configuration
    server_addr.sin_family = PF_INET;
    server_addr.sin_addr.s_addr = INADDR_ANY;
    server_addr.sin_port = htons(atoi(argv[1]));
    // socket binding to port
    if (bind(server_fd, (struct sockaddr*)&server_addr, sizeof(server_addr)) < 0) {
        perror("error in server address binding");
        close(server_fd);
        exit(EXIT_FAILURE);
    }
    // server starts listening
    listen(server_fd, 1);
    // server hostname
    char hostname[128] = {0};
    char servername[128] = {0};
    struct addrinfo hint;
    struct addrinfo* ai;
    struct addrinfo* curr;
    char ipstr[16] = {0};
    if ((ret = getnameinfo((struct sockaddr*)&server_addr, &addrlen, hostname, sizeof(hostname), servername, sizeof(servername), 0)) != 0) {
        // printf("error in getnameinfo: %s \n", gai_strerror(ret));
    } else {
        bzero(&hint, sizeof(hint));  // Información de pista de relleno
        hint.ai_family = AF_INET;
        hint.ai_socktype = SOCK_STREAM;
        hint.ai_flags = AI_CANONNAME;  // Notificar para devolver el nombre canónico del host, de lo contrario, no volverá.
        if (getaddrinfo(hostname, NULL, &hint, &ai) == 0) {
            inet_ntop(AF_INET, &(((struct sockaddr_in*)(ai->ai_addr))->sin_addr), ipstr, 16);
            // fprintf(stderr, "Server starting @%s:%d\n", ipstr, ntohs(server_addr.sin_port));
        }
    }
    topics_map = load_topics(argv[2]);
    if ((clients_map = map_create(key_string, 0)) == NULL) {
        // fprintf(stderr, "error creating client map");
        exit(EXIT_FAILURE);
    }
    pthread_t thread_id;
    pthread_attr_t thread_attr;
    pthread_attr_init(&thread_attr);  // evita pthread_join
    pthread_attr_setdetachstate(&thread_attr, PTHREAD_CREATE_DETACHED);
    // service loop
    while (1) {
        if ((fd_new_socket = accept(server_fd, (struct sockaddr*)&client_addr, &addrlen)) > 0) {
            // create a new socket that executes the service routine with the newily created socket_fd
            // from the connection as the argument
            pthread_create(&thread_id, &thread_attr, service, (void*)(long)fd_new_socket);
        }
    }
    close(server_fd);
    return 0;
}
