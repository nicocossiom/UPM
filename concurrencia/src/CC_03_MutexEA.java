
public class CC_03_MutexEA {

	static final int N_PASOS = 1000;
	static final java.util.Random RNG = new java.util.Random(0);
	volatile static int n = 0;
	volatile static boolean decr = false;
	volatile static boolean incr = false;
	volatile static boolean emdecr = false;
	volatile static boolean emincr = false;

	static class Incrementador extends Thread {
		public void run () {
			for (int i = 0; i < N_PASOS; i++) {
				incr=true;
				while (decr) {
					incr=false;
					incr=true;
				}
				n++;
				incr = false;
				emincr=true;
				if(emdecr && emincr) {
					System.out.println("Exclusionose");
				}
				emincr=false;
			}
		}
	}

	static class Decrementador extends Thread {
		public void run () {
			for (int i = 0; i < N_PASOS; i++) {
				decr=true;
				while (incr) {
					decr=false;
					decr=true;
				}
				n--;
				decr = false;
				emdecr=true;
				if(emdecr && emincr) {
					System.out.println("Exclusionose");
				}
				emdecr=false;
			}
		}
	}

	public static final void main(final String[] args) throws InterruptedException {
		Thread t1 = new Incrementador();
		Thread t2 = new Decrementador();
		t2.start();
		t1.start();
		t1.join();
		t2.join();
		System.out.println("Resultado final "+ n);
	}	
}
