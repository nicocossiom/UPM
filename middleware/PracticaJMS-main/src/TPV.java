import javax.jms.*;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


	/*
      Esta clase se encarga de gestionar los TPV´s y la información que envían a los servidores.
    */
public class TPV {
	private String fichero;
	private String region;
	private int id;
	private Session sesion;
	private ArrayList<Transaccion> transacciones;
	public MessageProducer msgProducer;
	public Topic myTopic;

	public TPV(String fich, Session sesion) throws JMSException, IOException {
		fichero = fich;
		//revisamos de que región se trata según el fichero.
		if(fichero.startsWith("AFRICA")) {
			region = "AFRICA";
			myTopic = new com.sun.messaging.Topic("AFRICA");
		}
		else if(fichero.startsWith("ASIA")) {
			region = "ASIA";
			myTopic = new com.sun.messaging.Topic("ASIA");
		}
		else if(fichero.startsWith("EUROPE")) {
			region = "EUROPE";
			myTopic = new com.sun.messaging.Topic("EUROPE"); 
		}
		else if(fichero.startsWith("NORTH")) {
			region = "NORTH_AMERICA";
			myTopic = new com.sun.messaging.Topic("NORTH_AMERICA"); 
		}
		else if(fichero.startsWith("SOUTH")) {
			region = "SOUTH_AMERICA";
			myTopic = new com.sun.messaging.Topic("SOUTH_AMERICA");
		}
		else  {
			region = "OCEANIA";
			myTopic = new com.sun.messaging.Topic("OCEANIA"); 
		}
		id = Integer.parseInt("" + fich.charAt(fich.length() - 5));
		this.sesion = sesion;
		msgProducer = this.sesion.createProducer(myTopic);
		transacciones = new ArrayList<>();
		//procesamos todas las transacciones y las enviamos al servidor.
		procesar();
		sendTransacciones();
	}

	/*
      procesar() lo que hará es leer cada archivo y generar una nueva transaccion por cada línea del archivo
    */
	public void procesar() throws IOException {
		BufferedReader rdr = new BufferedReader (new FileReader ("./src/ficherosTXT/"+fichero));
		String strCurrentLine;
		while ((strCurrentLine = rdr.readLine()) != null) {
			String fecha;
			String hora;
			String idCliente;
			String importe;
			String [] parts = strCurrentLine.split(" ");
			fecha = parts[0];
			hora = parts[1];
			idCliente = parts[2];
			importe = parts[3];
			Transaccion transaccion = new Transaccion(fecha, hora, idCliente, importe);
			transacciones.add(transaccion);
		}
		rdr.close();
	}
	/*
      sendTransacciones() se encarga de mandar el conjunto de transacciones al servidor de la region correspondiente
    */
	public void sendTransacciones() throws JMSException {
		ObjectMessage transMsg = sesion.createObjectMessage();
    	transMsg.setObject(transacciones);
    	transMsg.setStringProperty("region", region);
    	transMsg.setIntProperty("tpvId",id);
		System.out.println("Enviando la lista de transacciones del TPV: " + id + " al server " + region);
		this.msgProducer.send(transMsg);
	}

	public static void main(String[] args) throws JMSException {
		try {
			ConnectionFactory myConnFactory;
			myConnFactory = new com.sun.messaging.ConnectionFactory();
			Connection myConn = myConnFactory.createConnection();
			Session mySess = myConn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			String[] pathnames;
			File file = new File("./src/ficherosTXT");
			pathnames = file.list();
			for (String pathname : pathnames) {
				new TPV(pathname,mySess);
	        }
			mySess.close();
			myConn.close();
		}
		
		catch (Exception jmse) {
            System.out.println("Exception occurred : " + jmse.toString());
            jmse.printStackTrace();
        }

	}
}
