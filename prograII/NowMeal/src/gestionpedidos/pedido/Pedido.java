package gestionpedidos.pedido;

import gestionpedidos.transportes.Transporte;
import anotacion.Programacion2;
@Programacion2 (
	nombreAutor1 = "Nicolas",
	apellidoAutor1 = "Cossio Miravalles",
	emailUPMAutor1 = "n.cossio@alumnos.upm.es",
	nombreAutor2 = "Antonio",
	apellidoAutor2 = "Amo Cuellar",
	emailUPMAutor2 = "antonio.amo.cuellar@alumnos.upm.es"
)


public class Pedido {
	// C�DIGO DE APOYO
	private Cliente cliente;
	@SuppressWarnings("unused")
	private PlatoComida[] comidas;
	private Restaurante restaurante;
	private double importe;
	private Transporte transporte;
	private double peso;

	public Pedido(Cliente cliente, PlatoComida[] comidas, Restaurante restaurante) {
		this.cliente=cliente;
		this.comidas=comidas;
		this.restaurante=restaurante;
		for (int i=0; i<comidas.length; i++) {
			importe+= comidas[i].getPrecio();
			peso+=comidas[i].getPeso();
		}
	}


	public double getPeso(){
		return peso;
	}


	public double coste(Transporte transporte) {
		double costefinal;
		//Coste ubicacion del transporte hasta el restaurante
		double transporterestaurante=transporte.coste(this.restaurante.getCodigo());
		//Coste del transporte desde el resaurante hasta el cliente
		double restaurantecliente=transporte.coste(this.restaurante.getCodigo(),this.cliente.getCodigo());
		//Precio final si es menor de 100
		costefinal=importe+transporterestaurante+restaurantecliente;
		//Precio final si el importe es mayor o igual que 100e
		if (importe>=100) {
			costefinal=costefinal*1.10;
		}
		return costefinal;
	}

	// C�DIGO DE APOYO
	public double getImporte(){
		return importe;
	}

	// C�DIGO DE APOYO
	public Transporte getTransporte() {
		return transporte;
	}

	// C�DIGO DE APOYO
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	// C�DIGO DE APOYO
	public Cliente getCliente(){
		return cliente;
	}

	// C�DIGO DE APOYO
	public Restaurante getRestaurante(){
		return restaurante;
	}
}
