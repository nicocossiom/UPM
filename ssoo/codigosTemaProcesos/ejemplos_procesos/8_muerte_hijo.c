// Ejemplo que muestra el estado que recoge wait dependiendo de cómo
// muera el hijo.

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
	int rf, tipo_muerte, estado;
	int x=7, y=0;
	char *p = NULL;

	if (argc != 2) {
		fprintf(stderr, "Uso: %s num\n", argv[0]);
		return 1;
	}
	tipo_muerte = atoi(argv[1]);
	signal(SIGINT, SIG_IGN); //necesario para tipo de muerte 6

	if ((rf = fork()) == -1) {
		perror("fork");
		return 1;
	}
	else if (rf == 0) {
		signal(SIGINT, SIG_DFL); //necesario para tipo de muerte 6
		switch (tipo_muerte) {
			case 0:
				printf("HIJO FIN NORMAL CON 0\n");
				return 0;
			case 1:
				printf("HIJO FIN NORMAL CON 1\n");
				return 1;
			case 2:
				printf("HIJO DIVIDE POR 0\n");
				x = x/y;
			case 3:
				printf("HIJO ACCESO A MEMORIA INVÁLIDO\n");
				*p=5;
			case 4:
				printf("HIJO SE AUTOENVÍA SIGUSR1\n");
				kill(getpid(), SIGUSR1);
			case 5:
				printf("HIJO SE AUTOENVÍA SEÑAL DE ACCESO A MEMORIA INVÁLIDO\n");
				kill(getpid(), SIGSEGV);
			case 6:
				printf("HIJO MUERE POR CONTROL-C\n");
				pause();
			default:
				printf("TIPO DE MUERTE NO IMPLEMENTADA\n");
				return 0;
			}
		
	}
	if (waitpid(rf, &estado, 0)<0) {
		perror("wait");
		return 1;
	}
	if (WIFEXITED(estado))
		printf("wait: hijo fin normal con valor %d\n",
			WEXITSTATUS(estado));
	if (WIFSIGNALED(estado))
		printf("wait: hijo fin por señal con valor %d\n",
			WTERMSIG(estado));
	return 0;
}
