// Ejemplo de un servidor que recibe a través de un FIFO nombres de ficheros
// y que cuenta las líneas de cada fichero recibido
// usando un thread para cada uno.

#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>

#define FIFO "/tmp/fifo"

void * cuenta(void *arg) {
	char *fich = arg;
	FILE *f;
	int c;
	long nl=0;
	
	if ((f = fopen(fich, "r"))!=NULL) {
		while ((c = fgetc(f)) != -1)
			if (c == '\n') nl++;
		fclose(f);
		printf("%s: %ld lineas\n", fich, nl);
	}
	else  {
                fprintf(stderr, "%s: no existe el fichero\n", fich);
		nl = -1;
	}
	free(fich);
	return NULL;
}

int main(int argc, char *argv[]) {
	pthread_t thid;
	pthread_attr_t tattr;
	FILE * fifo;
	char leido[128];
	char *fichero;

	unlink(FIFO);
	if (mkfifo(FIFO, 0600)<0) {
		perror("mkfifo");
		exit(1);
	}
	pthread_attr_init(&tattr);
	pthread_attr_setdetachstate(&tattr,PTHREAD_CREATE_DETACHED);
	while(1) {
		if ((fifo=fopen(FIFO, "r")) == NULL) {
			perror("open fifo");
			exit(1);
		}
		while(fscanf(fifo, "%128s", leido) != EOF) {
			fichero = strdup(leido);
			if (pthread_create(&thid, NULL, cuenta,
			   fichero) != 0) {
				perror("pthread_create");
				exit(1);
			}
		}
		fclose(fifo);
	}
	unlink(FIFO);
	pthread_attr_destroy(&tattr);
	return 0;
}
