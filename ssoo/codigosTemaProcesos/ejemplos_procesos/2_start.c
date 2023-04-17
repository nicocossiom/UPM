// Ejemplo que muestra que el punto de inicio de un programa C no
// es la función main. Incluye la invocación de readelf para ver la
// cabecera del ejecutable

#include <stdio.h>
#include <unistd.h>

extern void _start();

int main(int argc, char *argv[]){
	printf("start %p main %p\n", _start, main);
	execlp("readelf", "readelf", "-h", argv[0], NULL);
	return 0;
}
