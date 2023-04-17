#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#define MAX 1000

int main(int argc, char *argv[]) {
    FILE *entrada;
    char fila[MAX];
    char cwd[MAX];
    if (argc != 2) {
        fprintf(stderr, "Error en el numero de argumentos introducidos");
        exit(1);
    }

    entrada = fopen(argv[1], "r");
    if (entrada == NULL) {
        fprintf(stderr, "Error en el fichero de entrada %s", argv[1]);
        exit(1);
    }

    fgets(fila, MAX, entrada);
    int filas = atoi(fila);

    fgets(fila, MAX, entrada);
    int columnas = atoi(fila);

    fgets(fila, MAX, entrada);
    int columnas2 = atoi(fila);

    int **matriz1 = (int **)malloc(sizeof(int *) * filas);
    fprintf(stderr, "escaneando matriz: filas %d columnas %d\n", filas, columnas);
    for (int i = 0; i < filas; i++) {
        matriz1[i] = malloc(sizeof(int) * columnas);
        fgets(fila, MAX, entrada);
        // fprintf(stderr, "%s", fila);
        for (int j = 0; j < columnas * 2; j++) {
            // fprintf(stderr, "%c", fila[j]);
            matriz1[i][j] = atoi(&fila[j]);
            // fprintf(stderr, " %d ", matriz1[i][j]);
        }
    }

    // printf("Imprimiendo matriz 1\n");
    // for (int i = 0; i < filas; i++) {
    //     for (int j = 0; j < columnas; j++) {
    //         printf("%d ", matriz1[i][j]);
    //     }
    //     printf("\n");
    // }

    int filas2 = columnas;
    int **matriz2 = (int **)malloc(sizeof(int *) * filas2);
    fprintf(stderr, "escaneando matriz2: filas %d columnas %d\n", filas2, columnas2);
    for (int i = 0; i < filas2; i++) {
        matriz2[i] = malloc(sizeof(int) * columnas2);
        fgets(fila, MAX, entrada);
        fprintf(stderr, "%s", fila);
        for (int j = 0; j < columnas2 * 2; j++) {
            // fprintf(stderr, "%c", fila[j]);
            matriz1[i][j] = atoi(&fila[j]);
            // fprintf(stderr, " %d ", matriz1[i][j]);
        }
    }
    printf("Imprimiendo matriz 2\n");
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            printf("%d ", matriz2[i][j]);
        }
        printf("\n");
    }

    // int **matrizRes;
    // matrizRes = (int **) malloc (sizeof (int)*filas*P);
}