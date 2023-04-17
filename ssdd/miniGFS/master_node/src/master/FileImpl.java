// Implementación de la interfaz remota para el acceso a la información de ubicación de un fichero

package master;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.rmi.*;
import java.rmi.server.*;
import manager.*;
import interfaces.*;

public class FileImpl extends UnicastRemoteObject implements File {
    public static final long  serialVersionUID=1234567891;
    
    private Map<Integer, ChunkImpl> chunkMap;
    private int replica;
    private ManagerImpl m;
    private int fileSize;
    

    public FileImpl(ManagerImpl m, int replicaFactor) throws RemoteException {
    	chunkMap = new HashMap<Integer, ChunkImpl>();
    	replica = replicaFactor;
    	this.m = m;
    	fileSize = 0;
    }
    
    /**
     * nº de chunks del fichero
     * @return int
     * @throws RemoteException
     */
    public int getNumberOfChunks() throws RemoteException {
        return fileSize;
    }
    
    /**
     * obtiene información de ubicación de los chunks especificados del fichero
     * @param nchunk
     * @param size
     * @return List<Chunk>
     * @throws RemoteException
     */
    public List <Chunk> getChunkDescriptors(int nchunk, int size) throws RemoteException {
        List<Chunk> res = new ArrayList<Chunk>();
    	for (int i=nchunk; i<nchunk+size && i<fileSize; i++) {
        	if (!chunkMap.containsKey(i)) {
        		res.add(null);
        	} else {
        		res.add(chunkMap.get(i));
        	}
    	}
    	return res;
    }
    
    /**
     * reserva información de ubicación para los chunks especificados del fichero
     * @param nchunk
     * @param size
     * @return List<Chunk>
     * @throws RemoteException
     */
    public List <Chunk> allocateChunkDescriptors(int nchunk, int size) throws RemoteException {
        List<Chunk> res = new ArrayList<Chunk>();
        for (int i=nchunk; i<nchunk+size; i++) {
        	if (!chunkMap.containsKey(i)) {
        		List <DataNode> dns = new ArrayList<DataNode>();
        		for (int j=0; j<replica; j++) {
        			dns.add(m.selectDataNode());
        		}
        		ChunkImpl thisChunk = new ChunkImpl(dns);
        		chunkMap.put(i, thisChunk);
        		res.add(thisChunk);
        	} else {
        		res.add(chunkMap.get(i));
        	}
        }
    	if (nchunk + size > fileSize) {
    		fileSize = nchunk + size;
    	}
        return res;
    }
}
