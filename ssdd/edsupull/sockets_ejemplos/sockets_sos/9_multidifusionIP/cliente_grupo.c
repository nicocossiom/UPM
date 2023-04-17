#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

/* Es igual que cualquier cliente UDP pero usa una dirección de multidifusión en
   el bind (239.0.0.1) */

#define TAM 1024

int main(int argc, char *argv[]) {
	int s, leido;
	struct sockaddr_in dir;
	char buf[TAM];
	struct in_addr dir_grupo;

        if (argc!=2) {
                fprintf(stderr, "Uso: %s puerto\n", argv[0]);
                return 1;
        }
	if ((s=socket(PF_INET, SOCK_DGRAM, IPPROTO_UDP)) < 0) {
		perror("error creando socket");
		return 1;
	}

	inet_aton("239.0.0.1", &dir_grupo);
	dir.sin_addr=dir_grupo;

	dir.sin_port=htons(atoi(argv[1]));
	dir.sin_family=PF_INET;

	while ((leido=read(0, buf, TAM))>0) {
                if (sendto(s, buf, leido, 0,
		    (struct sockaddr *)&dir, sizeof(dir))<0){
                        perror("error en sendto");
                        close(s);
                        return 1;
                }
        }

	return 0;
}
