#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

#define TAM 1024

int main(int argc, char *argv[]) {
	int s, leido;
	unsigned int tam_dir;
	struct sockaddr_in dir, dir_cliente;
	char buf[TAM];

	if (argc!=2) {
                fprintf(stderr, "Uso: %s puerto\n", argv[0]);
                return 1;
        }
	if ((s=socket(PF_INET, SOCK_DGRAM, IPPROTO_UDP)) < 0) {
		perror("error creando socket");
		return 1;
	}
	dir.sin_addr.s_addr=INADDR_ANY;
	dir.sin_port=htons(atoi(argv[1]));
	dir.sin_family=PF_INET;
	if (bind(s, (struct sockaddr *)&dir, sizeof(dir)) < 0) {
		perror("error en bind");
		close(s);
		return 1;
	}

	while (1) {
		tam_dir=sizeof(dir_cliente);
		if ((leido=recvfrom(s, buf, TAM, 0,
		    (struct sockaddr *)&dir_cliente, &tam_dir))<0){
			perror("error en recvfrom");
			close(s);
			return 1;
		}

		if (sendto(s, buf, leido, 0,
		    (struct sockaddr *)&dir_cliente, tam_dir)<0){
			perror("error en sendto");
			close(s);
			return 1;
		}

	}

	close(s);

	return 0;
}
