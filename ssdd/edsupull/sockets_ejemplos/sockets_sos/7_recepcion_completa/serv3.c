#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

#define TAM 256

static void imprime_buffer(unsigned char *buf, int tam) {
	static int num_mens=0;

	printf("Recibido: tam %d (mens %d byte %d - ",
		tam, num_mens, buf[0]);
	if (buf[tam-1]<buf[0]) num_mens++;
	printf("mens %d byte %d)\n", num_mens, buf[tam-1]);
	if (buf[tam-1]==255) num_mens++;
}

int main(int argc, char *argv[]) {
	int s, s_conec, leido;
	unsigned int tam_dir;
	struct sockaddr_in dir, dir_cliente;
	unsigned char buf[TAM];

	setbuf(stdout, NULL);
	if (argc!=2) {
                fprintf(stderr, "Uso: %s puerto\n", argv[0]);
                return 1;
        }
	if ((s=socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
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
	if (listen(s, 5) < 0) {
		perror("error en listen");
		close(s);
		return 1;
	}
	while (1) {
		tam_dir=sizeof(dir_cliente);
		if ((s_conec=accept(s, (struct sockaddr *)&dir_cliente, &tam_dir))<0){
			perror("error en accept");
			close(s);
			return 1;
		}
		while ((leido=recv(s_conec, buf, TAM, MSG_WAITALL))>0)
			imprime_buffer(buf, leido);
		if (leido<0) {
			perror("error en read");
			close(s);
			close(s_conec);
			return 1;
		}
		close(s_conec);
	}
	close(s);

	return 0;
}
