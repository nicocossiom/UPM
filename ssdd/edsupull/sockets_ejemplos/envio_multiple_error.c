#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

struct mensaje {
	char *dato1;
	char *dato2;
};
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
	struct mensaje m;
	m.dato1=argv[3];
	m.dato2=argv[4];
        if ((escrito=write(s, &m, sizeof(m)))<0) {
        	perror("error en write");
        	close(s);
        	return 1;
        }
	printf("escrito %d\n", escrito);
	return 0;
}
