#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>

int main(int argc, char *argv[]) {
	int s, tam = 4096, s_conec, leido, total=0;
	unsigned int tam_dir;
	struct sockaddr_in dir, dir_cliente;
	int opcion=1;

	if (argc!=3) {
		fprintf(stderr, "Uso: %s puerto tam_recibir\n", argv[0]);
		return 1;
	}
	tam=atoi(argv[2]);
        char *buf=malloc(tam);
	if ((s=socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
		perror("error creando socket");
		return 1;
	}
	/* Para reutilizar puerto inmediatamente */
        if (setsockopt(s, SOL_SOCKET, SO_REUSEADDR, &opcion, sizeof(opcion))<0){
                perror("error en setsockopt");
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
	while(1) {
		total=0;
		tam_dir=sizeof(dir_cliente);
		if ((s_conec=accept(s, (struct sockaddr *)&dir_cliente, &tam_dir))<0){
			perror("error en accept");
			close(s);
			return 1;
		}
		while ((leido=recv(s_conec, buf, tam, MSG_WAITALL))>0) {
			printf("leido %d\n", leido);
			total+=leido;
                }
		close(s_conec);
		printf("total %d\n", total);
	}
	close(s);
	return 0;
}
