#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main(int argc, char *argv[]){
	
	pid_t pid, pid2;

	if (argc<=2){
		fprintf(stderr, "Error. Uso: %s ejec1 ejec2\n", argv[0]);
		return 1;
	}

	pid=fork();
	if (pid == -1){
		perror("Error fork");
		return 1;
	}
	else if (pid == 0){
		//Proceso hijo
		execlp(argv[1], argv[1], NULL);
		perror("Error exec");
		return 1;
	}
	else {
		//Proceso padre
		pid2 = fork();
		if (pid2 == -1){
			perror("Error fork");
			return 1;
		}
		else if (pid2 == 0){
			// Proceso hijo 2
			execlp(argv[2],argv[2],NULL);
			perror("Error exec");
			return 1;
		}			
		else {
			//Proceso padre
			waitpid(pid,NULL,0);
			waitpid(pid2,NULL,0);
			return 0;
		}	
	}
}

