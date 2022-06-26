import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Server extends UnicastRemoteObject implements ServerInterface, Runnable {

	private static final long serialVersionUID = -17402215111218043L;
	private final Map<Integer, Map<String, List<Transaccion>>> tpvMap; //<#tpv (region+id), listaCorrespiendeTransacciones donde se guardará el resultado final
	public ArrayList<RankEntry> rankingGlobal; //<numeroCLiente, #numeroBonificaciones> donde se guardará el resultado final
	public ArrayList<Transaccion> listaTransacciones;
	public String region;
	public int top10;
	public int id;
	private boolean extra;
	List<TPVCallback> clientList = new ArrayList<TPVCallback>();
	RankComparator comp = new RankComparator();

	protected Server() throws RemoteException  {
		super();
		this.listaTransacciones = new ArrayList<>();
		this.tpvMap = new HashMap<>();
		this.rankingGlobal = new ArrayList<RankEntry>();
		for(int i = 0; i <10; i++)
			rankingGlobal.add(new RankEntry(-1));
		top10=rankingGlobal.get(9).numeroBonificaciones;
	}

	class RankComparator implements Comparator<RankEntry>{
		@Override
		public int compare(Server.RankEntry arg0, Server.RankEntry arg1) {
			// TODO Auto-generated method stub
			return arg1.numeroBonificaciones - arg0.numeroBonificaciones;
		}
	}

	public void start(boolean extra) {
		this.extra = extra;
		new Thread(this).start();
	}

    @Override
    public void addTransaccionesArrayList(Map<String, List<Transaccion>> listTransaccionesTPV, int tpv) throws RemoteException {

    }

    public void addTransaccionesArrayList(Map<String, List<Transaccion>> listTransaccionesTPV, int tpv, TPVCallback da) throws RemoteException {
		// Comprobar las transacciones y añadirlas al mapa de transaciones por tpv
		System.out.println("Voy a añadir la lista de transacciones del tpv: " + tpv);
		clientList.add(da);
		tpvMap.put(tpv, listTransaccionesTPV);
	}



	/*
	  buscarFraude() procesa las transacciones de cada servidor local
	 */
	//private static TransaccionInterface trans1;
	private void buscarFraude() throws RemoteException, InterruptedException {
		/*
		 * itera sobre el map de cada tpv, que contiene una lista de transacciones para ese dia
		 * crea un sortedset para ese tpv en el ranking local
		 * dia a dia borra transacciones fradulentas y asigna bonificaciones
		 * */
		for (Map.Entry<Integer, Map<String, List<Transaccion>>> entry : tpvMap.entrySet()) { // itera sobre los TPVs
			ArrayList<RankEntry> rankingLocal = new ArrayList<>(); //ranking por tpv

			for (Map.Entry<String, List<Transaccion>> entry2 : entry.getValue().entrySet()) {// itera sobre los dias de un mismo TPV
				List<Transaccion> listaDia = entry2.getValue(); //
				Map<String, ImporteDia> mapaClientes = new HashMap<>();
				int tpv = entry.getKey();
				int i = 0;
				//Map de clientes con importe acumulado de todas las transacciones de ese dia, junto con el Nº de transacciones
				//Bucle while: Mira si transaccion es fraudulenta, si lo es la borra.
				//Si es buena añade importe al mapaClientes
				while (i < listaDia.size()) {
					Transaccion trans1 = listaDia.get(i);
					//                    System.out.println("tpv que sale en el idCliente: " + trans1.getTpvTrans() + " - tpv del que sale la transaccion: " + (tpv % 10));
					if (trans1.getTpvTrans() != (tpv % 10) || trans1.getIdRegion() != Math.floor(tpv / 10)) {
						listaDia.remove(trans1);//eliminar transaccion fradulenta
					} else {
						i++;
						//Añadir importe al pair y/o crearlo si no existe
						if (mapaClientes.containsKey(trans1.getIdCliente())) {
							mapaClientes.get(trans1.getIdCliente()).add(trans1.getImporte());
						} else {
							mapaClientes.put(trans1.getIdCliente(), new ImporteDia(trans1.getImporte()));
						}
					}
				}
				//una vez procesada la lista diaria mirar quien debe recibir bonificaciones para ese tpv ese dia

				calcularBonificaciones(mapaClientes, rankingLocal);

			}

			//hacer callback y mandar ranking al tpv que toque
			if(extra) {
				rankingLocal.sort(comp);
				String rankingLocalString = "";
				for (RankEntry entrada : rankingLocal){
					rankingLocalString = rankingLocalString + entrada.idCliente + " : " + entrada.numeroBonificaciones + "\n";
				}
				Iterator<TPVCallback> it = clientList.iterator();

				while (it.hasNext()){
					TPVCallback tpv = (TPVCallback) it.next();
					try {
						if(tpv.getNumTPV() == entry.getKey()) {
							tpv.recibeBonificacion(rankingLocalString);
						}

					} catch (RemoteException re) {
						System.out.println(
								"Excepción enviando ranking al TPV, se borra");
						System.out.println(re);
						it.remove();
					}
				}
			}
			rankingLocal.sort(comp);
			rankear(rankingLocal);
		}
		System.out.println("Ranking global");
		System.out.println("ID   #Bonif.");
		for (RankEntry entry : rankingGlobal){
			System.out.println(entry.idCliente + "    " + entry.numeroBonificaciones );
		}
	}

	private void calcularBonificaciones(Map<String, ImporteDia> mapaClientes, ArrayList<RankEntry> rankingLocal) {
		//calcula las bonificaciones dado un mapa que contiene todos los clientes y los importes para un dia
		//mete las bonificaciones del cliente en el ranking local correspondiente
		int mediaTPV = 0;
		for (Map.Entry<String, ImporteDia> entry : mapaClientes.entrySet()) {
			mediaTPV += entry.getValue().media;
		}
		mediaTPV = mediaTPV / mapaClientes.size();
		for (Map.Entry<String, ImporteDia> entry : mapaClientes.entrySet()) {
			if (entry.getValue().media > mediaTPV) {
				boolean found = false;
				int idClienteInt = Integer.parseInt(entry.getKey());
				for(RankEntry current : rankingLocal) {
					if(current.idCliente == idClienteInt) {
						found = true;
						current.addBonificacion();
						break;
					}
				}
				//si no existe el cliente lo metemeos en el ranking
				if(!found) {
					rankingLocal.add(new RankEntry(idClienteInt));
				}
			}
		}
	}

	public void rankear(ArrayList<RankEntry> rankingLocal) {
		for(RankEntry currentLocal : rankingLocal) {
			if(currentLocal.numeroBonificaciones>top10){
				for(RankEntry currentGlobal : rankingGlobal) {//solo itera 10 veces
					if(currentLocal.numeroBonificaciones>currentGlobal.numeroBonificaciones){
						rankingGlobal.set(9,currentLocal);
						rankingGlobal.sort(comp);
						top10=rankingGlobal.get(9).numeroBonificaciones;
						break;
					}

				}
			}
		}
	}

	//Clase para almacenar cada entrada del ranking que implementa comparable para que se ordenen en el Set
	class RankEntry implements Serializable, Comparable<RankEntry> {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
		public int idCliente;
		public int numeroBonificaciones;

		public RankEntry(int id) {
			idCliente = id;
			numeroBonificaciones = 1;
		}

		public void addBonificacion() {
			numeroBonificaciones++;
		}
		public boolean equals(Server.RankEntry arg0) {
			return this.idCliente == arg0.idCliente;
		}
		@Override
		public int compareTo(Server.RankEntry arg0) {
			return this.numeroBonificaciones - arg0.numeroBonificaciones;
		}
	}

	//Clase que se encarga
	class ImporteDia {
		private int importeTotal;
		private int numerotrans;
		private int media;

		public ImporteDia(int a) {
			this.importeTotal = a;
			this.numerotrans = 1;
			this.media = a;
		}

		public void add(int importe) {
			importeTotal += importe;
			numerotrans++;
			media = importeTotal / numerotrans;
		}
	}

	@Override
	public void run() {
		Boolean done = false;
		while (!done) {
			try {
				System.out.println("Esperando transacciones");
				while(clientList.size() != 26) 
					Thread.sleep(200);
				System.out.println("Todas las transacciones recibidas");
				buscarFraude();
				done = true;
			} catch (Exception unexpected) {
				System.out.println(unexpected);
				unexpected.printStackTrace();
				System.out.println("Interrupted!");
				done = true;
			}
		}
	}
}