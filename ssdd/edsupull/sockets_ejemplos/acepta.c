#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	int s, s_conec;
	unsigned int tam_dir;
	struct sockaddr_in dir, dir_cliente;

	if (argc!=3) {
		fprintf(stderr, "Uso: %s puerto valor_listen\n", argv[0]);
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
	printf("después del bind; pulse para seguir "); getchar();
	if (listen(s, atoi(argv[2])) < 0) {
		perror("error en listen");
		close(s);
		return 1;
	}
	printf("después del listen; pulse para seguir "); getchar();
	while(1) {
		tam_dir=sizeof(dir_cliente);
		if ((s_conec=accept(s, (struct sockaddr *)&dir_cliente, &tam_dir))<0){
			perror("error en accept");
			close(s);
			return 1;
		}
		printf("después del accept; pulse para seguir "); getchar();
		close(s_conec);
	}
	close(s);
	return 0;
}
