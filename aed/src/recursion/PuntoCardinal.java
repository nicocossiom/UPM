package recursion;

public enum PuntoCardinal {
	NORTE, SUR, ESTE, OESTE;

	public static PuntoCardinal opuesto(PuntoCardinal pc) {
		switch (pc) {
		case NORTE:
			return SUR;
		case SUR:
			return NORTE;
		case ESTE:
			return OESTE;
		case OESTE:
			return ESTE;
		default:
			return SUR;
		}
	}

}
