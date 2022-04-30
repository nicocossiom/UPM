// Implementacion de Banco usando paso por mensajes en Java (JCSP)
// Autores: Nicolas Cossio Miravalles (190882) y Telmo Viudez Escobar (190084)
package cc.banco;

import org.jcsp.lang.Alternative;
import org.jcsp.lang.AltingChannelInput;
import org.jcsp.lang.Any2OneChannel;
import org.jcsp.lang.CSProcess;
import org.jcsp.lang.Channel;
import org.jcsp.lang.Guard;
import org.jcsp.lang.One2OneChannel;
import org.jcsp.lang.ProcessManager;

// Estructuras
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;

public class BancoCSP implements Banco, CSProcess {

	// canales: uno por operacion
	// seran peticiones aplazadas
	private Any2OneChannel chIngresar;
	private Any2OneChannel chDisponible;
	private Any2OneChannel chTransferir;
	private Any2OneChannel chAlertar;

	Map<String, Integer> bc;

	// clases para peticiones
	// regalamos una como ejemplo
	public class TransferirReq {
		// atributos (pueden ser publicos)
		String from;
		String to;
		int value;
		One2OneChannel resp;

		// constructor
		public TransferirReq(String from, String to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
			this.resp = Channel.one2one();
		}
	}

	public class AlertarReq {
		// atributos (pueden ser publicos)
		String acc;
		int threshold;
		One2OneChannel resp;

		public AlertarReq(String acc, int threshold) {
			this.acc = acc;
			this.threshold = threshold;
			this.resp = Channel.one2one();
		}
	}

	public class IngresarReq {
		// atributos (pueden ser publicos)
		String acc;
		int amount;
		// No requiere canal de respuesta

		public IngresarReq(String acc, int amount) {
			this.acc = acc;
			this.amount = amount;
		}
	}

	public class DisponibleReq {
		// atributos (pueden ser publicos)
		String acc;
		One2OneChannel resp;

		public DisponibleReq(String acc) {
			this.acc = acc;
			this.resp = Channel.one2one();
		}
	}

	// constructor de BancoCSP
	public BancoCSP() {
		this.chIngresar = Channel.any2one();
		this.chAlertar = Channel.any2one();
		this.chDisponible = Channel.any2one();
		this.chTransferir = Channel.any2one();
		bc = new HashMap<String, Integer>();
		new ProcessManager(this).start();
	}

	// interfaz Banco
	/**
	 * Un cajero pide que se ingrese una determinado valor v a una cuenta c. Si la
	 * cuenta no existe, se crea.
	 * 
	 * @param c numero de cuenta
	 * @param v valor a ingresar
	 */
	public void ingresar(String c, int v) {
		// crear peticion
		IngresarReq nuevaPet = new IngresarReq(c, v);
		// enviar peticion
		chIngresar.out().write(nuevaPet);
	}

	/**
	 * Un ordenante pide que se transfiera un determinado valor v desde una cuenta o
	 * a otra cuenta d.
	 * 
	 * @param o numero de cuenta origen
	 * @param d numero de cuenta destino
	 * @param v valor a transferir
	 * @throws IllegalArgumentException si o y d son las mismas cuentas
	 *
	 */
	public void transferir(String o, String d, int v) {
		// comprobar PRE
		if (!o.equals(d)) {
			// crear peticion
			TransferirReq nuevaPet = new TransferirReq(o, d, v);
			chTransferir.out().write(nuevaPet);
			// esperar confirmacion
			nuevaPet.resp.in().read();
		} else {
			// Si se intenta transferir a la misma cuenta no cumple PRE
			throw new IllegalArgumentException("No se puede transferir a misma cuenta");
		}
	}

	/**
	 * Un consultor pide el saldo disponible de una cuenta c.
	 * 
	 * @param c numero de la cuenta
	 * @return saldo disponible en la cuenta id
	 * @throws IllegalArgumentException si la cuenta c no existe
	 */
	public int disponible(String c) {
		if (bc.get(c) == null) {
			throw new IllegalArgumentException("Cuenta " + c + "no existe");
		}
		// crear peticion
		DisponibleReq peticion = new DisponibleReq(c);
		// enviar peticion
		chDisponible.out().write(peticion);
		// recibo respuesta
		Integer saldo = (Integer) peticion.resp.in().read();

		// Si-->devuelvo saldo
		return (int) saldo;
	}

	/**
	 * Un avisador establece una alerta para la cuenta c. La operacion termina
	 * cuando el saldo de la cuenta c baja por debajo de m.
	 * 
	 * @param c numero de la cuenta
	 * @param m saldo minimo
	 * @throws IllegalArgumentException si la cuenta c no existe
	 */
	public void alertar(String c, int v) {
		if (bc.get(c) == null) {
			throw new IllegalArgumentException("Cuenta " + c + "no existe");
		}
		// Crear peticion
		AlertarReq nuevaPet = new AlertarReq(c, v);
		// enviar peticion
		chAlertar.out().write(nuevaPet);
		// tratar respuesta del servidor
		Integer resp = (Integer) nuevaPet.resp.in().read();

	}

	// Codigo del servidor
	public void run() {
		// nombres simbolicos para las entradas
		final int INGRESAR = 0;
		final int DISPONIBLE = 1;
		final int TRANSFERIR = 2;
		final int ALERTAR = 3;

		// construimos la estructura para recepcion alternativa
		final Guard[] guards = new AltingChannelInput[4];
		guards[INGRESAR] = chIngresar.in();
		guards[DISPONIBLE] = chDisponible.in();
		guards[TRANSFERIR] = chTransferir.in();
		guards[ALERTAR] = chAlertar.in();
		Alternative servicios = new Alternative(guards);

		// colecciones para petic aplazadas
		Map<String, Queue<TransferirReq>> transferMap = new HashMap<String, Queue<TransferirReq>>();
		Map<String, Queue<AlertarReq>> alertMap = new HashMap<String, Queue<AlertarReq>>();

		String aumenta; // cuenta que aumenta saldo en esta iteracion
		String disminuye;

		// Bucle principal del servicio
		while (true) {
			int servicio = servicios.fairSelect();
			aumenta = null;
			disminuye = null;
			switch (servicio) {
			case INGRESAR: {
				IngresarReq recibida = (IngresarReq) chIngresar.in().read();
				String ncuenta = recibida.acc;
				Integer cant = recibida.amount;
				aumenta = ncuenta;
				// Realizar ingreso
				if (bc.get(ncuenta) == null) {
					// Cuenta no existe
					bc.put(ncuenta, cant);
					if (transferMap.get(ncuenta) == null) {
						transferMap.put(ncuenta, new LinkedList<TransferirReq>());
					}
					if (alertMap.get(ncuenta) == null) {
						alertMap.put(ncuenta, new LinkedList<AlertarReq>());
					}
				} else {
					// Cuenta existe
					int saldo = bc.get(ncuenta);
					saldo += cant;
					bc.put(ncuenta, saldo);
				}
				break;
			}
			case DISPONIBLE: {
				// recibir peticion
				DisponibleReq recibida = (DisponibleReq) chDisponible.in().read();
				// accedo a saldo, si es null no hay cuenta, se trata en disponible()
				Integer saldo = bc.get(recibida.acc);
				// envio respuesta
				recibida.resp.out().write(saldo);
				break;
			}
			case TRANSFERIR: {
				// recibir peticion
				TransferirReq recibida = (TransferirReq) chTransferir.in().read();
				// encolar peticion
				aumenta = recibida.to;
				disminuye = recibida.from;
				Queue<TransferirReq> colaOrigen = transferMap.get(disminuye);
				// Si no se ha creado todavia la cola para las transferencias
				if (colaOrigen == null) {
					colaOrigen = new LinkedList<TransferirReq>();
					transferMap.put(disminuye, colaOrigen);
				}
				// Comprobar CPRE
				if (transferMap.get(disminuye).isEmpty() && bc.get(disminuye) != null && bc.get(aumenta) != null && bc.get(disminuye) >= recibida.value) {
					// Se cumple la CPRE, ejecutar transferencia
					Integer saldo = bc.get(disminuye);
					Integer saldoDest = bc.get(aumenta);
					saldo -= recibida.value;
					saldoDest += recibida.value;
					bc.put(disminuye, saldo);
					bc.put(aumenta, saldoDest);
					// Notificar
					recibida.resp.out().write(0);
					desbloqAlertas(recibida.from, alertMap);
					desbloqTrans(recibida.from, transferMap, alertMap);
				} else {
					// no se cumple CPRE, encolar
					colaOrigen.add(recibida);
				}

				break;
			}
			case ALERTAR: {
				// recibir peticion
				AlertarReq recibida = (AlertarReq) chAlertar.in().read();
				// encolar peticion si la alerta no es immediatamente valida
				if(bc.get(recibida.acc) < recibida.threshold) {
					recibida.resp.out().write(recibida.threshold);
				} else {
					alertMap.get(recibida.acc).add(recibida);
				}
				break;
			}
			}// END SWITCH
				// Comprobar que haya transferencias que desbloquear
			// Posible transferencia - desbloquear
			desbloqTrans(aumenta, transferMap, alertMap);
		}
	} // END BUCLE SERVICIO

	private void desbloqTrans(String aumenta, Map<String, Queue<TransferirReq>> transferMap,
			Map<String, Queue<AlertarReq>> alertMap) {
		if (aumenta != null && transferMap.get(aumenta) != null) {
			Integer saldo = bc.get(aumenta);
			boolean stop = false;
			if (saldo != null) {
				// Comprobar que haya transferencias que desbloquear
				Queue<TransferirReq> thisQueue = transferMap.get(aumenta);
				while (!thisQueue.isEmpty() && !stop) {
					stop = true;
					TransferirReq primeraTransf = thisQueue.peek();
					// Existe el destino?
					Integer saldoDest = bc.get(primeraTransf.to);
					if (saldoDest != null) {
						// Hay suficiente saldo?
						if (primeraTransf.value <= saldo) {
							// Se cumplen todas las condiciones, realizar transferencia
							saldo -= primeraTransf.value;
							saldoDest += primeraTransf.value;
							bc.put(primeraTransf.from, saldo);
							bc.put(primeraTransf.to, saldoDest);
							// Eliminar transferencia de la cola y avisar
							primeraTransf.resp.out().write(0);
							thisQueue.poll();
							stop = false;
							desbloqTrans(primeraTransf.to, transferMap, alertMap);
							desbloqAlertas(primeraTransf.from, alertMap);
						}
					}
				}
			}
		}
	}

	private void desbloqAlertas(String disminuye, Map<String, Queue<AlertarReq>> alertMap) {
		if (disminuye != null && alertMap.get(disminuye) != null) {
			Queue<AlertarReq> lista = alertMap.get(disminuye);
			for (int i = 0; i < lista.size(); i++) {
				AlertarReq al = lista.peek();
				Integer saldoAl = bc.get(disminuye);
				if (saldoAl < al.threshold) {
					// Notificar la alerta
					al.resp.out().write(al.threshold);
					// Se elimina la alerta de la cola
					lista.poll();
				} else {
					// No se puede desbloquear, reencolar la primera alerta
					lista.poll();
					lista.add(al);
				}
			}
		}
	}

}
