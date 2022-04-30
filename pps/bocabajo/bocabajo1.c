#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "auxiliar.h"


int numFiles;
char *nomArchivo;
int lineCounter;
int main(int argc, char **argv)
{
    if (argc == 2 && ( strcmp(argv[1], "-h") == 0 || strcmp(argv[1], "--help") == 0 || strcmp(argv[1], "ayuda") == 0))
    {
        fputs("bocabajo: Uso: bocabajo [ fichero... ]\nbocabajo: Invierte el orden de las lineas de los ficheros (o de la entrada).\n", stdout);
        exit(EX_OK);
    }
    
    numFiles = argc-1; //ultimo archivo
    lineCounter=0; //contador de lineas en archivo actual
    while (numFiles!=0){
        char **arrLineas = malloc((sizeof (char *)) * (lineCounter + 1)); //inicializamos memoria dinámica con un espacio
        FILE *ptrFile = fopen(argv[numFiles], "r");
        if (ptrFile==NULL){
            Error(EX_NOINPUT, "El archivo %s no existe en el directorio ", argv[numFiles]);
        }
        char line [2049];
        numFiles--;
        while(fgets(line, 2049, ptrFile)!=NULL){
            arrLineas = realloc (arrLineas, (sizeof(char *))*(lineCounter+1));
            if(arrLineas==NULL){
                Error(EX_OSERR, "Error al reasignar memoria dinamica \n");
            }
            arrLineas[lineCounter] = strdup(line);//metemos linea en memoria dinamica
            lineCounter++;
        }
        fclose(ptrFile);
        while(lineCounter>=1){
            printf("%s", arrLineas[lineCounter-1]);
            lineCounter--;
        }
        free(arrLineas);
    }
    exit(EX_OK);
}