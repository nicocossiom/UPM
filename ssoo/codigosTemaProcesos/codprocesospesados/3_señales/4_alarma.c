#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
	
pid_t pidh;

void matar_proceso (int n)
{ 
	kill(pidh, SIGKILL);
}

int main (int argc, char *argv[])
{

	struct sigaction act;
	int estado;

	if (argc<2){
		printf("Error. Uso: ./3_alarma ejec [par]\n");
		return 1;
	}

	pidh= fork();
	if (pidh< 0 ){
		perror("Fork()");
		return 1;
	}
	if (pidh== 0) {
		// Proceso hijo
		execvp(argv[1], &argv[1]);
		perror("Exec()");
		return 1;
	}
	else {
		// Proceso padre
		act.sa_handler = &matar_proceso;
		act.sa_flags = SA_RESTART;
		sigaction(SIGALRM, &act, NULL);
		alarm(10);
		wait(&estado);	
		if (WIFEXITED(estado)>0){
                        printf("El proceso %d ha finalizado correctamente con valor: %d\n", pidh,WEXITSTATUS(estado));
                }
                else {
                        printf("El proceso %d no ha finalizado correctamente\n", pidh);
                }
                if (WIFSIGNALED(estado)>0){
                        printf("El proceso %d ha recibido la señal %d\n",pidh,WTERMSIG(estado));
                }
                else{
                        printf("El proceso %d no ha recibido una señal\n", pidh);
                }

	}

	return 0;

}
