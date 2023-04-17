// Clase de cliente que proporciona los métodos para acceder a los ficheros.
// Corresponde al API ofrecida a las aplicaciones 

package client;

import java.io.IOException;
import java.rmi.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.*;

public class GFSFile {
	private Master m;
	private File fileRef;
	private int fpointer;
	private int chunkSize;

	public GFSFile(String fileName) {
		String host = System.getenv("REGISTRY_HOST");
		String port = System.getenv("REGISTRY_PORT");
		String cs = System.getenv("CHUNKSIZE");
		chunkSize = Integer.parseInt(cs);
		try {
			Master m = (Master) Naming.lookup("//" + host + ":" + port + "/GFS_master");
			fileRef = m.lookup(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fpointer = 0;
	}

	/**
	 * establece la posición de acceso al fichero
	 * 
	 * @param off
	 */
	public void seek(int off) {
		fpointer = off;
	}

	/**
	 * obtiene la posición de acceso al fichero
	 * 
	 * @return int
	 */
	public int getFilePointer() {
		return fpointer;
	}

	/**
	 * obtiene la longitud del fichero en bytes
	 * 
	 * @return int
	 * @throws RemoteException
	 */
	public int length() throws RemoteException {
		return fileRef.getNumberOfChunks() * chunkSize;
	}

	/**
	 * lee de la posición actual del fichero la cantidad de datos pedida; devuelve
	 * cantidad realmente leída, 0 si EOF; actualiza la posición de acceso al
	 * fichero
	 * 
	 * @param buf
	 * @return int
	 * @throws RemoteException
	 */
	public int read(byte[] buf) throws RemoteException {
		int wrtlength = buf.length;
		int startchunk = fpointer / chunkSize;
		int nchunks = wrtlength / chunkSize;
		List<Chunk> fchunks = fileRef.getChunkDescriptors(startchunk, nchunks);
		int slicestart = 0;
		for (Chunk c : fchunks) {
			if (c != null) {
				DataNode pdn = c.getChunkDataNodes().get(0);
				boolean res;
				byte[] readbt;
				try {
					readbt = pdn.readChunk(c.getChunkName());
				} catch (RemoteException e) {
					wrtlength = 0;
					break;
				}
				System.arraycopy(readbt, 0, buf, slicestart, chunkSize);
			} else {
				Arrays.fill(buf, slicestart, slicestart + chunkSize, (byte) 0x00);
			}
			slicestart += chunkSize;
		}
		fpointer += slicestart;
		return slicestart;
	}

	/**
	 * escribe en la posición actual del fichero los datos especificados; devuelve
	 * falso si se ha producido un error en writeChunk; actualiza la posición de
	 * acceso al fichero
	 * 
	 * @param buf
	 * @return boolean
	 * @throws RemoteExceptionfileRef = m.lookup(fileName);
	 */
	public boolean write(byte[] buf) throws RemoteException {
		int wrtlength = buf.length;
		boolean ret = false;
		int startchunk = fpointer / chunkSize;
		int nchunks = wrtlength / chunkSize;
		List<Chunk> fchunks = fileRef.allocateChunkDescriptors(startchunk, nchunks);
		int slicestart = 0;
		for (Chunk c : fchunks) {
			if (c != null) {
				List<DataNode> dnl = new ArrayList<>(c.getChunkDataNodes());
				dnl.remove(0);
				DataNode pdn = c.getChunkDataNodes().get(0);
				ret = pdn.writeChunk(dnl, c.getChunkName(),
						Arrays.copyOfRange(buf, slicestart, slicestart + chunkSize));
				slicestart += chunkSize;
			}
		}
		fpointer += wrtlength;
		return ret;
	}
}
