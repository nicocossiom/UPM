#include <sys/socket.h>
#include <sys/stat.h>
#include <time.h>
#include <sys/times.h>
#include <netinet/in.h>
#include <stdio.h>
#include <unistd.h>
#include <limits.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <sys/mman.h>
#include <sys/uio.h>

#define TAM 4096

static int crear_socket(int puerto);
static int recibir_peticion(int s, char *pagina);
static void preparar_cabecera(int tam_fich, char *cabecera);
static int abrir_fichero(char *fich, int *tam_fich, int *tam_acceso_recom);

int main(int argc, char *argv[]) {
	int s, f, s_conec;
	int tam_fich, tam_acceso_recom;
        struct tms to, tn;
        clock_t t0, t1;
        char cabecera[TAM];
        char pagina[PATH_MAX];
	void *p;
	struct iovec iov[2];

        if (argc!=2) {
                fprintf(stderr, "Uso: %s puerto\n", argv[0]); return 1;
        }
	s=crear_socket(atoi(argv[1]));
	while (1) {
                s_conec=recibir_peticion(s, pagina);
                f=abrir_fichero(pagina, &tam_fich, &tam_acceso_recom);
                preparar_cabecera(tam_fich, cabecera);

		t0=times(&to);
		p = mmap(NULL, tam_fich, PROT_READ, MAP_PRIVATE, f, 0);
		close(f);
		madvise(p, tam_fich, MADV_SEQUENTIAL);
	        iov[0].iov_base = cabecera; iov[0].iov_len = strlen(cabecera);
        	iov[1].iov_base = p; iov[1].iov_len = tam_fich;
        	writev(s_conec, iov, 2);
		close(s_conec);
		munmap(p, tam_fich);
		t1=times(&tn);
		printf("Real %ld Usuario %ld Sistema %ld\n", t1-t0,
			tn.tms_utime-to.tms_utime,
			tn.tms_stime-to.tms_stime);
        }
	return 0;
}
static int crear_socket(int puerto) {
	int s;
	struct sockaddr_in dir;
	int opcion=1;

	if ((s=socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) < 0) {
		perror("error creando socket");
		return -1;
	}
        if (setsockopt(s, SOL_SOCKET, SO_REUSEADDR, &opcion, sizeof(opcion))<0){
                perror("error en setsockopt");
		close(s);
                return -1;
        }
	dir.sin_addr.s_addr=INADDR_ANY;
	dir.sin_port=htons(puerto);
	dir.sin_family=PF_INET;
	if (bind(s, (struct sockaddr *)&dir, sizeof(dir)) < 0) {
		perror("error en bind");
		close(s);
		return -1;
	}
	if (listen(s, 5) < 0) {
		perror("error en listen");
		close(s);
		return -1;
	}
	return s;
}
static int recibir_peticion(int s, char *pagina) {
	int s_conec;
	FILE *s_conec_f;
        char linea[TAM];

	if ((s_conec=accept(s, NULL, NULL))<0){
		perror("error en accept");
		close(s); 
		return -1;
	}
	if ((s_conec_f=fdopen(s_conec, "r"))==NULL) {
		perror("error en accept");
		close(s); close(s_conec); 
		return -1;
	}
	if (fgets(linea, TAM, s_conec_f)==NULL) {
		perror("error en fgets");
		close(s); fclose(s_conec_f); 
		return -1;
	}
	sscanf(linea, "%*s%s", pagina);
        return s_conec;
}

static int abrir_fichero(char *fich, int *tam_fich, int *tam_acceso_recom) {
	struct stat st;
	int f;
	if (fich[0]=='/') fich=&fich[1];
	if ((f = open(fich, O_RDONLY))<0) {
		perror("error abriendo fichero");
		return -1;
	}
        if (fstat(f, &st) == -1) {
                perror("error stat fichero");
                close(f);
                return -1;
	}
	*tam_fich = st.st_size;
	*tam_acceso_recom = st.st_blksize;
        return f;
}
static void preparar_cabecera(int tam_fich, char *cabecera) {
        char buff_fecha[TAM];
        time_t t;
        struct tm * fecha;

        time(&t);
        fecha=gmtime(&t);
        strftime (buff_fecha,sizeof(buff_fecha),"%a, %d %b %Y %H:%M:%S GMT",fecha);
        sprintf(cabecera, "HTTP/1.1 200 OK\nDate: %s\nContent-type: text/html\nContent-length: %d\n\n", buff_fecha, tam_fich);

}

