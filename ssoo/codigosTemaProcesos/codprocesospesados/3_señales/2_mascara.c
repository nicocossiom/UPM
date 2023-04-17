#include <signal.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main(int argc, char* argv[]){

	sigset_t senyales, senyalesant, pendientes;

	sigemptyset(&senyales);
	sigaddset(&senyales, SIGINT);
	
	sigprocmask(SIG_BLOCK,&senyales,NULL);	

	sigaddset(&senyales, SIGTERM);
	sigprocmask(SIG_BLOCK,&senyales,&senyalesant);	

	if (sigismember(&senyalesant, SIGINT))
		printf("SIGINT esta incluido en senyalesant\n");	
	
	if (sigismember(&senyalesant, SIGTERM))
		printf("SIGTERM esta incluido en senyalesant\n");	
		
	if (sigismember(&senyales, SIGINT))
		printf("SIGINT esta incluido en senyales\n");	
	
	if (sigismember(&senyales, SIGTERM))
		printf("SIGTERM esta incluido en senyales\n");	

	printf("He bloqueado la señal SIGINT\n");

	sigpending(&pendientes);

	if (sigismember(&pendientes,SIGINT)){
		printf("SIGINT está pendiente antes del kill\n");	
	}
	
	kill(getpid(),SIGINT);	
	
	sigpending(&pendientes);

	if (sigismember(&pendientes,SIGINT)){
		printf("SIGINT está pendiente después del kill\n");	
	}
	printf("Sigo vivo\n");
	
	sigprocmask(SIG_UNBLOCK,&senyales,NULL);	

	printf("Continuo vivo\n");

	return 0;	
}
