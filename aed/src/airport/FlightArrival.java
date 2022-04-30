package airport;

import es.upm.aedlib.Pair;

public class FlightArrival extends Pair<String, Long> {
	public FlightArrival(String flight, long time) {
		super(flight, time);
	}

	public String flight() {
		return getLeft();
	}

	public long arrivalTime() {
		return getRight();
	}
}
