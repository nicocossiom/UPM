#include <signal.h>
#include <stdio.h>
#include <unistd.h>

int main(void){
	struct sigaction accion;

	accion.sa_handler = SIG_IGN;
	sigaction(SIGINT, &accion, NULL);
		
	kill(getpid(),SIGINT);
	printf("El proceso sigue vivo\n");
		
	accion.sa_handler = SIG_DFL;
	sigaction(SIGINT, &accion, NULL);

	kill(getpid(),SIGINT);
	printf("El proceso sigue vivo 2\n");

	
	return 0;

}
