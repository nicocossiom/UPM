public  class CC_02_Carrera {

	private static int n=0;
	private static final int NUMERO_ITER = 200;
	private static final int NUMERO_PROCESOS = 100;

	private static class ThreadSumador extends Thread {
		public void run() {
			for(int i=0; i<NUMERO_ITER; i++) {
				n++;
			  System.out.println("Suma: " + n);
			}
		}
	}
	private static class ThreadRestador extends Thread {
		public void run() {
			for(int i=0; i<NUMERO_ITER; i++) {
				n--;
  			System.out.println("Resta: " + n);
			}
		}
	}

	public static void main(String[] args) {
		Thread arrRes [] = new Thread[NUMERO_PROCESOS];
		Thread arrSum [] = new Thread[NUMERO_PROCESOS];
		for (int i=0; i<NUMERO_PROCESOS; i++) {
			arrSum[i] = new ThreadSumador();
			arrRes[i] = new ThreadRestador();
			System.out.println("Threads with id " + i + " created" );
		}
		for (int i=0; i<NUMERO_PROCESOS; i++) {
			System.out.println("Threads with id " + i + " started " );
			arrSum[i].start();
			arrRes[i].start();
		}
		for (int i=0; i<NUMERO_PROCESOS; i++) {
			try {
				arrSum[i].join();
				arrRes[i].join();
			} catch (InterruptedException e) {
				System.out.println("Thread " + i + "forced to join");
				e.printStackTrace();
			}
		}
		System.out.println("Main terminado\nResultado final-> n=" + n);
	}
}
