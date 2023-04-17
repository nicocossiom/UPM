#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>

int main(int argc, char *argv[]) {
	int s, tam = 4096, leido;
	unsigned int tam_dir;
	struct sockaddr_in dir, dir_cliente;

	if (argc!=3) {
		fprintf(stderr, "Uso: %s puerto tam_recibir\n", argv[0]);
		return 1;
	}
	tam=atoi(argv[2]);
        char *buf=malloc(tam);
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
	printf("después del bind; pulse para seguir "); getchar();
	while(1) {
		tam_dir=sizeof(dir_cliente);
		if ((leido=recvfrom(s, buf, tam, 0,
                    (struct sockaddr *)&dir_cliente, &tam_dir))<0){
                        perror("error en recvfrom");
                        close(s);
                        return 1;
                }
		printf("leido %d\n", leido);
	}
	close(s);
	return 0;
}
