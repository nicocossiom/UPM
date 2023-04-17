#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main (void)
{
	pid_t pid;
	char *argvExec[3];
	argvExec[0]="sleep";
	argvExec[1]="15";
	argvExec[2]=NULL;

	pid = fork();
	if (pid < 0 ){
		perror("Fork()");
		return 1;	
	}
	if (pid == 0) {
		// Proceso hijo
		execvp(argvExec[0], argvExec);
		perror("Exec()");
		return 1;
	}
	// Proceso padre

	return 0;

}
