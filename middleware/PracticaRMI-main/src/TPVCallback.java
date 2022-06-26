import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TPVCallback extends Remote{
	public void recibeBonificacion(String rankingLocal) throws RemoteException;
	public int getNumTPV() throws RemoteException;
}
