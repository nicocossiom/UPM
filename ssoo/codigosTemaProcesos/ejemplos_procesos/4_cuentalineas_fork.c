// Ejemplo que cuenta las líneas de los ficheros recibidos como argumentos
// usando un proceso (fork) para cada uno.
// Tiene un error intencionado a la hora de imprimir el número total de 
// líneas de los ficheros.

#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
	int rf, i, nprocs = 0;
	FILE *f;
	int c, res;
	int nl=0, tot=0;
	for (i=1; i<argc; i++) {
		if ((rf = fork()) == 0) {
			if ((f = fopen(argv[i], "r"))!=NULL) {
				while ((c = fgetc(f)) != -1)
					if (c == '\n') nl++;
				printf("%s: %d lineas\n", argv[i], nl);
				res = 0;
				tot += nl;
			}
			else {
				printf("%s: no existe el fichero\n", argv[i]);
				res = 1;
			}
			return res;
		}
		else if (rf == -1)
			perror("fork");
		else // fork OK; padre	
			nprocs ++;
	}
	for (i=0; i<nprocs; i++)
		wait(NULL);
		
	printf("Total: %d lineas\n", tot);
	return 0;
}
