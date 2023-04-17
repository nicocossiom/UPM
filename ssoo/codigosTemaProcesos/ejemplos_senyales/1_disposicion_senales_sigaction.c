// Ejemplo que muestra el uso de sigaction
#include <stdio.h>
#include <signal.h>
#include <string.h>
#include <unistd.h>

void captura(int s) {
	printf("Señal capturada %s\n", strsignal(s));
}
int main(int argc, char *argv[]) {
	struct sigaction acc;

	acc.sa_handler = SIG_IGN;
	acc.sa_flags=0;
	sigemptyset(&acc.sa_mask);
	sigaction(SIGINT, &acc, NULL);
	printf("SIGINT ignorada: pulsa Crtl-C o envia SIGINT y no debería hacer nada (despues pulsa return para continuar)\n");
	getchar();

	acc.sa_handler = captura;
	acc.sa_flags=0;
	sigemptyset(&acc.sa_mask);
	sigaction(SIGINT, &acc, NULL);
	printf("SIGINT capturada: pulsa Crtl-C o envia SIGINT y debería imprimir mensaje\n");
	pause();

	acc.sa_handler = SIG_DFL;
	acc.sa_flags=0;
	sigemptyset(&acc.sa_mask);
	sigaction(SIGINT, &acc, NULL);
	printf("SIGINT por defecto: pulsa Crtl-C o envia SIGINT y debería morir el proceso\n");
	pause();

	printf("NO DEBE SALIR\n");

	return 0;
}
