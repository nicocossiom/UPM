import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Transaccion implements Serializable
{
    private String fecha;
    private String hora;
    private String idCliente;
    private int importe;
    private int tpvTrans;
    private int numCliente;
    private int tpvOrigen;
    private boolean isFraud;

    public Transaccion(String fecha, String hora, String idCliente, String importe) {
        super();
        this.fecha=fecha;
        this.hora=hora;
        this.idCliente=idCliente;
        this.importe=Integer.parseInt(importe);
        this.tpvTrans=Character.getNumericValue(idCliente.charAt(1));
        this.numCliente= Integer.parseInt("" + idCliente.charAt(2) + idCliente.charAt(3));
        this.isFraud = false;
    }

    public String getIdCliente()  {
        return idCliente;
    }

    public int getImporte()  {
        return importe;
    }

    public int getIdRegion()  {
        return Character.getNumericValue(idCliente.charAt(0));
    }

    public int getTpvTrans() {
        return tpvTrans;
    }

}
