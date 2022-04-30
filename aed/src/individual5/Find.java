package individual5;

import es.upm.aedlib.tree.Tree;
import es.upm.aedlib.Position;

public class Find {

	private static <E> void recursiveFinder(Tree<String> directory, Position<String> p, String fileName, String path) {
		// add camino to lista caminos
		path = path + "/" + p.element();
		// Encontrado printeo
		if (p.element().equals(fileName)) {
			Printer.enableOutput();
			Printer.println(path);
			return;
		}
		for (Position<String> son : directory.children(p)) {
			recursiveFinder(directory, son, fileName, path);
		}

	}

	/*
	 * Busca ficheros con nombre igual que fileName dentro el arbol directory, y
	 * devuelve un PositionList con el nombre completo de los ficheros (incluyendo
	 * el camino).
	 */

	public static void find(String fileName, Tree<String> directory) {
		// Doy por hecho que el arbol no esta vacio, sino haria un IllegalArgument
		String path = "";
		// Llamo a metodo recursivo
		recursiveFinder(directory, directory.root(), fileName, path);

	}
}
