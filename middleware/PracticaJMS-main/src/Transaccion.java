import java.io.Serializable;

public class Transaccion implements Serializable{

    private String fecha;
    private String hora;
    private String idCliente;
    private int importe;
    
    // Construcctor Transaccion
    public Transaccion(String fecha, String hora, String idCliente, String importe){
        this.fecha=fecha;
        this.hora=hora;
        this.idCliente=idCliente;
        this.importe=Integer.parseInt(importe);
    }

    // equals() que compara todos los atributos
    public boolean equals(Transaccion t){
       return  t.fecha.equals(this.fecha) && t.hora.equals(this.hora)&& t.idCliente.equals(this.idCliente) && t.importe==this.importe;
                
    }
    public boolean equalsInternacional(Transaccion t){
        return  t.fecha.equals(this.fecha) && t.idCliente.equals(this.idCliente) && t.importe==this.importe;
                 
     }
    //getters
    public String getFecha(){
        return this.fecha;
    }

    public String getHora(){
        return this.hora;
    }

    public String getIdCliente(){
        return this.idCliente;
    }

    public int getImporte(){
        return this.importe;
    }
    public int getIdRegion() {
    	return Character.getNumericValue(idCliente.charAt(0));
    }

    // toString del objeto Transaccion
    public String toString(){
        return this.fecha+" "+this.hora+" "+this.idCliente+" "+this.importe;
    }
}
