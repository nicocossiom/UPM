#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
 
#define MAX 1024
int main(int argc, char *argv[])
{
        int s, lmens;
        struct sockaddr_in dir;
        char linea[MAX];
        char buffer[MAX];
	struct hostent *host_desc;
	FILE *desc_soc;
	char *res;
 
	if (argc!=4)
	{
		fprintf(stderr, "Uso: %s host puerto URL\n", argv[0]);
                exit(1);
        }
        if ((s=socket(PF_INET, SOCK_STREAM, 0))<0)
        {
                perror("Error creando socket");
                exit(1);
        }
 
        dir.sin_family=PF_INET;
        dir.sin_port=htons(atoi(argv[2]));
	
	host_desc= gethostbyname(argv[1]);
	dir.sin_addr = *(struct in_addr *) host_desc->h_addr;

	if (connect(s, (struct sockaddr *)&dir, sizeof(dir))<0)
        {
                perror("Error conectando socket");
                close (s);
                exit(1);
        }

	/* Habilito acceso a socket desde stdio */
	desc_soc=fdopen(s, "a+");
	if (fprintf(desc_soc,"GET %s HTTP/1.1\nHost: %s\nConnection: close\n\n",
		argv[3], argv[1])<0)
        {
                perror("Error escribiendo en socket");
                close (s);
                exit(1);
	}

	printf("********** CABECERA RECIBIDA *********\n");
	/* Leo la cabecera que termina con una línea sólo con CR Y LF */
	while ((res=fgets (linea, MAX, desc_soc))) {
		if ((linea[0]=='\r') && (linea[1]=='\n'))
			break;
		fputs(linea, stdout);
	}
	printf("********** FIN CABECERA *********\n\n");

	if (!res)
        {
                perror("Error leyendo en socket");
                close (s);
                exit(1);
	}

	printf("********** INICIO CUERPO *********\n\n");
	while ((lmens=fread (buffer, 1, MAX, desc_soc))>0) 
		fwrite(buffer, lmens, 1, stdout);
	
	printf("********** FIN CUERPO *********\n\n");

        close (s);
	return 0;
}
