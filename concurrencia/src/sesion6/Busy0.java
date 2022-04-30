package sesion6;

class Busy0 {

	// La carrera de partida entre Incrementador y
	// Decrementador ** sin control **

	// NO HAY EXCLUSIÓN MUTUA

	// variable compartida de la seccion critica
	static volatile int cont = 0;
	static final int N_OPS = 100000;

	// variables compartidas para detectar violación de 
	// la exclusión mutua:
	static volatile boolean en_sc_inc = false;
	static volatile boolean en_sc_dec = false;

	static class Incrementador2 extends Thread {
		public void run() {
			for (int i = 0; i < N_OPS; i++) {
				// *SIN* protocolo de entrada 
				// sección crítica
				en_sc_inc = true;
				cont++;
				// intentamos detectar violaciones de mutex
				if (en_sc_inc && en_sc_dec) {
					System.out.print("CRAAAAAAAAAASH!!!!!!!\n");
				}
				// *SIN* protocolo de salida
				en_sc_inc = false;
			}
		}
	}

	static class Decrementador2 extends Thread {
		public void run() {
			for (int i = 0; i < N_OPS; i++) {
				// *SIN* protocolo de entrada 
				// sección crítica
				en_sc_dec = true;
				cont--;
				// intentamos detectar violaciones de mutex
				if (en_sc_inc && en_sc_dec) {
					System.out.print("CRAAAAAAAAAASH!!!!!!!\n");
				}
				// *SIN* protocolo de salida
				en_sc_dec = false;
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
		System.exit (0);
	}
}