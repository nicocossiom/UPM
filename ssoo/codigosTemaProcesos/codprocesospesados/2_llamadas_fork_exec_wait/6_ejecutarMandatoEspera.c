#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main (int argc, char *argv[])
{
	pid_t pid;

	if (argc<2){
		printf("Error. Uso: %s ejec [par]\n", argv[0]);
		return 1;
	}

	pid = fork();
	if (pid < 0 ){
		perror("Fork()");
		return 1;
	}
	if (pid == 0) {
		// Proceso hijo
		execvp(argv[1], &argv[1]);
		perror("Exec()");
		return 1;
	}
	else {
		// Proceso padre
		wait(NULL);
	}

	return 0;

}
