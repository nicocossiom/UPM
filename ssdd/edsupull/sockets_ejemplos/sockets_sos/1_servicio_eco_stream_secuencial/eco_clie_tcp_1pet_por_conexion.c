// 
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

#define TAM 1024

int main(int argc, char *argv[]) {
	int s, leido;
	struct sockaddr_in dir;
	struct hostent *host_info;
	char buf[TAM];

	if (argc!=3) {
		fprintf(stderr, "Uso: %s servidor puerto\n", argv[0]);
		return 1;
	}
	host_info=gethostbyname(argv[1]);
	// 2 alternativas
	//memcpy(&dir.sin_addr.s_addr, host_info->h_addr, host_info->h_length);
	dir.sin_addr=*(struct in_addr *)host_info->h_addr;
	dir.sin_port=htons(atoi(argv[2]));
	dir.sin_family=PF_INET;

	while ((leido=read(0, buf, TAM))>0) {
		if ((s=socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
			perror("error creando socket");
			return 1;
		}
		if (connect(s, (struct sockaddr *)&dir, sizeof(dir)) < 0) {
			perror("error en connect");
			close(s);
			return 1;
		}
                if (write(s, buf, leido)<0) {
                        perror("error en write");
                        close(s);
                        return 1;
                }
                if ((leido=read(s, buf, TAM))<0) {
                        perror("error en read");
                        close(s);
                        return 1;
                }
		write(1, buf, leido);
		close(s);
        }
	return 0;
}
