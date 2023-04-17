#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

int main (void)
{
	pid_t pidh;
	int estado;

	pidh= fork();
	if (pidh< 0 ){
		perror("fork()");
		return 1;	
	}
	if (pidh== 0) {
		// Proceso hijo
		sleep(10);
	}
	else {
		// Proceso padre
		kill(pidh, SIGKILL);
		wait(&estado);
		if (WIFEXITED(estado)>0){
			printf("El proceso %d ha finalizado correctamente con valor: %d\n", pidh,WEXITSTATUS(estado));
		}		
		else {
			printf("El proceso %d no ha finalizado correctamente\n", pidh);
		}
		if (WIFSIGNALED(estado)>0){
			printf("El proceso %d ha recibido la señal %d\n", pidh, WTERMSIG(estado));
		}
		else{
			printf("El proceso %d no ha recibido una señal\n", pidh);
		}

	}

	return 0;

}
