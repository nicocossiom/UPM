
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
#include <sys/stat.h>

struct info {
	char *f;
	long off;
};

long tam;

void * cuenta_trozo(void *arg) {
	struct  info *inf = arg;
	FILE *f;
	int c;
	long nl=0;
	char *fichero = inf->f;
	long off = inf->off;
	long nleer = tam;
	
	if ((f = fopen(fichero, "r"))!=NULL) {
		fseek(f, off, SEEK_SET);
		while (((nleer--)>0) && ((c = fgetc(f)) != -1))
			if (c == '\n') nl++;
		fclose(f);
	}
	else  {
                fprintf(stderr, "%s: no existe el fichero\n", fichero);
		nl = -1;
	}
	free(arg);
	return (void *)nl;
}
void * cuenta_fichero(void *arg) {
	long nl=0, totf=0;
 	struct stat st;
	int i;
	int nth;
	char *fichero = arg;
	pthread_t *thid;
	long off=0;
	struct  info *inf;

	if (stat(fichero, &st)==0) {
		nth = st.st_size/tam;
		if (st.st_size%tam) nth++;
		thid = malloc(nth * sizeof(pthread_t));
		for (i=0; i<nth; i++) {
			inf = malloc(sizeof(struct info));
			inf->f=fichero;
			inf->off=off;
			if (pthread_create(&thid[i], NULL, cuenta_trozo,
			   inf) != 0) {
				perror("pthread_create");
				exit(1);
			}
			off+=tam;
		}
		for (i=0; i<nth; i++) {
			if (pthread_join(thid[i], ((void **)&nl)) != 0) {
				perror("pthread_join");
				exit(1);
			}
			if (nl != -1)
				totf+= nl;
		}
		free(thid);
		printf("%s: %ld lineas\n", fichero, totf);
	}
	else  {
                fprintf(stderr, "%s: no existe el fichero\n", fichero);
		totf = -1;
	}
	return (void *)totf;
}

int main(int argc, char *argv[]) {
	pthread_t *thid;
	int i;
	long nl, tot=0;

	if (argc < 3) {
		fprintf(stderr, "Uso: %s tam fich...\n", argv[0]);
		return 1;
	}
	tam=atoi(argv[1]);
	thid = malloc((argc-2) * sizeof(pthread_t));
	for (i=2; i<argc; i++) {
		if (pthread_create(&thid[i-2], NULL, cuenta_fichero, argv[i])!=0){
			perror("pthread_create");
			exit(1);
		}
	}
	for (i=2; i<argc; i++) {
		if (pthread_join(thid[i-2], ((void **)&nl)) != 0) {
			perror("pthread_join");
			exit(1);
		}
		if (nl != -1)
			tot+= nl;
	}
	free(thid);
	printf("Total: %ld lineas\n", tot);
	return 0;
}
