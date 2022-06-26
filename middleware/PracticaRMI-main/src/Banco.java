import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Banco {

    private static final String LOCALHOST = "127.0.0.1";

    public static void main(String[] argv) throws RemoteException {
        // Indico la IP donde se deben exportar los objetos remotos
        //System.setProperty("java.rmi.server.hostname", LOCALHOST);
        //System.setProperty("java.rmi.server.codebase", "http://" + LOCALHOST + "/banco/");

        // Añado la política de seguridad que permita leer las clases del codebase
        //System.setProperty("java.security.policy", "Banco.policy");

        // Indico que quiero usar codebases remotos
        //System.setProperty("java.rmi.server.useCodebaseOnly", "false");

        try {
            // Se habilita el Security Manager para poder descargar clases
//            if (System.getSecurityManager() == null) {
//                System.setSecurityManager(new SecurityManager());
//            }

            Registry registro = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            System.out.println("Creo el registro");
            Server server = new Server();
            registro.rebind("bonificaciones", server);
            if(argv.length != 0 && argv[0].equals("extra")) {
            	server.start(true);
            	System.out.println("Ejecutando con la parte extra");
            }
            else {
            	server.start(false);
            	System.out.println("Ejecutando con la parte básica");
            }
            //server.run();

            System.out.println("INFO: Servidor de objetos en marcha en IP "+ LOCALHOST + "...");

        } catch (RemoteException e) {
            System.err.println("INFO: Error al crear el registro o el banco remoto...");
        }
    }
}
