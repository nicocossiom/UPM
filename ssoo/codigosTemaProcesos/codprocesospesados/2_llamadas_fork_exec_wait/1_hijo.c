#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main (void)
{
	pid_t pid;

	pid = fork();
	if (pid < 0 ){
		perror("Fork()");
		return 1;	
	}
	if (pid == 0) {
		// Proceso hijo
		printf("HIJO PID: %d\n",getpid());
		printf("HIJO PPID: %d\n",getppid());
		printf("HIJO valor devuelto: %d\n", pid);	

	}
	else {
		// Proceso padre
		sleep(5);
		printf("PADRE PID: %d\n",getpid());
		printf("PADRE PPID: %d\n",getppid());
		printf("PADRE valor devuelto: %d\n", pid);	
	}

	return 0;

}
