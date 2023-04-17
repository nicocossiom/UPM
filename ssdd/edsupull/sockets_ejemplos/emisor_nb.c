#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>

int main(int argc, char *argv[]) {
	int s, tam, escrito;
	if (argc!=4) {
		fprintf(stderr, "Uso: %s servidor puerto tam_enviar\n", argv[0]);
		return 1;
	}
	tam=atoi(argv[3]);
	char *buf=malloc(tam);
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

	printf("después del connect; pulse para seguir "); getchar();

	int flags= fcntl(s, F_GETFL, 0);
	fcntl(s, F_SETFL, flags | O_NONBLOCK);
        if ((escrito=write(s, buf, tam))<0) {
        	perror("error en write");
        	close(s);
        	return 1;
        }
	printf("escrito %d\n", escrito);
	return 0;
}
