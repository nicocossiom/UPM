package recursion;

public class Punto {
	private boolean norte;
	private boolean sur;
	private boolean oeste;
	private boolean este;
	private boolean sueloMarcadoConTiza;
	private Object tesoro;

	public Punto(Object tesoro, boolean norte, boolean sur, boolean oeste, boolean este) {
		this.tesoro = tesoro;
		this.norte = norte;
		this.sur = sur;
		this.oeste = oeste;
		this.este = este;
		this.sueloMarcadoConTiza = false;
	}

	public Punto(Punto p) {
		this.tesoro = p.tesoro;
		this.norte = p.norte;
		this.sur = p.sur;
		this.este = p.este;
		this.oeste = p.oeste;
		this.sueloMarcadoConTiza = p.sueloMarcadoConTiza;
	}

	public boolean accessible(PuntoCardinal pc) {
		switch (pc) {
		case NORTE:
			return norte;
		case SUR:
			return sur;
		case ESTE:
			return este;
		case OESTE:
			return oeste;
		default:
			return sur;
		}
	}

	public void setAccessible(PuntoCardinal pc, boolean accessible) {
		switch (pc) {
		case NORTE:
			norte = accessible;
			break;
		case SUR:
			sur = accessible;
			break;
		case ESTE:
			este = accessible;
			break;
		case OESTE:
			oeste = accessible;
			break;
		default:
			sur = accessible;
			break;
		}
	}

	public boolean tieneTesoro() {
		return tesoro != null;
	}

	public Object getTesoro() {
		return tesoro;
	}

	public boolean sueloMarcadoConTiza() {
		return sueloMarcadoConTiza;
	}

	public void marcaSueloConTiza() {
		sueloMarcadoConTiza = true;
	}

	public static Punto[][] copy(Punto[][] puntos) {
		int maxY = puntos.length;
		int maxX = puntos[0].length;

		Punto[][] copy = new Punto[maxY][maxX];
		for (int i = 0; i < maxY; i++)
			for (int j = 0; j < maxX; j++)
				copy[i][j] = new Punto(puntos[i][j]);
		return copy;
	}

	public static String printPuntos(Punto[][] puntos, int currY, int currX) {
		return printPuntos(puntos, currY, currX, true);
	}

	public static String printPuntos(Punto[][] puntos) {
		return printPuntos(puntos, 0, 0, false);
	}

	public static String printPuntos(Punto[][] puntos, int currY, int currX, boolean hasCurrPos) {
		StringBuffer s = new StringBuffer();

		int maxY = puntos.length - 1;
		int maxX = puntos[0].length - 1;

		for (int i = puntos.length - 1; i >= 0; i--) {
			for (int j = 0; j < puntos[i].length; j++)
				s.append(printNorthRoad(puntos, i, j, maxY, maxX));
			s.append("\n");

			for (int j = 0; j < puntos[i].length; j++) {
				s.append(printWestRoad(puntos, i, j, maxY, maxX));
				String contents = " ";
				boolean marcado = puntos[i][j].sueloMarcadoConTiza();
				boolean tieneTesoro = puntos[i][j].tieneTesoro();
				boolean atCurr = hasCurrPos && (i == currY && j == currX);
				contents += marcado ? "." : " ";
				contents += atCurr ? "x" : " ";
				contents += tieneTesoro ? "$" : " ";
				contents += " ";
				s.append(contents);
				s.append(printEastRoad(puntos, i, j, maxY, maxX));
			}
			s.append("\n");

			for (int j = 0; j < puntos[i].length; j++)
				s.append(printSouthRoad(puntos, i, j, maxY, maxX));
			if (i == 0) {
				s.append("\n");
				for (int j = 0; j < puntos[i].length; j++)
					s.append(printXcoord(j));
			}
		}
		s.append("\n");
		return s.toString();
	}

	static String printNorthRoad(Punto[][] puntos, int y, int x, int maxY, int maxX) {
		String result = "";
		boolean open = puntos[y][x].accessible(PuntoCardinal.NORTE);
		if (x == 0)
			result += "  +";
		if (open)
			result += "     ";
		else
			result += "-----";
		result += "+";
		return result;
	}

	static String printSouthRoad(Punto[][] puntos, int y, int x, int maxY, int maxX) {
		String result = "";
		boolean open = puntos[y][x].accessible(PuntoCardinal.SUR);
		if (y == 0) {
			if (x == 0)
				result += "  ";
			result += "+";
			if (open)
				result += "     ";
			else
				result += "-----";
			if (x == maxX)
				result += "+";
		}
		return result;
	}

	static String printXcoord(int x) {
		String result = "";
		if (x == 0)
			result += "  ";
		result += "   " + x + "  ";
		return result;
	}

	static String printWestRoad(Punto[][] puntos, int y, int x, int maxY, int maxX) {
		String result = "";
		boolean open = puntos[y][x].accessible(PuntoCardinal.OESTE);
		if (x == 0)
			result += y + " ";
		if (open)
			result += " ";
		else
			result += "|";
		return result;
	}

	static String printEastRoad(Punto[][] puntos, int y, int x, int maxY, int maxX) {
		String result = "";
		if (x == maxX) {
			boolean open = puntos[y][x].accessible(PuntoCardinal.ESTE);
			if (open)
				result += " ";
			else
				result += "|";
		}
		return result;
	}

	public static void isConsistent(Punto[][] puntos) {
		int maxY = puntos.length;
		if (maxY == 0) {
			System.out.println("zero y dimension");
			throw new RuntimeException();
		}
		int maxX = puntos[0].length;
		if (maxX == 0) {
			System.out.println("zero x dimension");
			throw new RuntimeException();
		}

		for (int i = 0; i < maxY; i++) {
			Punto[] xPuntos = puntos[i];
			if (xPuntos.length != maxX) {
				System.out.println("x dimension is inconsistent: ");
				throw new RuntimeException();
			}
		}

		for (int y = 0; y < maxY; y++)
			for (int x = 0; x < maxX; x++) {
				Punto p = puntos[y][x];

				if (y == 0)
					assert !p.accessible(PuntoCardinal.SUR);
				if (y == maxY - 1)
					assert !p.accessible(PuntoCardinal.NORTE);
				if (x == 0)
					assert !p.accessible(PuntoCardinal.OESTE);
				if (x == maxX - 1)
					assert !p.accessible(PuntoCardinal.ESTE);

				checkConsistent(y, x, y + 1, x, maxY, maxX, PuntoCardinal.NORTE, PuntoCardinal.SUR, puntos);
				checkConsistent(y, x, y - 1, x, maxY, maxX, PuntoCardinal.SUR, PuntoCardinal.NORTE, puntos);
				checkConsistent(y, x, y, x + 1, maxY, maxX, PuntoCardinal.ESTE, PuntoCardinal.OESTE, puntos);
				checkConsistent(y, x, y, x - 1, maxY, maxX, PuntoCardinal.OESTE, PuntoCardinal.ESTE, puntos);
			}
	}

	private static void checkConsistent(int origy, int origx, int y, int x, int maxY, int maxX, PuntoCardinal to,
			PuntoCardinal from, Punto[][] puntos) {
		if (y > 0 && y < maxY && x > 0 && x < maxX) {
			boolean accessibleTo = puntos[origy][origx].accessible(to);
			boolean accessibleFrom = puntos[y][x].accessible(from);
			if (accessibleTo != accessibleFrom) {
				System.out.println("Inconsistent block for nodes (" + origy + "," + origx + ") and " + "(" + y + "," + x
						+ ") and directions to=" + to + " (" + accessibleTo + ") and back=" + from + " ("
						+ accessibleFrom + ")");
				throw new RuntimeException();
			}
		}
	}
}
