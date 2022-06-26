import javax.jms.*;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Banco {
	private Server[] servers;
	private String[] lugares = {"NORTH_AMERICA", "SOUTH_AMERICA", "EUROPE", "ASIA", "OCEANIA", "AFRICA"};
	private Session mySess;
	private Connection myConn;
	public Banco(Session mySess, Connection myConn){
		this.servers= new Server[6];
		this.mySess = mySess;
		this.myConn = myConn;
	}

	/*
      lanzarServers(int modo) se encarga de inicializar los servidores mediante threads, utilizando un ThreadPool,
      que nos permite una gestión mucho más eficiente y sencilla de los threads. Recibe el modo, que indica si se quiere ejecutar la parte obligatoria, extra o ambas.
	*/
	 public void lanzarServers(int modo){
	        ExecutorService exec = Executors.newFixedThreadPool(servers.length);
	        for (int i=0; i < servers.length; i++){
	            String region = lugares[i];
	            servers[i] = new Server(region, i+1, mySess, myConn,modo);
	            exec.execute(servers[i]);
	        }
	        exec.shutdown();
	        try {
	            while (! exec.awaitTermination(2L, TimeUnit.MILLISECONDS)) {
	            }
	            for (int i=0; i < servers.length; i++){
		            servers[i].rankear();
		        }
	        } catch (InterruptedException ex){
	            ex.printStackTrace();
	        }
	    }

	public static void main(String[] args) {
		ConnectionFactory myConnFactory;
		Session mySess;
		try {
			myConnFactory = new com.sun.messaging.ConnectionFactory();
			Connection myConn = myConnFactory.createConnection();
			mySess = myConn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Banco banco = new Banco(mySess,myConn);
			System.out.println("Escribe 0 para ejecutar sólo la parte obligatoria");
			System.out.println("Escribe 1 para ejecutar sólo la parte optativa");
			System.out.println("Escribe 2 para ejecutar las partes obligatoria y optativa");
			Scanner sc = new Scanner(System.in);
			int modo = sc.nextInt();
			if(modo < 0 || modo > 2) {
				System.err.println("Error: el número insertado es incorrecto");
			}
			else {
				banco.lanzarServers(modo);
			}
			mySess.close();
			myConn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
