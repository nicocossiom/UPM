// Ejemplo que muestra que después de un fork() padre e hijo
// no comparten recursos 

#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
	int rf, rw, estado;
	int x;

	x = 5;
	if ((rf = fork()) == -1) {
		perror("fork");
		return 1;
	}
	else if (rf == 0) {
		x++;
		printf("HIJO PID %d; variable x=%d\n", getpid(), x);
		close(1);
		printf("NO PUEDE APARECER PORQUE LA SALIDA ESTANDAR SE HA CERRADO\n");
		return 0;
	}
	rw = wait(&estado);
	printf("wait retorna valor %d estado %d; variable x=%d\n", rw,
			estado, x);
	return 0;
}
