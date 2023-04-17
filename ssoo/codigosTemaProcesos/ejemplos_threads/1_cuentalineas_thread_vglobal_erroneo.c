// Ejemplo que cuenta las líneas de los ficheros recibidos como argumentos
// usando un thread para cada uno.
// Usa una variable global para calcular total.
// Erróneo ya que requeriría sincronización en el acceso a v. global

#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

long tot=0;
void * cuenta(void *arg) {
	char *fichero = arg;
	FILE *f;
	int c;
	long nl=0;
	
	if ((f = fopen(fichero, "r"))!=NULL) {
		while ((c = fgetc(f)) != -1)
			if (c == '\n') nl++;
		printf("%s: %ld lineas\n", fichero, nl);
		tot+= nl;
		fclose(f);
	}
	else  
                fprintf(stderr, "%s: no existe el fichero\n", fichero);
	return NULL;
}

int main(int argc, char *argv[]) {
	pthread_t *thid;
	int i;

	thid = malloc((argc-1) * sizeof(pthread_t));
	for (i=1; i<argc; i++)
		if (pthread_create(&thid[i-1], NULL, cuenta, argv[i]) != 0) {
			perror("pthread_create");
			exit(1);
		}
	for (i=1; i<argc; i++) {
		if (pthread_join(thid[i-1], NULL) != 0) {
			perror("pthread_join");
			exit(1);
		}
	}
	
	free(thid);
	printf("Total: %ld lineas\n", tot);
	return 0;
}
