// Ejemplo que muestra el uso de signal
#include <stdio.h>
#include <signal.h>
#include <string.h>
#include <unistd.h>

void captura(int s) {
	printf("Señal capturada %s\n", strsignal(s));
}
int main(int argc, char *argv[]) {
	signal(SIGINT, SIG_IGN);
	printf("SIGINT ignorada: pulsa Crtl-C o envia SIGINT y no debería hacer nada (despues pulsa return para continuar)\n");
	getchar();

	signal(SIGINT, captura);
	printf("SIGINT capturada: pulsa Crtl-C o envia SIGINT y debería imprimir mensaje\n");
	pause();

	signal(SIGINT, SIG_DFL);
	printf("SIGINT por defecto: pulsa Crtl-C o envia SIGINT y debería morir el proceso\n");
	pause();

	printf("NO DEBE SALIR\n");

	return 0;
}
