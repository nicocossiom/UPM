#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/select.h>

#define TAM 1024

int main(int argc, char *argv[]) {
	int i, s, s_conec, leido, ndesc;
	unsigned int tam_dir;
	struct sockaddr_in dir, dir_cliente;
	char buf[TAM];
	int opcion=1;
	fd_set desc_sockets; 
	fd_set desc_sockets_copia; 

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

	FD_ZERO(&desc_sockets); 
	FD_SET(s, &desc_sockets); 
	while (1) {
		desc_sockets_copia=desc_sockets; 
		if ((ndesc=select(FD_SETSIZE, &desc_sockets_copia,
				NULL, NULL, NULL))<0) {
			perror("error en select");
			close(s);
			return 1;
		}
		if (FD_ISSET(s, &desc_sockets_copia)) {
			ndesc--;

			tam_dir=sizeof(dir_cliente);
			if ((s_conec=accept(s, (struct sockaddr *)&dir_cliente,
					 &tam_dir))<0){
				perror("error en accept");
				close(s);
				return 1;
			}
			FD_SET(s_conec, &desc_sockets); 
		}
		for (i=0; ndesc; i++) {
			if (FD_ISSET(i, &desc_sockets_copia)) {
				ndesc--;
				if ((leido=read(i, buf, TAM))>0) {
					if (write(i, buf, leido)<0) {
						perror("error en write");
						close(s);
						return 1;
					}
				}
	
				if (leido<0) {
					perror("error en read");
					close(s);
					return 1;
				}
				if (leido==0) { // cliente cierra conexión
					close(i);
					FD_CLR(i, &desc_sockets); 
				}
			}
		}
	}

	close(s);

	return 0;
}
