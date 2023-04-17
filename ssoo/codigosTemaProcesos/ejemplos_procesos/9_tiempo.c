// Ejemplo similar al mandato "time" pero simplificado

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/times.h>

int main(int argc, char *argv[]) {
	int rf, estado;
	struct tms t;
	clock_t ci, cf;
	long ticsporseg;
	
	ticsporseg = sysconf(_SC_CLK_TCK);

	if (argc < 2) {
		fprintf(stderr, "Uso: %s mandato args...\n", argv[0]);
		return 1;
	}

	ci = times(NULL);

	if ((rf = fork()) == -1) {
		perror("fork");
		return 1;
	}
	else if (rf == 0) {
		execvp(argv[1], &argv[1]);
		perror("exec");
		return 1;
	}
	if (waitpid(rf, &estado, 0)<0) {
		perror("wait");
		return 1;
	}
	cf = times(&t);
	fprintf(stderr, "real %lf usuario %lf sistema %lf\n",
		(cf - ci)/(double)ticsporseg,
		t.tms_cutime/(double)ticsporseg,
		t.tms_cstime/(double)ticsporseg);

	return estado;
}
