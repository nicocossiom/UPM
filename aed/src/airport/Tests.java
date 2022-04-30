package airport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import es.upm.aedlib.positionlist.*;

import es.upm.aedlib.Entry;
import es.upm.aedlib.Pair;
import es.upm.aedlib.priorityqueue.*;
import es.upm.aedlib.map.*;
import es.upm.aedlib.positionlist.*;

public class Tests {
	public static void main(String[] args) {
		IncomingFlightsRegistry registro = new IncomingFlightsRegistry();

		registro.arrivesAt("Vuelo1", (long) 2001);
		registro.arrivesAt("Vuelo2", (long) 2002);
		registro.arrivesAt("Vuelo3", (long) 2003);
		registro.arrivesAt("Vuelo4", (long) 2004);
		registro.arrivesAt("Vuelo5", (long) 2005);
		registro.arrivesAt("Vuelo6", (long) 2006);
		registro.arrivesAt("Vuelo7", (long) 2007);

		
	}
}
