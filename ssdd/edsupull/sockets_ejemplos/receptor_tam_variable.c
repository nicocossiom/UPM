#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>

struct cabecera {
	int long1;
	int long2;
};
int main(int argc, char *argv[]) {
	int s, s_conec;
	unsigned int tam_dir;
	struct sockaddr_in dir, dir_cliente;
	int opcion=1;

	if (argc!=2) {
		fprintf(stderr, "Uso: %s puerto\n", argv[0]);
		return 1;
	}
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
		tam_dir=sizeof(dir_cliente);
		if ((s_conec=accept(s, (struct sockaddr *)&dir_cliente, &tam_dir))<0){
			perror("error en accept");
			close(s);
			return 1;
		}
		struct cabecera cab;
		recv(s_conec, &cab, sizeof(cab), MSG_WAITALL);
		int tam1=ntohl(cab.long1);
		int tam2=ntohl(cab.long2);
		char *dato1 = malloc(tam1+1);
		char *dato2 = malloc(tam2+1);
		recv(s_conec, dato1, tam1, MSG_WAITALL);
		recv(s_conec, dato2, tam2, MSG_WAITALL);
		dato1[tam1]='\0';
		dato2[tam2]='\0';
		close(s_conec);
		printf("dato1 %s dato2 %s\n", dato1, dato2);
	}
	close(s);
	return 0;
}
