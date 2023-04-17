// Implementación de la interfaz remota Master

package master;

// import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import interfaces.*;
import manager.ManagerImpl;

public class MasterImpl extends UnicastRemoteObject implements Master {
    public static final long serialVersionUID = 1234567891;
    private Map<String, File> fileMap;
    private ManagerImpl thisManager;
    private int replica;

    public MasterImpl(ManagerImpl m, int replica) throws RemoteException {
    	fileMap = new HashMap<String, File>();
    	this.thisManager = m;
    	this.replica = replica;
    }

    /**
     * obtiene acceso a la metainformación de un fichero
     * 
     * @param fname
     * @return File
     * @throws RemoteException
     */
    public synchronized File lookup(String fname) throws RemoteException {
    	if (!fileMap.containsKey(fname)) {
    		File newfile = new FileImpl(thisManager, replica);
    		fileMap.put(fname, newfile);
    		return newfile;
    	} else {
    		return fileMap.get(fname);
    	}
    }
}
