package individual6;

import es.upm.aedlib.graph.Edge;
import es.upm.aedlib.graph.Vertex;
import es.upm.aedlib.graph.DirectedAdjacencyListGraph;
import es.upm.aedlib.graph.DirectedGraph;
import es.upm.aedlib.map.Map;
import es.upm.aedlib.set.HashTableMapSet;
import es.upm.aedlib.set.Set;
import es.upm.aedlib.map.HashTableMap;

public class Suma {

	private static <E> int sumReachable(Vertex<Integer> vert, DirectedGraph<Integer, E> graph, Set<Vertex<Integer>>visitados) {
		int suma = vert.element();
		System.out.println("Vertice: "+vert);
		for(Edge<E> outEdge : graph.outgoingEdges(vert)) {
			Vertex<Integer> nextvert=graph.endVertex(outEdge);
			System.out.println(visitados.contains(nextvert));
			if (!visitados.contains(nextvert)) {
				visitados.add(nextvert);
				suma +=sumReachable(nextvert, graph, visitados);
			}
		}
		System.out.println("suma final=" +suma);
		return suma;
	}

	public static <E> Map<Vertex<Integer>, Integer> sumVertices(DirectedGraph<Integer, E> graph) {
		Map<Vertex<Integer>, Integer> map = new HashTableMap<Vertex<Integer>, Integer>();
		System.out.println(graph.toDot());
		if (!graph.isEmpty()) {
			for (Vertex<Integer> vertex : graph.vertices()) { 
				Set<Vertex<Integer>> visitados = new HashTableMapSet<Vertex<Integer>>();
				visitados.add(vertex);
				System.out.println("\n nuevoVert: "+vertex );
				map.put(vertex,sumReachable(vertex, graph, visitados));
			}
		}
		return map;
	}
}