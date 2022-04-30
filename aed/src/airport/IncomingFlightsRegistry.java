package airport;

import es.upm.aedlib.Entry;
import es.upm.aedlib.Pair;
import es.upm.aedlib.priorityqueue.*;
import es.upm.aedlib.map.*;
import es.upm.aedlib.positionlist.*;

/**
 * A registry which organizes information on airplane arrivals.
 */
public class IncomingFlightsRegistry {

	private Map<String, Entry<Long, FlightArrival>> entrymap;
	private PriorityQueue<Long, FlightArrival> priority;

	/**
	 * Constructs an class instance.
	 */
	public IncomingFlightsRegistry() {
		priority = new HeapPriorityQueue<Long, FlightArrival>();
		entrymap = new HashTableMap<String, Entry<Long, FlightArrival>>();
	}

	/**
	 * A flight is predicted to arrive at an arrival time (in seconds).
	 */
	public void arrivesAt(String flight, Long time) {
		FlightArrival newFlight = new FlightArrival(flight, time);
		if (entrymap.containsKey(flight)) {
			priority.remove(entrymap.get(flight));
		}
		entrymap.put(flight, priority.enqueue(time, newFlight));
	}

	/**
	 * A flight has been diverted, i.e., will not arrive at the airport.
	 */
	public void flightDiverted(String flight) {
		try {
			priority.remove(entrymap.remove(flight));
		} catch (es.upm.aedlib.InvalidKeyException e) {
			System.out.println("This flight is not registered to arrive at this airport");
		} catch (es.upm.aedlib.tree.EmptyTreeException a) {
			System.out.println("No flights with destination to this airport");
		} catch (es.upm.aedlib.priorityqueue.EmptyPriorityQueueException b) {
			System.out.println("No flights with destination to this airport");
		}
	}

	/**
	 * Returns the arrival time of the flight.
	 * 
	 * @return the arrival time for the flight, or null if the flight is not
	 *         predicted to arrive.
	 */
	public Long arrivalTime(String flight) {
		Long time;
		try {
			time = entrymap.get(flight).getValue().getRight();
		} catch (java.lang.NullPointerException e) {
			time = null;
		}
		return time;
	}

	/**
	 * Returns a list of "soon" arriving flights, i.e., if any is predicted to
	 * arrive at the airport within nowTime+180 then adds the predicted earliest
	 * arriving flight to the list to return, and removes it from the registry.
	 * Moreover, also adds to the returned list, in order of arrival time, any other
	 * flights arriving withinfirstArrivalTime+120; these flights are also removed
	 * from the queue of incoming flights.
	 * 
	 * @return a list of soon arriving flights.
	 */
	public PositionList<FlightArrival> arriving(Long nowTime) {
		PositionList<FlightArrival> llegando = new NodePositionList<FlightArrival>();
		try {
			Entry<Long, FlightArrival> first = priority.first();
			if (first.getKey() <= nowTime + 180) {
				removeadd(first.getValue().getLeft(), llegando);
				boolean stop = false;
				while (!stop) {
					Entry<Long, FlightArrival> entrada = priority.first();
					if (entrada.getKey() <= first.getKey() + 120) {
						removeadd(entrada.getValue().getLeft(), llegando);
					} else
						stop = true;
				}
			}
		} catch (EmptyPriorityQueueException e) {
		}
		return llegando;
	}

	private void removeadd(String flight, PositionList<FlightArrival> lista) {
		entrymap.remove(priority.first().getValue().flight());
		lista.addLast(priority.dequeue().getValue());
	}
}
