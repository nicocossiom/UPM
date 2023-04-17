#include <stdio.h>
#include <signal.h>
#include <string.h>
#include <unistd.h>

void captura1(int s) {
	static int primera_vez=1;
	printf("Inicio función tratamiento de señal %s\n", strsignal(s));
	if (primera_vez) {
		printf("Pulsa Crtl-C o envía SIGINT: tratamiento no se anida (despues pulsa return para continuar)\n");
		getchar();
		primera_vez=0;
	}
	printf("Fin función tratamiento de señal %s\n", strsignal(s));
	
}
void captura2(int s) {
	printf("Función tratamiento de señal %s\n", strsignal(s));
	
}
void captura3(int s) {
	printf("Inicio función tratamiento de señal %s\n", strsignal(s));
	printf("Pulsa Crtl-\\ o envía SIGQUIT: tratamiento (por defecto, abortar) no tiene lugar hasta fin de tratamiento de SIGINT (despues pulsa return para continuar)\n");
	getchar();
	printf("Fin función tratamiento de señal %s\n", strsignal(s));
	
}
int main(int argc, char *argv[]) {
	sigset_t mascara, mascara_previa;
	struct sigaction acc;

	printf("PRIMERA PRUEBA: MUESTRA QUE DURANTE EL TRATAMIENTO DE UNA SEÑAL SE BLOQUEA ÍMPLICITAMENTE LA MISMA\n");
	signal(SIGINT, captura1);
	printf("SIGINT capturada: pulsa Crtl-C o envía SIGINT\n");
	pause();

	printf("\nSEGUNDA PRUEBA: BLOQUEO EXPLÍCITO DE UNA SEÑAL\n");
	signal(SIGINT, captura2);
	sigemptyset(&mascara);
	sigaddset(&mascara, SIGINT);
	sigprocmask(SIG_BLOCK, &mascara, &mascara_previa);
	printf("Inicio intervalo de bloqueo de SIGINT\n");
	printf("Pulsa Crtl-C o envía SIGINT: tratamiento espera fin de bloqueo (despues pulsa return para continuar)\n");
	getchar();
	printf("Fin intervalo de bloqueo de SIGINT\n");
	sigprocmask(SIG_SETMASK, &mascara_previa, NULL);

	printf("\nTERCERA PRUEBA: SOLICITUD DE BLOQUEO AUTOMÁTICO DE OTRAS SEÑALES DURANTE EL TRATAMIENTO DE UNA SEÑAL\n");
	acc.sa_handler = captura3;
	acc.sa_flags=0;
	sigemptyset(&acc.sa_mask);
	sigaddset(&acc.sa_mask, SIGQUIT);
	sigaction(SIGINT, &acc, NULL);
	printf("SIGINT capturada: pulsa Crtl-C o envía SIGINT\n");
	pause();

	printf("NO DEBE SALIR PORQUE EL PROGRAMA MUERE POR SIGQUIT\n");

	return 0;
}
