#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <sys/uio.h>
#include <sys/stat.h>
#include <sys/mman.h>

int main(int argc, char *argv[]) {
	int s, f;
	struct stat st;
	if (argc<4) {
		fprintf(stderr, "Uso: %s servidor puerto fichero...\n", argv[0]);
		return 1;
	}
	if ((s=socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
		perror("error creando socket");
		return 1;
	}
        struct addrinfo *res;
        if (getaddrinfo(argv[1], argv[2], NULL, &res)!=0) {
                perror("error en getaddrinfo");
                close(s);
                return 1;
        }
        if (connect(s, res->ai_addr, res->ai_addrlen) < 0) {
                perror("error en connect");
                close(s);
                return 1;
        }
        freeaddrinfo(res);
	for (int i=3; i<argc; i++) {
	       if ((f = open(argv[i], O_RDONLY))<0) {
                   perror("error abriendo fichero");
                   continue;
                }
                fstat(f, &st);
		int tam=st.st_size;
		int tamn=htonl(tam);
		void *p = mmap(NULL, tam, PROT_READ|PROT_WRITE, MAP_PRIVATE, f, 0);
        	close(f);
		struct iovec iov[2];
		iov[0].iov_base=&tamn;
		iov[0].iov_len=sizeof(tamn);
		iov[1].iov_base=p;
		iov[1].iov_len=tam;
        	if (writev(s, iov, 2)<0) {
        		perror("error en writev");
        		close(s);
        		continue;
        	}
		if (recv(s, p, tam, MSG_WAITALL)<0) {
        		perror("error en recv");
        		close(s);
        		continue;
        	}
		write(1, p, tam);
		munmap(p, tam);
        }
        close(s);
	return 0;
}
