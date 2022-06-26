import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;


public interface ServerInterface extends Remote {
    void addTransaccionesArrayList(Map<String, List<Transaccion>> listTransaccionesTPV, int tpv) throws RemoteException;

    void addTransaccionesArrayList(Map<String, List<Transaccion>> transacciones, int id, TPVCallback da) throws RemoteException;
}
