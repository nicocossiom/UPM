#include <unistd.h>
#include <stdio.h>

int main(void){
	pid_t pid;

	pid = fork();
	if (pid == 0) {
		// Proceso hijo
		printf("Hijo. PPID antes: %d\n",getppid());
		sleep(10);
		printf("Hijo. PPID despues: %d\n",getppid());
	}
	else {
		// Proceso padre
		sleep(5);
	}
	
	return 0;
}
