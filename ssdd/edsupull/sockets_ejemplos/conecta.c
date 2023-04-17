#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
	int s ;

	if (argc!=3) {
		fprintf(stderr, "Uso: %s servidor puerto\n", argv[0]);
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
	printf("después del connect\n");
	return 0;
}
