#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
#include <signal.h>

int main (void) {

	pid_t pid;
	int estado;
	struct sigaction act;

	act.sa_handler = SIG_IGN;
	sigaction(SIGTERM, &act, NULL);
	pid = fork();

	if (pid < 0) {
		perror("Error en el fork\n");
		return 1;
	}
	else if (pid == 0) {
		// CÓDIGO HIJO	
		sleep(10);
		printf("Termina el sleep el hijo\n");
		return 2;

	}
	else {
		// CÓDIGO PADRE
		kill(pid,SIGTERM);
		wait(&estado);
		if (WIFEXITED(estado)>0)
			printf("El hijo ha terminado de forma correcta con el valor %d\n",WEXITSTATUS(estado));
		else if (WIFSIGNALED(estado)>0)
			printf("El hijo ha muerto por la señal %d\n", WTERMSIG(estado));
	}

	return 0;
	
}
