#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main (int argc, char *argv[])
{
	pid_t val;
	int estado;
	int div1, div2;

	if (argc<3) {
		printf("Error. Uso: %s div1 div2\n",argv[0]);
		return 1;
	}

	div1 = atoi(argv[1]);
	div2 = atoi(argv[2]);

	val = fork();
	if (val < 0 ){
		perror("fork()");
		return 1;
	}
	if (val == 0) {
		// Proceso hijo
		int n;
		n = div1/div2;
		printf ("%d\n",n);
	}
	else {
		// Proceso padre
		wait(&estado);
		if (WIFEXITED(estado)>0){
			printf("El proceso %d ha finalizado correctamente con valor: %d\n", val,WEXITSTATUS(estado));
		}		
		else {
			printf("El proceso %d no ha finalizado correctamente\n", val);
		}
		if (WIFSIGNALED(estado)>0){
			printf("El proceso %d ha recibido la señal %d\n", val, WTERMSIG(estado));
		}
		else{
			printf("El proceso %d no ha recibido una señal\n", val);
		}

	}

	return 0;
}
