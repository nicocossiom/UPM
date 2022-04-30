package gestionpedidos.excepciones;

public class PedidoSinTransporteAsignado extends Exception {
	
	public PedidoSinTransporteAsignado() {}

	public PedidoSinTransporteAsignado(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
