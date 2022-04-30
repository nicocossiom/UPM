/**
 * 
 */
package admin;

import admin.exception.ErrorNoHayTramites;
import list.ArrayList;
import queues.CircularQueue;
import queues.exceptions.EmptyQueueException;

/**
 * @author angel
 *
 */
public class GestorTramites {
	private ArrayList<CircularQueue<Tramite>> tramitesEnEspera;
	private int nTotalEsperando = 0;
	
	
	/**
	 * Crea una nueva instancia inicializando el atributo tramitesEnEspera
	 * como una lista con una cola vacía para tipo de trámite.
	 * 
	 * PRE: Cierto
	 */
	public GestorTramites() {		
		tramitesEnEspera= new ArrayList<CircularQueue<Tramite>>(); //Inicializamos el arrayList
		//Inicializamos los CircularQues, cada uno manejar� un tipo de tramite
		tramitesEnEspera.add(0, new CircularQueue<Tramite>());
		tramitesEnEspera.add(1, new CircularQueue<Tramite>());
		tramitesEnEspera.add(2, new CircularQueue<Tramite>());
		tramitesEnEspera.add(3, new CircularQueue<Tramite>());
	}
	
	
	/**
	 * Este metodo recibe un tipo de trámite, crea el trámite correspondiente
	 * Lo pone en la cola de espera que corresponda y retorna el ID del registro
	 * 
	 * PRE: Cierto
	 * @param tipo de trámite que se está registrando
	 * @return retorna el ID del tramite que se acaba de registrar
	 */
	public String registrarTramite (TipoTramites tipo) {
		Tramite nTramite=new Tramite (tipo);
		switch(tipo) {
		case HACIENDA:
			tramitesEnEspera.get(0).add(nTramite);
		case JUSTICIA:
			tramitesEnEspera.get(1).add(nTramite);
		case SANIDAD:
			tramitesEnEspera.get(3).add(nTramite);
		case TRABAJO:
			tramitesEnEspera.get(2).add(nTramite);
		}
		nTotalEsperando++;
		return nTramite.getIdRegistro();
	}
	

	/**
	 * Extrae y retorna el siguiente trámite a ser procesado.
	 * Primero se comprueba si hay trámites esperando en la cola del tipo con
	 * mayor prioridad. Si esa cola está vacía, se comprueba la cola del siguiente
	 * tipo con mayor prioridad, y así sucesivamente. 
	 * Siempre se extrae y retorna el trámite 
	 * que lleve más tiempo esperando de la mayor prioridad disponible.
	 * 
	 * PRE: hay Tramites
	 * @return Siguiente trámite a ser procesado
	 * @throws ErrorNoHayTramites
	 * @throws EmptyQueueException 
	 * @throws IndexOutOfBoundsException 
	 */
	public Tramite getNext() throws ErrorNoHayTramites{
		Tramite nTramite = null;
		boolean stop=false;
		if(nTotalEsperando==0) {
				throw new ErrorNoHayTramites("No hay tramites esperando a ser procesados");
		}
		for(int i=0; i<4 && !stop; i++) {
			try {	
			nTramite=tramitesEnEspera.get(i).poll();
				nTotalEsperando--;
				stop=true;
			}
			catch(EmptyQueueException e) {
			}
		}
		if(nTramite==null) {
			throw new ErrorNoHayTramites("No hay tramites esperando a ser procesados");
		}
		return nTramite;
	}
	
	/**
	 * PRE: Cierto
	 * 
	 * @return Este método retorna cierto si hay trámites esperando para ser procesados
	 */
	public boolean hayTramites() {
		return this.nTotalEsperando > 0;
	}
	
	/**
	 * PRE: Cierto
	 * @return retorna el número total de trámites que están esperando para ser atendidos
	 */
	public int totalEsperando() {
		return nTotalEsperando;
	}
}
