// Implementación de la interfaz de un nodo de datos

package datanode;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.*;
import java.rmi.server.*;

import interfaces.*;

public class DataNodeImpl extends UnicastRemoteObject implements DataNode {
	public static final long serialVersionUID = 1234567891;
	private String name;
	private static LockManager lm = new LockManager();
	private String chunksDir;
	

	public DataNodeImpl(Manager m, String n) throws RemoteException {
		name = n;
		m.addDataNode(this);
		chunksDir = new java.io.File("").getAbsolutePath() + "/" + name + "/";
	}

	/**
	 * nombre del nodo
	 * 
	 * @return String
	 * @throws RemoteException
	 */
	public String getName() throws RemoteException {
		return name;
	}

	/**
	 * lee el fichero que contiene un chunk
	 * 
	 * @param chunkName
	 * @return byte[]
	 * @throws RemoteException
	 */
	public byte[] readChunk(String chunkName) throws RemoteException {
		try {
			// /home/telmove/miniGFS/data_node/bin
			Path myPath = Paths.get(chunksDir + chunkName);
			return Files.readAllBytes(myPath);
		} catch (IOException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}

	/**
	 * Escribe en un fichero local el contenido del chunk; si la lista de nodos
	 * pasada como parámetro no esta vacía, propaga la escritura a los nodos de
	 * datos de la lista
	 * 
	 * @param nodes
	 * @param chunkName
	 * @param buffer
	 * @return boolean
	 * @throws RemoteException
	 * 
	 */

	public boolean writeChunk(List<DataNode> nodes, String chunkName, byte[] buffer) throws RemoteException {
		if (nodes == null || nodes.isEmpty()) {
			// escritura en nodo secundario
			try {
				// /home/telmove/miniGFS/data_node/bin
				FileOutputStream fo = new FileOutputStream(chunksDir + chunkName);
				fo.write(buffer);
				fo.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			LockManager.Lock thisLock = lm.openLock(chunkName);
			thisLock.lock();
			List<DataNode> empty = new ArrayList<DataNode>();
			for (DataNode dn : nodes) {
				if (!dn.writeChunk(empty, chunkName, buffer)) {
					return false;
				}
			}
			this.writeChunk(empty, chunkName, buffer);
			thisLock.unlock();
		}
		return true;
	}
}
