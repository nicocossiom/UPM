/*
**  Cabecera de las funciones de auxiliar.c
*/

#ifndef _AUXILIAR_H_
#define _AUXILIAR_H_
#include <errno.h>
#include <stdarg.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sysexits.h>

extern char * argv0;

/*
 * Muestra por el estándar error un mensaje de error
 * con el formato adecuado, y termina llamando a exit().
 */
void Error(int exitval, char * fmt, ...);

/*
 * Intenta interpretar como double el texto de tira.
 * Devuelve: conseguido (1) o no (0).
 */
int Toma_Double(double * valor, char * tira);

/*
 * Intenta interpretar como long el texto de tira.
 * Devuelve: conseguido (1) o no (0).
 */
int Toma_Long(long * valor, char * tira);

#endif /* _AUXILIAR_H_ */
