// Implementación de la interfaz del manager

package manager;
import java.util.List;
import java.util.ArrayList;
import java.rmi.*;
import java.rmi.server.*;

import interfaces.*;

public class ManagerImpl extends UnicastRemoteObject implements Manager {
    public static final long  serialVersionUID=1234567891;
    private List<DataNode> nodeList;
    private volatile int nodeIndex = 0;

    public ManagerImpl() throws RemoteException {
    	nodeList = new ArrayList<DataNode>();
    }
    
    /** 
     * @param n
     * @throws RemoteException
     */
    // alta de un nodo de datos
    public synchronized void addDataNode(DataNode n) throws RemoteException {
    	nodeList.add(n);
    }
    
    /**
     * obtiene lista de nodos de datos del sistema
     * @return List<DataNode>
     * @throws RemoteException
     */
    public synchronized List <DataNode> getDataNodes() throws RemoteException {
        return nodeList;
    }
    
    /**
     * método no remoto que selecciona un nodo de datos para ser usado
     * para almacenar un chunk
     * @return DataNode
     */
    public synchronized DataNode selectDataNode() {
    	DataNode res = null;
        if(nodeList.size() == 0) {
        	return res;
        } else {
        	if (nodeIndex >= nodeList.size()) {
        		nodeIndex = 0;
        	}
        	res = nodeList.get(nodeIndex);
        	nodeIndex++;
        	return res;
        }
    }
}
