#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <string.h>
#include <unistd.h>

int main(int argc, char* argv[]) 
{
  int i,c,sd;
  struct sockaddr_in server_addr;
  struct hostent *hp;
  long int num[2], res;

  if (argc!=5) {
	fprintf(stderr, "Uso: %s servidor puerto primer_sumando segundo_sumando\n", argv[0]);
	return 1;
  }
  sd = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);	
	
  bzero((char *)&server_addr, sizeof(server_addr));
  hp = gethostbyname (argv[1]);
        
  server_addr.sin_addr=*(struct in_addr *)hp->h_addr;
  server_addr.sin_family = AF_INET;
  server_addr.sin_port = htons(atoi(argv[2]));	
	
  // se establece la conexión
  connect(sd, (struct sockaddr *) &server_addr, sizeof(server_addr));

  num[0]=htonl(atoi(argv[3]));
  num[1]=htonl(atoi(argv[4]));

  write(sd, (char *) num, 2 *sizeof(long int));	// envía la petición

  for(i=0;
      i<sizeof(long int) &&
      (c=read(sd,((char *)&res)+i,sizeof(long int)-i))>0;
      i+=c);   // recibe la respuesta       
	
  printf("Resultado es %d \n", ntohl(res));
  close (sd);

  return 0;
}
