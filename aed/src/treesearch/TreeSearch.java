package treesearch;

import es.upm.aedlib.Position;
import es.upm.aedlib.set.*;
import es.upm.aedlib.positionlist.*;
import es.upm.aedlib.tree.*;

public class TreeSearch {

	private static void searchRec(Tree<String> t, PositionList<String> searchExprs, Position<String> cExpr,
			Position<String> cTree, Set<Position<String>> set) {
		Position<String> next = searchExprs.next(cExpr);
		if (next == null) { // final de lista compruebo segun ultimo elemento de lista
			if (t.isRoot(cTree) || cTree.element().equals(cExpr.element()))
				set.add(cTree);// ultimo es hoja(el que buscamos) o raiz -> al set
			else
				for (Position<String> son : t.children(t.parent(cTree)))
					set.add(son); // comodin meto todos los hijos del padre de cTree
			return;
		}
		for (Position<String> son : t.children(cTree)) { // recorrido normal, busco el siguiente nodo en los hijos desde
															// donde estoy, si encontrado o comodin, recursion
															// actualizada
			if (son.element().equals(next.element()) || next.element().equals("*")) {
				searchRec(t, searchExprs, next, son, set);
			}
		}
	}

	public static Set<Position<String>> search(Tree<String> t, PositionList<String> searchExprs) {
		Set<Position<String>> resultado = new PositionListSet<Position<String>>();
		Position<String> first = searchExprs.first();
		Position<String> root = t.root();
		if (first.element().equals(root.element()) || first.element().equals("*"))
			if (searchExprs.size() == 1)
				resultado.add(root);
			else
				searchRec(t, searchExprs, first, root, resultado);
		return resultado;
	}

	/*
	 * Dado un arbol, una posicion de un camino y la posicion actual en dicho arbol,
	 * devuelve la posicion en el arbol si el elemento del camino es hijo de la
	 * posicion actual en el arbol. Si el return=null no es hijo
	 */
	private static Position<String> esHijo(Tree<String> arbol, Position<String> cCamino, Position<String> cArbol) {
		Position<String> hijoArbol = null;
		for (Position<String> hijo : arbol.children(cArbol)) {
			if (hijo != null) {
				if (cCamino.element().equals(hijo.element())) {
					hijoArbol = hijo;
				}
			}
		}
		return hijoArbol;
	}

	public static Tree<String> constructDeterministicTree(Set<PositionList<String>> paths) {
		LinkedGeneralTree<String> arbol = new LinkedGeneralTree<String>();
		for (PositionList<String> lista : paths)
			if (lista != null)
				if (lista.isEmpty())
					paths.remove(lista);// Limpiamos el set de listas vacias
		if (!paths.isEmpty()) {
			arbol.addRoot(paths.iterator().next().first().element());// Añadimos raíz
			for (PositionList<String> camino : paths) {
				Position<String> cArbol = arbol.root();
				if (search(arbol, camino).isEmpty()) { // Set vacio = no existe camino -> lo creo
					Position<String> cCamino = camino.first();
					cCamino = camino.next(cCamino);// nos saltamos la raiz
					while (cCamino != null) {
						Position<String> hijoArbol = esHijo(arbol, cCamino, cArbol);
						if (hijoArbol == null) {
							arbol.addChildLast(cArbol, cCamino.element());
							cArbol = esHijo(arbol, cCamino, cArbol);
						} else
							cArbol = hijoArbol;
						cCamino = camino.next(cCamino);
					}
				}
			}
		}
		return arbol;
	}
}
