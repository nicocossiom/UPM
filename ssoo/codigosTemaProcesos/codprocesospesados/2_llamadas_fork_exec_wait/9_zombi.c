#include <unistd.h>
#include <stdio.h>

int main(void){
	pid_t pid;

	pid = fork();
	if (pid == 0) {
		// Proceso hijo
		sleep(5);
	}
	else {
		// Proceso padre
		sleep(10);
	}
	
	return 0;
}
