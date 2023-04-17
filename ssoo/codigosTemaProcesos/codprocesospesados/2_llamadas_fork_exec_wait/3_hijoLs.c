#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main (void)
{
	pid_t pid;

	pid  = fork();
	if (pid < 0 ){
		perror("Fork()");
		return 1;	
	}
	if (pid == 0) {
		// Proceso hijo
		execlp("ls", "ls", "-l",NULL);
		perror("Exec()");
		return 1;
	}
	// Proceso padre

	return 0;

}
