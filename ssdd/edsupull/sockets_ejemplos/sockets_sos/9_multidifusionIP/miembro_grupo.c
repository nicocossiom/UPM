#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

#define TAM 1024

int main(int argc, char *argv[]) {
	int s, leido;
	unsigned int tam_dir;
	struct sockaddr_in dir, dir_cliente;
	char buf[TAM];
	struct in_addr dir_mcast;
	struct ip_mreqn info_mcast;
	int opcion=1;

        if (argc!=2) {
                fprintf(stderr, "Uso: %s puerto\n", argv[0]);
                return 1;
        }
	if ((s=socket(PF_INET, SOCK_DGRAM, IPPROTO_UDP)) < 0) {
		perror("error creando socket");
		return 1;
	}
        /* Para reutilizar el puerto inmediatamente ya que en un grupo puede haber
	   varios procesos de la misma máquina  */
        if (setsockopt(s, SOL_SOCKET, SO_REUSEADDR, &opcion, sizeof(opcion))<0){
                perror("error en setsockopt");
                return 1;
        }

	/* Incorporación al grupo de multidifusión en la dirección 239.0.0.1 */
	inet_aton("239.0.0.1", &dir_mcast);
	info_mcast.imr_multiaddr=dir_mcast;
	info_mcast.imr_address.s_addr=INADDR_ANY;
	info_mcast.imr_ifindex=0;
	if (setsockopt(s, SOL_IP, IP_ADD_MEMBERSHIP, &info_mcast,
		sizeof(info_mcast)) <0) {
		perror("error en setsockopt");
                close(s);
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

		write(1, buf, leido);

	}

	close(s);

	return 0;
}
