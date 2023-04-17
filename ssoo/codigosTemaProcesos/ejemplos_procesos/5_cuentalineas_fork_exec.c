// Ejemplo que cuenta las líneas de los ficheros recibidos como argumentos
// usando un proceso que ejecuta el mandato "wc -l" (fork+exec) para cada uno.

#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
	int rf, i, nprocs = 0;
	for (i=1; i<argc; i++) {
		if ((rf = fork()) == 0) {
			execlp("wc", "wc", "-l", argv[i], NULL);
			perror("exec");
			return 1;
		}
		else if (rf == -1)
			perror("fork");
		else // fork OK; padre	
			nprocs ++;
	}
	for (i=0; i<nprocs; i++)
		wait(NULL);
		
	return 0;
}
