#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {
	int s, escrito;
	if (argc!=5) {
		fprintf(stderr, "Uso: %s servidor puerto dato1 dato2\n", argv[0]);
		return 1;
	}
	if ((s=socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
		perror("error creando socket");
		return 1;
	}
        struct addrinfo *res;
        if (getaddrinfo(argv[1], argv[2], NULL, &res)!=0) {
                perror("error en getaddrinfo");
                close(s);
                return 1;
        }
        if (connect(s, res->ai_addr, res->ai_addrlen) < 0) {
                perror("error en connect");
                close(s);
                return 1;
        }
        freeaddrinfo(res);
        if ((escrito=send(s, argv[3], strlen(argv[3]), MSG_MORE))<0) {
        	perror("error en write");
        	close(s);
        	return 1;
        }
	printf("escrito %d\n", escrito);
        if ((escrito=send(s, argv[4], strlen(argv[4]), MSG_MORE))<0) {
        	perror("error en write");
        	close(s);
        	return 1;
        }
	printf("escrito %d\n", escrito);
	return 0;
}
