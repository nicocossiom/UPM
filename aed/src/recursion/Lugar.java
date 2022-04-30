package recursion;

import es.upm.aedlib.positionlist.*;

/**
 * A Lugar represents a position in the maze.
 */
public class Lugar {
	Punto[][] cueva;
	int maxY;
	int maxX;
	int y;
	int x;

	public Lugar(Punto[][] cueva, int y, int x) {
		this.cueva = cueva;
		this.maxY = cueva.length;
		this.maxX = cueva[0].length;
		this.y = y;
		this.x = x;
	}

	public Lugar(Lugar oldCueva) {
		this.maxY = oldCueva.maxY;
		this.maxX = oldCueva.maxX;
		this.y = y;
		this.x = x;
		this.cueva = new Punto[maxY][maxX];
		for (int y = 0; y < maxY; y++)
			for (int x = 0; x < maxX; x++)
				cueva[y][x] = new Punto(oldCueva.cueva[y][x]);
	}

	/**
	 * Returns true if the lugar has a tesoro.
	 * 
	 * @return true if the lugar has a tesoro.
	 */
	public boolean tieneTesoro() {
		return cueva[y][x].tieneTesoro();
	}

	/**
	 * Returns the tesoro in the lugar, or null if no tesoro exists.
	 * 
	 * @return the tesoro in the lugar.
	 */
	public Object getTesoro() {
		return cueva[y][x].getTesoro();
	}

	/**
	 * Returns true if the lugar is marked with tiza.
	 * 
	 * @return true if the lugar is marked with tiza.
	 */
	public boolean sueloMarcadoConTiza() {
		return cueva[y][x].sueloMarcadoConTiza();
	}

	/**
	 * Mark the lugar with tiza.
	 */
	public void marcaSueloConTiza() {
		cueva[y][x].marcaSueloConTiza();
	}

	/**
	 * Returns an iterable composed of the lugares reachable from this lugar.
	 * 
	 * @return an iterable composed of the lugares reachable from this lugar.
	 */
	public Iterable<Lugar> caminos() {
		PositionList<Lugar> caminos = new NodePositionList<Lugar>();
		for (PuntoCardinal pc : PuntoCardinal.values()) {
			Lugar lugarNuevo = ir(pc);
			if (lugarNuevo != null)
				caminos.addLast(lugarNuevo);
		}
		return caminos;
	}

	Lugar ir(PuntoCardinal pc) {
		int nuevoY = y;
		int nuevoX = x;
		boolean enabled;

		switch (pc) {
		case NORTE:
			nuevoY = y + 1;
			break;
		case SUR:
			nuevoY = y - 1;
			break;
		case ESTE:
			nuevoX = x + 1;
			break;
		case OESTE:
			nuevoX = x - 1;
			break;
		default:
			nuevoY = y - 1;
		}

		if (cueva[y][x].accessible(pc)) {
			if (nuevoY >= 0 && nuevoY < maxY && nuevoX >= 0 && nuevoX < maxX)
				return new Lugar(cueva, nuevoY, nuevoX);
			else
				return null;
		} else
			return null;
	}

	public String toString() {
		String tiza = sueloMarcadoConTiza() ? ",tiza" : "";
		String result = "(" + x + "," + y + tiza + ")";
		return result;
	}

	/**
	 * Prints the laberinto on the standard output.
	 */
	public void printLaberinto() {
		System.out.println(Punto.printPuntos(cueva, y, x));
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Lugar) {
			Lugar otherLugar = (Lugar) obj;
			return (this.x == otherLugar.x) && (this.y == otherLugar.y);
		} else
			return false;
	}

	public int hashCode() {
		return this.x + this.y;
	}
}
