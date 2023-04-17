#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
  struct sockaddr_in server_addr,  client_addr;
  int c,i,sd, sc, val;
  unsigned int size;
  long int num[2],  res;

  if (argc!=2) {
    fprintf(stderr, "Uso: %s puerto\n", argv[0]);
    return 1;
  }

  sd =  socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
  val = 1;
  setsockopt(sd, SOL_SOCKET, SO_REUSEADDR, (char *) &val, sizeof(int));
	
  bzero((char *)&server_addr, sizeof(server_addr));
  server_addr.sin_family = AF_INET;
  server_addr.sin_addr.s_addr = INADDR_ANY;	
  server_addr.sin_port = htons(atoi(argv[1]));

  bind(sd, (struct sockaddr *)&server_addr, sizeof(server_addr));
  listen(sd, 5);
  size = sizeof(client_addr);
  while (1)
    {
      sc = accept(sd, (struct sockaddr *)&client_addr,&size);
      
      for(i=0;
	  i<2*sizeof(long int) &&
	  (c=read(sc,((char *)num)+i,2*sizeof(long int)-i))>0;
	  i+=c);   // recibe la petición

      res = htonl(ntohl(num[0]) + ntohl(num[1]));

      write(sc, &res, sizeof(long int));	// se envía el resultado	
		
      close(sc);
    }

  close (sd);
  return 0;
}	

