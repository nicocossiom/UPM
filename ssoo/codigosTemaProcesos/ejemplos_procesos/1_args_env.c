// Ejemplo de acceso a los argumentos y a una variable de entorno
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	int i;
	char *val;

	for (i=0; i<argc; i++)
		printf("argv[%d]: %s\n", i, argv[i]);
	if ((val = getenv("MIVAR")) != NULL) 
		printf("MIVAR: %s\n", val);
	return 0;
}
