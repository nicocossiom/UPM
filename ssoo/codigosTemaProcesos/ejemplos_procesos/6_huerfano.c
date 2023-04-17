// Ejemplo que muestra que cuando un proceso se queda huérfano pasa a ser
// hijo del proceso inicial.

#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
	int rf;

	if ((rf = fork()) == -1) {
		perror("fork");
		return 1;
	}
	else if (rf == 0) {
		printf("HIJO (PID %d; PPID %d) DUERME 3 SEGUNDOS\n",
			getpid(), getppid());
		sleep(3);
		printf("HIJO (PID %d; PPID %d) DESPIERTA\n",
			getpid(), getppid());
		return 0;
	}
	printf("PULSA RETURN PARA TERMINAR EL PADRE: ");
	getchar();
	return 0;
}
