package individual3;

import java.util.Iterator;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

public class OperacionCompactar {

	private static boolean eqNull(Object e1, Object e2) {
		return e1 == null && e2 == null || e1 != null && e1.equals(e2);
	}

	/**
	 * Metodo que reduce los elementos iguales consecutivos de una lista a una unica
	 * repeticion
	 * 
	 * @param lista Lista de entrada
	 * @return Lista nueva compactada sin elementos iguales consecutivos
	 */
	public static <E> PositionList<E> compactar(Iterable<E> lista) {
		PositionList<E> resultado = new NodePositionList<E>();
		Iterator<E> it = lista.iterator();
		E elem = it.next();
		resultado.addFirst(elem);
		Position<E> cursor = resultado.first();
		/*
		 * We will go through the lista and we will compare it with the positionlist
		 * that we are returning. The cursor for resultado will not be resetted because
		 * we want to know if the last element in it is the same as the one our iterator
		 * is currently pointing at, if it is we will just make the iterator point to
		 * the next element. If it is we will add it to the positionlist, also we will
		 * make the cursor move to that element that we just added, so we can do it all
		 * over again
		 */
		for (; it.hasNext(); elem = it.next()) {
			if (!eqNull(cursor.element(), elem)) {
				resultado.addLast(elem);
				cursor = resultado.next(cursor);
			}
		}
		/*
		 * When we get to the last element the iterator points outside the list (null),
		 * and returns that last element that we store in elem, after that it checks if
		 * there are more elements and of course there are none, so it doesn't get
		 * inside the for, but we still haven't added that last element that we have
		 * stored in elem. To fix this since we know it happens after the for, we can
		 * check if there are no more elements in the list then we know that we have add
		 * the one in elem. We also have to check if the last element we added is the
		 * same as the one we are trying to add, hence we use eqNull to check for that
		 * and also be able to work with nulls without exceptions
		 */
		if (!it.hasNext() && !eqNull(elem, cursor.element())) {
			resultado.addLast(elem);
		}
		return resultado;
	}
}
