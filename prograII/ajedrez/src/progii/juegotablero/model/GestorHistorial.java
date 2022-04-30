package progii.juegotablero.model;

import progii.juegotablero.exceptions.MovimientoException;
import stacks.exceptions.EmptyStackException;
import stacks.Stack;

/**
 * Clase que gestiona el historial de movimientos de la partida
 * 
 *
 */
public class GestorHistorial {

	/**
	 * Pila con los movimientos a deshacer
	 */
	// TODO

	/**
	 * Pila con los movimientos a rehacer
	 */
	// TODO

	/**
	 * Crea e inicializa las pilas del gestor del historial
	 */
	public GestorHistorial() {
		// TODO
	}

	/**
	 * Guarda un nuevo movimientos en el historial
	 * 
	 * @param movimiento Movimiento a guardar
	 */
	public void guardarMovimiento(Movimiento movimiento) {
		// TODO
	}

	/**
	 * Devuelve el último movimiento realizado y lo elimina de la pila de deshacer
	 * 
	 * @return El movimiento a deshacer
	 * @throws MovimientoException En caso de que no haya movimientos que deshacer
	 */
	public Movimiento deshacer() throws MovimientoException {
		// TODO
		return null; // Sentencia dummy
	}

	/**
	 * Devuelve el último movimiento deshecho y lo elimina de la pila de rehacer
	 * 
	 * @return El movimiento a rehacer
	 * @throws MovimientoException En caso de que no haya movimientos que rehacer
	 */
	public Movimiento rehacer() throws MovimientoException {
		// TODO
		return null; // Sentencia dummy
	}

}
