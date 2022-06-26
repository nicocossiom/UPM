import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class TPV extends UnicastRemoteObject implements TPVCallback{
	
	protected TPV(int num) throws RemoteException {
		this.numCliente = num;
	}
	private static final String REMOTE = "127.0.0.1";
	private static final long serialVersionUID = -12312414152456L;
	private String fichero;
	private String region;
	private String regionString;
	private int tpv;
	private Map<String, List<Transaccion>> transacciones;
	
	private int numCliente;

	public void cogerInfo(String fich) throws IOException {
		
		this.fichero = fich;
		//revisamos de que región se trata según el fichero.
		if(fichero.startsWith("AFRICA")) {
			this.region = "6";
			this.regionString = "AFRICA";
		}
		else if(fichero.startsWith("ASIA")) {
			this.region = "4";
			this.regionString = "ASIA";
		}
		else if(fichero.startsWith("EUROPE")) {
			this.region = "3";
			this.regionString = "EUROPE";
		}
		else if(fichero.startsWith("NORTH")) {
			this.region = "1";
			this.regionString = "NORTH";
		}
		else if(fichero.startsWith("SOUTH")) {
			this.region = "2";
			this.regionString = "SOUTH";
		}
		else  {
			this.region = "5";
			this.regionString = "OCEANIA";
		}
		tpv = Integer.parseInt(region + "" + fich.charAt(fich.length() - 5));
		this.transacciones = new HashMap<>();
		procesar();
	}
	public int getNumTPV() throws RemoteException{
		return tpv;
	}
	public void sendTransacciones(ServerInterface server) throws RemoteException {
		server.addTransaccionesArrayList(transacciones, tpv, this);
	}
	private void hacer_trabajo(String pathnames) throws IOException, NotBoundException {
		// Establezco la política de seguridad para usarla con el gestor
		//System.setProperty("java.security.policy", "TPV.policy");
		System.setProperty("java.rmi.server.codebase", "http://" + REMOTE + "/TPV/");

		// Indico que quiero usar codebases remotos
		System.setProperty("java.rmi.server.useCodebaseOnly", "false");

		try {

			// Se habilita el Security Manager para poder descargar clases
			/*if(System.getSecurityManager()==null){
		                System.setSecurityManager(new SecurityManager());
		            }*/
			System.out.println("Cliente " + numCliente + ": Obtengo el registro");
			Registry registro = LocateRegistry.getRegistry(REMOTE, Registry.REGISTRY_PORT);
			System.out.println("Cliente " + numCliente + ": Busco el servidor");
			ServerInterface server = (ServerInterface) registro.lookup("bonificaciones");
			System.out.println("Cliente " + numCliente + ": Ya tengo el servidor");
			cogerInfo(pathnames);
			System.out.println("Cliente " + numCliente + ": se me ha asignado el TPV: " +tpv);
			sendTransacciones(server); //Me conecto al servidor
		} catch (Exception e) {
			System.err.println("INFO: No puedo acceder al registro RMI o al banco remoto en la dirección " + REMOTE);
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	public void recibeBonificacion(String rankingLocal) throws RemoteException {
		System.out.println(regionString + ". TPV "+ (tpv%10) + ":");
		System.out.println("ID   #Bonif.");
		System.out.println(rankingLocal);
    }

	public void procesar() throws IOException {
		BufferedReader rdr = new BufferedReader (new FileReader("./src/ficherosTXT/"+fichero));
		String strCurrentLine;
		while ((strCurrentLine = rdr.readLine()) != null) {
			String fecha;
			String hora;
			String idCliente;
			String importe;
			String[] parts = strCurrentLine.split(" ");
			fecha = parts[0];
			hora = parts[1];
			idCliente = parts[2];
			importe = parts[3];
			Transaccion transaccion = new Transaccion(fecha, hora, idCliente, importe);
			if (transacciones.containsKey(fecha)) {
				transacciones.get(fecha).add(transaccion);
			} else {
				List<Transaccion> lista = new ArrayList<>();
				lista.add(transaccion);
				transacciones.put(fecha, lista);
			}
		}
		rdr.close();
	}
	public static void main(String[] args) throws IOException, NotBoundException { 
		File file = new File("./src/ficherosTXT");
        String[] pathnames = file.list();
        int i = 0;
		for (String pathname : pathnames) {
            new TPV(i).hacer_trabajo(pathname);
            i += 1;
        }
	}
}
