#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main (void)
{
	pid_t pidh, pidn;

	pidh = fork();
	if (pidh< 0 ){
		perror("Fork()");
		return 1;	
	}
	if (pidh== 0) {
		pidn = fork();
		if (pidn < 0){
			perror("Fork()");
			return 1;	
		}
		if (pidn == 0) {
			// Proceso nieto
			printf("Proceso nieto: pid:%d ppid:%d\n",getpid(),getppid());
			return 0;

		}
		else{
			// Proceso hijo
			waitpid(pidn,NULL,0);
			printf("Proceso hijo: pid:%d ppid:%d\n",getpid(),getppid());
			return 0;
		}
	}
	else {
		// Proceso padre
		waitpid(pidh, NULL, 0);
		printf("Proceso padre: pid:%d ppid:%d\n",getpid(),getppid());
	}

	return 0;
}
