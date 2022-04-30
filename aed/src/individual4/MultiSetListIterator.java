package individual4;

import java.util.Iterator;
import java.util.NoSuchElementException;

import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.PositionList;

public class MultiSetListIterator<E> implements Iterator<E> {
	PositionList<Pair<E, Integer>> list;
	Position<Pair<E, Integer>> cursor;
	Position<Pair<E, Integer>> prevCursor;
	int elemsinpair; // Counter para saber cuantos elementos hay que devolver en la pareja a la que
						// apunta el cursor

	public MultiSetListIterator(PositionList<Pair<E, Integer>> list) {
		this.list = list;
		prevCursor = null;
		if (!list.isEmpty()) {
			cursor = list.first();
			elemsinpair = cursor.element().getRight();
		}
	}

	public boolean hasNext() {
		return cursor != null;
	}

	public E next() {
		E resultado = null;
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		} else {
			if (elemsinpair > 0) {
				elemsinpair--;
				prevCursor = cursor; // Actualizo el prevCursor para poder operar con el en remove, ademas indica que
										// puedo hacer el remove, ya que he hecho next()
				resultado = cursor.element().getLeft();// guardamos el elemento para devolverlo
				/*
				 * Ya lo hemos devuelto, vamos a mover el cursor al siguiente elemento si hace
				 * falta, si no quedan elementos en la pareja (elemsinpair=0) hacemos update del
				 * cursor y cogemos el siguiente numero de elementos de la pareja nueva a la que
				 * apunta el cursor. Hay que comprabar tambien si hemos devuelto todos los
				 * elementos y por tanto hemos llegado al final del multiset, esto pasa cuando
				 * el siguiente cursor es null
				 */
				if (elemsinpair == 0) {
					cursor = list.next(cursor);
					if (hasNext()) {
						elemsinpair = cursor.element().getRight();
					}
				}
			}
		}
		return resultado;
	}

	public void remove() {
		if (prevCursor == null) {
			throw new IllegalStateException();
		}
		if (prevCursor.element().getRight() > 1) {
			prevCursor.element().setRight(prevCursor.element().getRight() - 1);
		} else {
			list.remove(prevCursor);
		}
		prevCursor = null; // reseteo el prevCursor ya que he hecho remove
	}
}
