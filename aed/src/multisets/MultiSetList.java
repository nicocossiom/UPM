package multisets;

import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.positionlist.NodePositionList;

/**
 * An implementation of a multiset using a positionlist.
 */
public class MultiSetList<Element> implements MultiSet<Element> {

	/**
	 * Datastructure for storing the multiset.
	 */
	private PositionList<Pair<Element, Integer>> elements;

	private int size;

	/**
	 * Constructs an empty multiset.
	 */
	public MultiSetList() {
		this.elements = new NodePositionList<Pair<Element, Integer>>();
	}

	private PositionList<Pair<Element, Integer>> getElements() {
		return elements;
	}

	private static boolean eqNull(Object o1, Object o2) {
		return o1 == o2 || o1 != null && o1.equals(o2);
	}

	private Position<Pair<Element, Integer>> buscador(Element el) {
		Position<Pair<Element, Integer>> cursor = elements.first();
		boolean found = false;
		while (cursor != null && !found) {
			if (eqNull(el, cursor.element().getLeft())) {
				found = true;
			} else {
				cursor = elements.next(cursor);
			}
		}
		return cursor;
	}

	@Override
	public void add(Element elem, int n) {
		if (n > 0) {
			Position<Pair<Element, Integer>> elemento = buscador(elem);
			if (elemento != null) {
				int num = elemento.element().getRight();
				elemento.element().setRight(num + n);
			} else {
				Pair<Element, Integer> pareja = new Pair<Element, Integer>(elem, n);
				elements.addLast(pareja);
			}
			size = size + n;
		} else if (n < 0) {
			throw new IllegalArgumentException();
		}

	}

	@Override
	public void remove(Element elem, int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		else if (n > 0) {
			Position<Pair<Element, Integer>> posicion = buscador(elem);
			if (posicion != null) {
				size = size - n;
				Pair<Element, Integer> pareja = posicion.element();
				int viejonum = pareja.getRight();
				int nuevonum = viejonum - n;
				if (nuevonum == 0) {
					elements.remove(posicion);
				} else if (nuevonum <= 0) {
					throw new IllegalArgumentException();
				} else {
					pareja.setRight(pareja.getRight() - n);
				}
			} else
				throw new IllegalArgumentException();
		}
	}

	@Override
	public int count(Element elem) {
		int result = 0;
		if (size() > 0) {
			Position<Pair<Element, Integer>> cursor = buscador(elem);
			if (cursor != null) {
				result = cursor.element().getRight();
			}
		}
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public PositionList<Element> allElements() {
		PositionList<Element> result = new NodePositionList<Element>();
		Position<Pair<Element, Integer>> cursor = this.elements.first();
		while (cursor != null) {
			int num = cursor.element().getRight();
			while (num != 0) {
				result.addLast(cursor.element().getLeft());
				num--;
			}
			cursor = elements.next(cursor);
		}
		return result;
	}

	@Override
	public MultiSet<Element> intersection(MultiSet<Element> s) {
		MultiSet<Element> result = new MultiSetList<Element>();
		if (this.equals(s)) {
			result = s;
		} else {
			if (size() > 0) {
				Position<Pair<Element, Integer>> cursor = this.elements.first();
				while (cursor != null) {
					int num1 = cursor.element().getRight();
					int num2 = s.count(cursor.element().getLeft());
					Element element = cursor.element().getLeft();
					if (num2 != 0) {
						if (num1 > num2) {
							result.add(element, num2);
						} else {
							result.add(element, num1);
						}
					}
					cursor = this.elements.next(cursor);
				}
			}
		}

		return result;
	}

	@Override
	public MultiSet<Element> sum(MultiSet<Element> s) {
		MultiSet<Element> result = new MultiSetList<Element>();
		Position<Pair<Element, Integer>> cursor1 = this.elements.first();
		Position<Pair<Element, Integer>> cursor2 = ((MultiSetList<Element>) s).getElements().first();
		while (cursor1 != null) {
			Element element1 = cursor1.element().getLeft();
			int num1 = cursor1.element().getRight();
			result.add(element1, num1);
			cursor1 = elements.next(cursor1);
		}
		while (cursor2 != null) {
			Element element2 = cursor2.element().getLeft();
			int num2 = cursor2.element().getRight();
			result.add(element2, num2);
			cursor2 = ((MultiSetList<Element>) s).getElements().next(cursor2);
		}
		return result;
	}

	@Override
	public MultiSet<Element> minus(MultiSet<Element> s) {
		MultiSet<Element> result = new MultiSetList<Element>();
		if (!this.isEmpty()) {
			Position<Pair<Element, Integer>> cursor1 = this.elements.first();
			while (cursor1 != null) {
				int num1 = cursor1.element().getRight();
				int num2 = s.count(cursor1.element().getLeft());
				Element element = cursor1.element().getLeft();
				int resta = num1 - num2;
				if (resta > 0) {
					result.add(element, resta);
				}
				cursor1 = elements.next(cursor1);
			}
		}
		return result;
	}

}
