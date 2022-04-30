package gestionpedidos;

import javax.lang.model.type.NullType;

import gestionpedidos.excepciones.PedidoSinTransporteAsignado;

import gestionpedidos.mapa.Mapa;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Furgoneta;
import gestionpedidos.transportes.Moto;
import gestionpedidos.transportes.Transporte;
import list.ArrayList;
import list.IList;
import queues.IQueue;
import queues.exceptions.EmptyQueueException;
import queues.CircularQueue;
import anotacion.Programacion2;

@Programacion2(nombreAutor1 = "Nicolas", apellidoAutor1 = "Cossio Miravalles", emailUPMAutor1 = "n.cossio@alumnos.upm.es", nombreAutor2 = "Antonio", apellidoAutor2 = "Amo Cuellar", emailUPMAutor2 = "antonio.amo.cuellar@alumnos.upm.es")

public class GestionRepartoLocal {
	// Cï¿½DIGO DE APOYO
	private IList<Moto> motosDisponibles;
	private IList<Furgoneta> furgonetasDisponibles;

	private IQueue<Pedido> pedidosEsperandoMoto;
	private IQueue<Pedido> pedidosEsperandoFurgoneta;

	// Cï¿½DIGO DE APOYO
	public String getDisponibles() {
		return "Motos Disponibles:"
				+ GestionRepartoLocalFuncionesAuxiliares
						.myArrayListToString(GestionRepartoLocalFuncionesAuxiliares.getCodList(motosDisponibles))
				+ System.lineSeparator() + "Furgonetas Disponibles:"
				+ GestionRepartoLocalFuncionesAuxiliares
						.myArrayListToString(GestionRepartoLocalFuncionesAuxiliares.getCodList(furgonetasDisponibles))
				+ System.lineSeparator();

	}

	// Cï¿½DIGO DE APOYO
	public String getEsperando() {
		return "Pedidos esperando moto:"
				+ GestionRepartoLocalFuncionesAuxiliares.myArrayListToString(
						GestionRepartoLocalFuncionesAuxiliares.getClienteRestauranteList(pedidosEsperandoMoto))
				+ System.lineSeparator() + "Pedidos esperando furgoneta:"
				+ GestionRepartoLocalFuncionesAuxiliares.myArrayListToString(
						GestionRepartoLocalFuncionesAuxiliares.getClienteRestauranteList(pedidosEsperandoFurgoneta))
				+ System.lineSeparator();
	}

	// Cï¿½DIGO DE APOYO
	public IList<String> getCodMotosDisponibles() {
		return GestionRepartoLocalFuncionesAuxiliares.getCodList(motosDisponibles);
	}

	// Cï¿½DIGO DE APOYO
	public IList<String> getCodFurgoDisponibles() {
		return GestionRepartoLocalFuncionesAuxiliares.getCodList(furgonetasDisponibles);

	}

	// Cï¿½DIGO DE APOYO
	public IList<String[]> getCodEsperandoMoto() {
		return GestionRepartoLocalFuncionesAuxiliares.getClienteRestauranteList(pedidosEsperandoMoto);
	}

	public IList<String[]> getCodEsperandoFurgo() {
		return GestionRepartoLocalFuncionesAuxiliares.getClienteRestauranteList(pedidosEsperandoFurgoneta);
	}

	private static final double PESO_MAX_MOTO = 20;

	// Cï¿½DIGO DE APOYO
	public GestionRepartoLocal() {

		this.motosDisponibles = new ArrayList<>();
		this.furgonetasDisponibles = new ArrayList<>();

		this.pedidosEsperandoFurgoneta = new CircularQueue<>();
		this.pedidosEsperandoMoto = new CircularQueue<>();
	}

	public void add(Transporte transporte) {
		// Motos
		if (transporte instanceof Moto) {
			motosDisponibles.add(motosDisponibles.size(), (Moto) transporte);
		}
		// Furgonetas
		else {
			furgonetasDisponibles.add(furgonetasDisponibles.size(), (Furgoneta) transporte);
		}
	}

	public void asignarPedido(Pedido pedido) {
		double mejorcoste;// Coste del pedido con el primer transporte del array para comparar con el
							// resto del array de transportes disponibles
		int i = 0, j = 1, index = 0;
		// Motos
		if (pedido.getPeso() <= PESO_MAX_MOTO) {
			if (motosDisponibles.size() == 0) { // No hay motos disponibles
				pedidosEsperandoMoto.add(pedido);// Se añade la moto al final de la cola de disponibles
			} else {

				for (i = 0, j = 1; i < motosDisponibles.size() && j < motosDisponibles.size(); i++, j++) { // Empezamos
																											// comparando
																											// el
																											// primero
																											// con el
																											// segundo,
																											// etc.
					mejorcoste = pedido.coste(motosDisponibles.get(i));
					if (mejorcoste > pedido.coste(motosDisponibles.get(j))) {
						index = j;// guardamos la posicion del tranporte con mejor precio
					}
				}
				pedido.setTransporte(motosDisponibles.get(index));
				motosDisponibles.removeElementAt(index);
			}
		}
		// Furgonetas
		else {
			if (furgonetasDisponibles.size() == 0) {
				pedidosEsperandoFurgoneta.add(pedido);
			} else {

				for (i = 0, j = 1; i < furgonetasDisponibles.size() && j < furgonetasDisponibles.size(); i++, j++) { // Empezamos
																														// comparando
																														// el
																														// primero
																														// con
																														// el
																														// segundo,
																														// etc.
					mejorcoste = pedido.coste(furgonetasDisponibles.get(i));
					if (mejorcoste > pedido.coste(furgonetasDisponibles.get(j))) {
						index = j;
					}
				}
				pedido.setTransporte(furgonetasDisponibles.get(index));
				furgonetasDisponibles.removeElementAt(index);
			}
		}
	}

	private void notificador(Pedido pedido) {
		Transporte transpedido = pedido.getTransporte();
		// Saca un pedido que este esperando una moto y le asigna la moto que se ha
		// quedado libre del pedido notificado
		if (transpedido instanceof Moto) {
			if (pedidosEsperandoMoto.isEmpty()) {
				motosDisponibles.add(motosDisponibles.size(), (Moto) transpedido);
			} else {
				try {
					pedidosEsperandoMoto.poll().setTransporte(transpedido);
				} catch (EmptyQueueException e) {
					e.printStackTrace();
				}
			}
		}
		// Como no es una moto, saca un pedido que este esperando una furgoneta y le
		// asigna la furgoneta que se ha quedado libre del pedido notificado
		else {
			if (pedidosEsperandoFurgoneta.isEmpty()) {
				furgonetasDisponibles.add(furgonetasDisponibles.size(), (Furgoneta) transpedido);
			} else {
				try {
					pedidosEsperandoFurgoneta.poll().setTransporte(transpedido);
				} catch (EmptyQueueException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// PRE: el pedido tiene asignado un transporte
	public void notificarEntregaPedido(Pedido pedido) throws PedidoSinTransporteAsignado {
		// No tiene un transpore asignado -->Excepcion
		if (pedido.getTransporte() == null) {
			throw new PedidoSinTransporteAsignado("Este pedido no tiene un transporte asginado");
		}
		// Si hay transporte asignado
		else {
			notificador(pedido);
		}
	}
}
