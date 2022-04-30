package gestionpedidos;

import gestionpedidos.excepciones.PedidoSinTransporteAsignado;
import gestionpedidos.mapa.Mapa;
import gestionpedidos.mapa.PosicionXY;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Furgoneta;
import gestionpedidos.transportes.Moto;
import gestionpedidos.transportes.Transporte;
import queues.exceptions.EmptyQueueException;
import anotacion.Programacion2;
@Programacion2 (
	nombreAutor1 = "Nicolas",
	apellidoAutor1 = "Cossio Miravalles",
	emailUPMAutor1 = "n.cossio@alumnos.upm.es",
	nombreAutor2 = "Antonio",
	apellidoAutor2 = "Amo Cuellar",
	emailUPMAutor2 = "antonio.amo.cuellar@alumnos.upm.es"
)
public class GestionReparto {
	// C�DIGO DE APOYO
	private GestionRepartoLocal[] gestoresLocales;
	private Mapa mapa;

	//C�DIGO DE APOYO
	public Mapa getMapa() {
		return mapa;
	}

	// C�DIGO DE APOYO
	public String getEstadoGestorLocal(int i){
		return this.gestoresLocales[i].getDisponibles() + this.gestoresLocales[i].getEsperando();
	}

	// C�DIGO DE APOYO
	public String getEstadoGestorLocalNum(int i){
		return this.gestoresLocales[i].getCodMotosDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodFurgoDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoMoto().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoFurgo().size() ;
	}

	@SuppressWarnings("unused")
	public GestionReparto(Mapa mapa){
		//Inicializacion de mapa
		this.mapa=mapa;

		//Inicializaci�n de array de gestores locales, se inicializan los gestores locales y tambien se a�aden al array
		gestoresLocales= new GestionRepartoLocal[4];
		for (int i=0; i< 4; i++) {
			gestoresLocales[i]=new GestionRepartoLocal();
		}

	}

	private int seleccionarLocalidad(PosicionXY pos){
		int result=0;
		int mitx=mapa.getMaxCoordX()/2;
		int mity=mapa.getMaxCoordY()/2;
		if (pos.getX()<=mitx) { //si la x es menor que la mitad del maximo las zonas solo pueden ser 0 o 1
			if (pos.getY()<=mity) {
				result= 0;//si la y es menor que el siguiente a la mitad del maximo estamos en la zona 1
			}
			else {
				result= 2;//si no estaremos en la 0
			}
		}
		else {
			if(pos.getY()<=mity) {
				result=1;
			}
			else {
				result=3;
			}
		}
		return result;
	}

	public void addTransporteLocalidad(Transporte transporte) {
		//El gestor local sera el que este en la misma zona del transporte (seleccionarLocalidad(posicion(transporte))), una vez
		//averiguado simplemente le damos (add) dicho transporte al gestor para que lo gestione
		gestoresLocales[seleccionarLocalidad(mapa.getPosicion(transporte.getCodigo()))].add(transporte);;
	}

	public void asignarPedido(Pedido pedido) {
		//El gestor local sera el que este en la misma zona del pedido (seleccionarLocalidad(posicion(pedido))), una vez
		//averiguado simplemente le damos (asignarPedido) dicho transporte para que lo gestione
		gestoresLocales[seleccionarLocalidad(mapa.getPosicion(pedido.getCliente().getCodigo()))].asignarPedido(pedido);
	}

	public void notificarEntregaPedido(Pedido pedido) throws PedidoSinTransporteAsignado{
		//El gestor local sera el que este en la misma zona del pedido (seleccionarLocalidad(posicion(pedido))), una vez
		//averiguado le pediremos al gestor local de esa zona que notifique de la entrega del pedido
		gestoresLocales[seleccionarLocalidad(mapa.getPosicion(pedido.getCliente().getCodigo()))].notificarEntregaPedido(pedido);
	}
}
