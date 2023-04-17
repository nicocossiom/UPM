#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

#define TAM 256
#define ITER 16

static void rellenar_mensaje(char *buf, int tam) {
	int i;
	for (i=0; i<tam; i++) buf[i]=i;
}
int main(int argc, char *argv[]) {
	int s;
	int i;
	struct sockaddr_in dir;
	struct hostent *host_info;
	char mens[TAM];

	if (argc!=3) {
		fprintf(stderr, "Uso: %s servidor puerto\n", argv[0]);
		return 1;
	}
	if ((s=socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
		perror("error creando socket");
		return 1;
	}
	if ((host_info=gethostbyname(argv[1]))==NULL) {
		fprintf(stderr, "error en gethostbyname: %s\n", argv[1]);
                close(s);
                return 1;
        }
	dir.sin_addr=*((struct in_addr *)host_info->h_addr);
	dir.sin_port=htons(atoi(argv[2]));
	dir.sin_family=PF_INET;
	if (connect(s, (struct sockaddr *)&dir, sizeof(dir)) < 0) {
		perror("error en connect");
		close(s);
		return 1;
	}

	rellenar_mensaje(mens, TAM); 	// para que tenga un contenido
					// conocido a priori

	for (i=0; i<ITER; i++)
                if (write(s, mens, TAM)<0) {
                        perror("error en write");
                        close(s);
                        return 1;
                }

	return 0;
}
