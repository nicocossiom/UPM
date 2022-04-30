package recursion;

import java.util.Iterator;

import es.upm.aedlib.Pair;
import es.upm.aedlib.positionlist.*;

public class Explorador {

	private static void doralaExploradora(Lugar nodoActual, Pair<Object, PositionList<Lugar>> thisIstheWay) {
		// caso base, lo que busco es el tesoro, si lo encuentro, guardo mi posicion y
		// el tesoro,
		if (nodoActual.tieneTesoro()) {
			thisIstheWay.setLeft(nodoActual.getTesoro());
			thisIstheWay.getRight().addLast(nodoActual);
			return; // he terminado
		}
		// caso base, si estoy en un sitio que no he estado antes, lo marco y lo añado a
		// mi lista
		if (!nodoActual.sueloMarcadoConTiza()) {
			nodoActual.marcaSueloConTiza();
			thisIstheWay.getRight().addLast(nodoActual);
		}
		Iterator<Lugar> ways = nodoActual.caminos().iterator(); // Los caminos desde donde estoy yo/dora
		while (ways.hasNext()) { // recorro/dora los caminos caminos que hay desde donde estoy/dora
			nodoActual.printLaberinto();
			Lugar nextnode = ways.next();
			if (!nextnode.sueloMarcadoConTiza()) { // si el siguiente camino no lo he visitado que lo explora dora, me
													// dira si hay un tesoro
				doralaExploradora(nextnode, thisIstheWay);
				return; // los recorrere todos a no ser que me encuentre el tesoro, dora lo ha
						// encontrado, he terminado
			}
		}
		// dora ha recorrido todos los caminos, y si no ha parado de recorrerlos
		// significa que no lo ha encontrado
		System.out.println("Por aqui no, vuelvo al nodo anterior y pruebo el siguiente camino");
		thisIstheWay.getRight().remove(thisIstheWay.getRight().last());// los caminos del ultimo lugar no me valen
		doralaExploradora(thisIstheWay.getRight().last().element(), thisIstheWay); // que dora pruebe con los caminos
																					// que le quedaban del lugar
																					// anterior
		return; // los recorrere todos a no se que me encuentre el tesoro, si se ejecuta esta
				// linea es que dora lo ha encontrado, he terminado
	}

	public static Pair<Object, PositionList<Lugar>> explora(Lugar inicialLugar) {
		PositionList<Lugar> thepath = new NodePositionList<Lugar>();
		Pair<Object, PositionList<Lugar>> thisIsTheWay = new Pair<Object, PositionList<Lugar>>(null, thepath);
		doralaExploradora(inicialLugar, thisIsTheWay);
		return thisIsTheWay;
	}
}
