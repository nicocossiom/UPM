import java.util.*;

import javax.jms.*;

public class Server implements Runnable {
	public String region;
	public int id;
	public ArrayList<Server.RankEntry> rankingLocal;//<numeroCLiente, #numeroataques> donde se guardará el resultado final
	public ArrayList<Server.RankEntry> rankingGlobal;//<numeroCLiente, #numeroataques> donde se guardará el resultado final
	private Map<Integer,ArrayList<Transaccion>> tpvMap;//<#tpv, listaCorrespiendeTransacciones> donde se guardará el resultado final
	private Session mySess; // sesion compartida
	private Connection myConn; // Conexión para cada servidor
	private int modo;
	public Comparator<Server.RankEntry> c;

	public Server(String region, int id, Session session, Connection myConn, int modo) {
		this.region = region; // nombre región para la comunicación y  filtración de mensajes
		this.id = id;         // identificador de la región
		this.rankingGlobal = new ArrayList<Server.RankEntry>();
		this.rankingLocal = new ArrayList<Server.RankEntry>();
		this.tpvMap = new HashMap<Integer,ArrayList<Transaccion>>();
		this.mySess = session;
		this.myConn = myConn;
		this.modo = modo;
		this.c = new Server.RankComparator();
	}

	//Clase para almacenar cada entrada del ranking que implementa comparable para que se ordenen en el Set
	class RankEntry implements Comparable<RankEntry>{
		public int idCliente;
		public int numeroTrans;
		public RankEntry(int id, int numero) {
			idCliente = id;
			numeroTrans = numero;
		}
		public void addFraude(int i) {
			numeroTrans = numeroTrans + i;
		}
		public boolean equals(Server.RankEntry arg0) {
			return this.idCliente == arg0.idCliente;
		}
		@Override
		public int compareTo(Server.RankEntry arg0) {
			return this.numeroTrans - arg0.numeroTrans;
		}
	}
	class RankComparator implements Comparator<RankEntry>{

		@Override
		public int compare(Server.RankEntry arg0, Server.RankEntry arg1) {
			// TODO Auto-generated method stub
			return arg1.numeroTrans - arg0.numeroTrans;
		}

	}

	/*
	  inicializarJMS() crea los topics para cada server e inicia las conexiones al mismo
	*/

	public void inicializarJMS(){
		Topic myTopic;
		try {
			myTopic = new com.sun.messaging.Topic(region); // Creación de un topic para cada región
			System.out.println("Esperando listas de transacciones de " + region);

			// Creamos el consumidor y le pasamos la clase que tratará cada mensaje
			MessageConsumer myMsgConsumer = mySess.createConsumer(myTopic);
			TransactionListener transactionListener = new TransactionListener();
			myMsgConsumer.setMessageListener(transactionListener);

			// Iniciamos la conexión
			myConn.start();

			// Mientras no se termine de procesar todas las transacciones dormimos el thread
			while(!transactionListener.done) {
				Thread.sleep(100);
			}
			Thread.sleep(500);
		} catch (Exception jmse) {
			System.out.println("Exception occurred : " + jmse);
			jmse.printStackTrace();
		}
	}

	public String regionAsociada(int idContinente){
		String[] region={"NORTH_AMERICA", "SOUTH_AMERICA", "EUROPE", "ASIA", "OCEANIA", "AFRICA"};
		return region[idContinente - 1];
	}

	/*
	   buscarFraudeInt() procesa las transacciones y llama al método enviarFraudeInt
	   para enviar las posibles transacciones al servidor de donde es el cliente
	*/
	public void buscarFraudeInt() throws JMSException {
		Map<Integer,ArrayList<Transaccion>> tempMap = new HashMap<>();
		for(Integer idTPV : tpvMap.keySet()) {
			tempMap.put(idTPV, tpvMap.get(idTPV));
		}
		for(Integer idTPV1 : tempMap.keySet()) {
			for(Transaccion transaccion1 : tempMap.get(idTPV1)) {
				int idRegionTrans = transaccion1.getIdRegion();
				if(idRegionTrans != this.id) {
					enviarFraudeInt(idRegionTrans,transaccion1);
				}
			}
		}
	}

	/*
	   enviarFraudeInt() envia las posibles transacciones al servidor de donde es el cliente por su propio Topic
	*/
	public void enviarFraudeInt(int continente, Transaccion t) throws JMSException{
		Topic myTopic= new com.sun.messaging.Topic(regionAsociada(continente));
		MessageProducer msgProducer= mySess.createProducer(myTopic);
		ObjectMessage transFraudMsg = mySess.createObjectMessage();
		transFraudMsg.setObject(t);
		transFraudMsg.setStringProperty("region", regionAsociada(continente));
		transFraudMsg.setIntProperty("tpvId", (int)t.getIdCliente().charAt(1));
		msgProducer.send(transFraudMsg);
		msgProducer.close();
	}

	/*
	  buscarFraude() procesa las transacciones de cada servidor local
	*/
	public void buscarFraude(){
		//Creamos un mapa temporal donde copiaremos los contenidos del mapa de transacciones de los TPV
		//Hacemos esto para aumentar la eficiencia al comparar TPVs; si un TPV ya lo hemos comparado con los demás
		//lo borramos del mapa para que no se compare más veces inútilmente.
		Map<Integer,ArrayList<Transaccion>> tempMap = new HashMap<>();
		for(Integer idTPV : tpvMap.keySet()) {
			tempMap.put(idTPV, tpvMap.get(idTPV));
		}

		System.out.println("Buscando fraudes en server: " + this.region);

		//Primer bucle foreach recorre el mapa de listas de transacciones
		for(Integer idTPV1 : tempMap.keySet()) {
			//Segundo bucle foreach para comparar
			for(Integer idTPV2: tempMap.keySet()) {
				//Si estamos comparando con un mapa que ya hemos comparado antes, paramos el bucle y pasamos a otro.
				boolean hacer = true;
				if(tempMap.get(idTPV2) == null || idTPV1 == idTPV2 || tempMap.get(idTPV1) == null)
					hacer = false;
				//Tenemos que comparar todas las transacciones del TPV actual con las del segundo TPV: dos bucles for que recorren la lista de tranasacciones
				if(hacer) {
					for(Transaccion transaccion1 : tempMap.get(idTPV1)) {
						//contamos el número de transacciones iguales que encontramos para esta transacción en particular
						int frauds = 0;
						for(Transaccion transaccion2 : tempMap.get(idTPV2)) {
							//Si las transacciones son iguales, aumentamos el contador
							if(transaccion1.equals(transaccion2)) {
								frauds = frauds + 1;
								//System.out.println("fraudes + 1 TPV fijo: " + idTPV1 +" TPV movil: "+idTPV2);
							}
						}
						//una vez tenemos todas las transacciones iguales encontradas para la transacción en particular
						//las tenemos que meter en el ranking
						boolean existia = false;
						int idClienteInt = Integer.parseInt(transaccion1.getIdCliente());
						//Vamos a comprobar si ya teníamos una entrada en el ranking para ese usuario
						if(frauds!=0) {
							for(RankEntry current : rankingLocal) {
								if(current.idCliente == idClienteInt) {
									existia = true;
									current.addFraude(frauds);
								}
							}
							//si no existía, creamos una nueva entrada en el ranking con las transacciones fraudulentas que hayamos encontrado.
							if(!existia) {
								rankingLocal.add(new RankEntry(idClienteInt,frauds));
								//System.out.println("creando nueva entrada");
							}
						}
					}
					//Al acabar de comparar una lista con las demás, la borramos de la estructura para que los denmás no tengan que volver a compararse con él.
				}
			}
			tempMap.replace(idTPV1, null);
		}
	}

	/*
	  synchronized porque imprime a pantalla y puede ser ejecutado por varios threads
	  Imprime el ranking de clientes con más atques
	*/
	public synchronized void rankear(){
		System.out.println(this.region + "\n" + "ID\t#Ataques locales");
		Comparator<RankEntry> c = new RankComparator();
		rankingLocal.sort(c);
		rankingGlobal.sort(c);
		for (RankEntry local : rankingLocal){
			System.out.println(local.idCliente + "\t" + local.numeroTrans + "\n") ;
		}
		System.out.println("ID\t#Ataques globales");
		for (RankEntry global : rankingGlobal){
			System.out.println(global.idCliente + "\t" + global.numeroTrans + "\n") ;
		}
	}

	@SuppressWarnings("unchecked")
	class TransactionListener implements MessageListener {
		public boolean done = false;
		public void onMessage(Message message) {
			ArrayList<Transaccion> transList = null;
			if (message instanceof ObjectMessage ) {
				//System.out.println("ObjectMessage received!!");
				done = true;
				ObjectMessage  objMessage =  (ObjectMessage) message;
				try {
					//TODO filtrar mensajes:
					//tipo 1: Transaccion -> mirar si existe transaccion dentro de lista
					Object object = objMessage.getObject();
					if (object instanceof Transaccion){
						Transaccion transaccion = (Transaccion) object;
						boolean existe = false;
						Iterator<ArrayList<Transaccion>> it1 = tpvMap.values().iterator();
						while(it1.hasNext() && !existe) {
							for(Transaccion transac : it1.next()) {
								if(transaccion.equalsInternacional(transac)) {
									existe = true;
									break;
								}
							}
						}
						//si la misma transaccion existe es fraudulenta y la añadimos al ranking global
						if(existe){
							boolean existia = false;
							int idClienteInt = Integer.parseInt(transaccion.getIdCliente());
							//Vamos a comprobar si ya teníamos una entrada en el ranking para ese usuario
							for(RankEntry current : rankingGlobal) {
								if(current.idCliente == idClienteInt) {
									//Si la hay, añadimos las nuevas transacciones fraudulentas a la entrada que ya existía
									current.addFraude(1);
									existia = true;
									break;
								}
							}
							//si no existía la entrada, creamos una nueva entrada en el ranking con las transacciones fraudulentas que hayamos encontrado.
							if(!existia)
								rankingGlobal.add(new RankEntry(idClienteInt,1));
						}
					}
					//tipo 2: ArrayList --> previo a buscar fraude, convertir y meter en papa 
					else if(object instanceof ArrayList<?>){
						transList = (ArrayList<Transaccion>) objMessage.getObject(); //sacamos lista
						Integer id = objMessage.getIntProperty("tpvId"); //sacamos id de region
						String region = objMessage.getStringProperty("region"); //sacamos id de region
						System.out.println("Lista de transacciones del TPV: "+ id + " recibida en server " + region );
						tpvMap.put(id, transList); //añadimos lista al mapa de trasacciones
					}
				} catch (Exception e) {
					System.out.println("Exception in onMessage(): " + e.toString());
				}
			}
		}

	}

	/*
    Método obligatorio de la clase Runnable que el Thread utiliza para arrancar la clase, tras el constructor.
	 */
	@Override
	public void run() {
		inicializarJMS();
		try {
			if(modo == 0)
				buscarFraude();
			else if(modo == 1)
				buscarFraudeInt();
			else {
				buscarFraude();
				buscarFraudeInt();
			}
		}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}


}
