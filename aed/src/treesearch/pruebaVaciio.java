package treesearch;

import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.set.PositionListSet;
import es.upm.aedlib.set.Set;

public class pruebaVaciio {

	public static void main(String[] args) {
		Set<PositionList<String>> paths = new PositionListSet<PositionList<String>>();
		PositionList<String> lista1 = new NodePositionList<String>();
		lista1.addFirst("hola");
		PositionList<String> lista2 = new NodePositionList<String>();
		paths.add(lista1);
		paths.add(lista2);
		System.out.println(paths);
		treesearch.TreeSearch.constructDeterministicTree(paths);
		System.out.println(paths);
	}

}
