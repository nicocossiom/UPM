package sesion6;

class BusyAE {

	// Exclusión mutua con espera activa: 
	// versión con un solo turno bivaluado

	// + GARANTIZA EXCLUSIÓN MUTUA
	// - SUFRE DE ALTERNANCIA ESTRICTA

	// variable compartida de la seccion critica
	static volatile int cont = 0;
	static final int N_OPS = 1000000;
	// variables compartidas para sincronización
	static final int INC = 1;
	static final int DEC = 0;
	static volatile int turno = INC;
	// variables compartidas para detectar violación de 
	// la exclusión mutua:
	static volatile boolean en_sc_inc = false;
	static volatile boolean en_sc_dec = false;
	// variables compartidas para sospechar de alternancia estricta:
	static volatile int ultima_op = 42; 
	static volatile boolean probable_alternancia_estricta = true;

	static class Incrementador2 extends Thread {
		public void run() {
			for (int i = 0; i < N_OPS; i++) {
				// protocolo de entrada 
				// no entramos hasta que turno sea INC
				while (turno != INC) {};
				// sección crítica
				en_sc_inc = true;
				cont++;
				// intentamos detectar violaciones de mutex
				if (en_sc_inc && en_sc_dec) {
					System.out.print("CRAAAAAAAAAASH!!!!!!!\n");
				}
				// alternancia estricta:
				if (ultima_op == INC) {
					probable_alternancia_estricta = false;
				}
				ultima_op = INC;
				// protocolo de salida
				// soltamos el turno
				en_sc_inc = false;
				turno = DEC;
			}
		}	
	}

	static class Decrementador2 extends Thread {
		public void run() {
			for (int i = 0; i < N_OPS; i++) {
				// protocolo de entrada 
				// no entramos hasta que turno sea DEC
				while (turno != DEC) {};
				// sección crítica
				en_sc_dec = true;
				cont--;
				// intentamos detectar violaciones de mutex
				if (en_sc_inc && en_sc_dec) {
					System.out.print("CRAAAAAAAAAASH!!!!!!!\n");
				}
				// alternancia estricta:
				if (ultima_op == DEC) {
					probable_alternancia_estricta = false;
				}
				ultima_op = DEC;
				// soltamos el turno
				en_sc_dec = false;
				turno = INC;
			}
		}
	}

	public static void main(String args[]) {

		// Creación de los procesos
		Incrementador2 incrementador = new Incrementador2();
		Decrementador2 decrementador = new Decrementador2();

		// Lanzamiento de los procesos
		incrementador.start();
		decrementador.start();


		// Espera hasta la terminación de los procesos
		try {
			incrementador.join();
			decrementador.join();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit (-1);
		}

		// Impresión del valor final del contador
		System.out.printf("El valor final del contador es: %d\n",
				cont);
		if (probable_alternancia_estricta) {
			System.out.print("Muy probablemente, esta solución sufre de alternancia estricta\n");
		}
		System.exit (0);
	}
}