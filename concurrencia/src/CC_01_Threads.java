import java.util.Scanner;
//When running this program it will ask you to input a number N of threads that you want to create: 
//input whatever you want and press enter. The program then will create said number of threads, 
//make them sleep a random amount of time between [0,10] seconds  and after they either have finished or the program forces 
//forces them to finish it will print a message signaling it is done

public class CC_01_Threads {
	public static class myThread extends Thread { 
		private int id;
		public myThread(int id) {
			this.id = id;
		}

		public void run() {
			try {
				int sleeptime = (int) (Math.random() * 10000); 
				Thread.sleep(sleeptime);
				System.out.println("Thread number: " + id + " has slept " + sleeptime + " ms");
			} catch (InterruptedException e) {
				System.out.println("Thread number: " + id + " has been interrupted");
			}
		}
	}



	public static void main(String[] args) throws InterruptedException {
		double startTime = System.nanoTime();
		Scanner nThreads = new Scanner(System.in);
		System.out.println("How many threads do you want to start?");
		int n = nThreads.nextInt();
		nThreads.close();
//		int n = 10;
		myThread[] t = new myThread[n]; 
		for (int i=0; i<t.length ; i++) {
			t[i] = new myThread(i);
			System.out.println("Creating thread number: " + i);
			t[i].start();

		}
		for (myThread th:t) {
			if (th.isAlive()) {
			System.out.println("TH# " + th.id + " has been forced to join main");
			th.join();
			}
		}
		System.out.println("Finished in "+ (System.nanoTime() - startTime)/Math.pow(10, 9) + " seconds");
	}
}
