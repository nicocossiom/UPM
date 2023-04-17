/* programa que temporiza a su hijo, y le mata al cabo de N segundos.*/
/* Correcto: bucle en wait por si se cumple el tiempo */
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/wait.h>
#include <unistd.h>
#include <errno.h>

pid_t pid;
void tratar_alarma (int s){
	kill (pid, SIGKILL);
}

int main (int argc, char * argv[]){
	int status;
	int res;
 	char ** argumentos = &argv[1];
	struct sigaction act;
	switch (pid = fork ()) {
 		case - 1 : perror("fork"); exit(1);
		case   0 : /* proceso hijo */
			execvp(argumentos [0], argumentos);
			perror("exec"); exit(1);
		default: /* padre */
			/* establece el manejador */
			act.sa_handler = tratar_alarma; /* función a ejecutar */
			sigemptyset(&act.sa_mask); /* No bloquear ninguna señal */
			act.sa_flags = 0;
			sigaction(SIGALRM, &act, NULL);
			alarm(5);
			// si llamada interrumpida, repito el wait
			while (((res=wait(&status))<0) && errno == EINTR);

			if (res==-1) {
				perror("wait");
				exit(1);
			}
			if (WIFEXITED(status))
				printf("hijo completado\n");
			if (WIFSIGNALED(status))
				printf("hijo abortado\n");
	}
	return 0;
}
