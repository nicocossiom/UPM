// Ejemplo que muestra cómo un proceso pasa al estado zombi

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
	int rf;
	char cmd[32];

	if ((rf = fork()) == -1) {
		perror("fork");
		return 1;
	}
	else if (rf == 0) {
		return 0;
	}
	printf("PADRE DUERME 3 SEGUNDOS PARA QUE HIJO %d PUEDA TERMINAR\n",
		rf);
	sleep(3);
	printf("PADRE DESPIERTA Y EJECUTA 'ps' PARA VER ESTADO DEL HIJO:\n"); 
	sprintf(cmd, "ps %d", rf);
	system(cmd);

	return 0;
}
