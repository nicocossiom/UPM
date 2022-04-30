package bancofiel;

import java.util.Comparator;

import bancofiel.TesterLab1.GetSaldoCuentas;
import es.upm.aedlib.indexedlist.IndexedList;
import es.upm.aedlib.indexedlist.ArrayIndexedList;

/**
 * Implements the code for the bank application. Implements the client and the
 * "gestor" interfaces.
 */
public class BancoFiel implements ClienteBanco, GestorBanco {

	// NOTAD. No se deberia cambiar esta declaracion.
	public IndexedList<Cuenta> cuentas;

	// NOTAD. No se deberia cambiar esta constructor.
	public BancoFiel() {
		this.cuentas = new ArrayIndexedList<Cuenta>();
	}

	@Override
	public IndexedList<Cuenta> getCuentasOrdenadas(Comparator<Cuenta> cmp) {
		IndexedList<Cuenta> resultado = new ArrayIndexedList<Cuenta>();
		boolean stop = false;
		for (int i = 0; i < cuentas.size(); i++) {
			for (int j = 0; j < resultado.size() && !stop; j++) {
				if (cmp.compare(cuentas.get(i), resultado.get(j)) < 0) {
					resultado.add(j, cuentas.get(i));
					stop = true;
				}
			}
			if (!stop) {
				resultado.add(resultado.size(), cuentas.get(i));
			}
			stop = false;
		}
		return resultado;
	}

	@Override
	public String crearCuenta(String dni, int saldoIncial) {
		Cuenta nuevacuenta = new Cuenta(dni, saldoIncial);
		String numcuenta = nuevacuenta.getId();
		boolean stop = false;
		for (int i = 0; i < cuentas.size() && !stop; i++) {
			if (numcuenta.compareTo(cuentas.get(i).getId()) < 0) {
				cuentas.add(i, nuevacuenta);
				stop = true;
			}
		}
		if (!stop) {
			cuentas.add(cuentas.size(), nuevacuenta);
		}
		return numcuenta;
	}

	// Searches cuentas to find an account given an id or dni, returns said account
	private int buscarCuenta(String id) {
		int left = 0;
		int right = cuentas.size() - 1;
		int result = -1;
		boolean stop = false;
		while (left <= right && !stop) {
			int middle = (left + right) / 2;
			int res1 = id.compareTo(cuentas.get(middle).getId());
			// Check if element at middle is the one we are looking for
			if (res1 == 0) {
				result = middle;
				stop = true;
			}
			// if id is smaller --> ignore right half
			else if (res1 < 0) {
				right = middle - 1;
			}
			// if id is bigger --> ignore left half
			else {
				left = middle + 1;
			}
		}
		return result;
	}

	@Override
	public void borrarCuenta(String id) throws CuentaNoExisteExc, CuentaNoVaciaExc {
		int cuenta = buscarCuenta(id);
		if (cuenta == -1) {
			throw new CuentaNoExisteExc();

		} else if (cuentas.get(cuenta).getSaldo() > 0) {
			throw new CuentaNoVaciaExc();
		} else {
			cuentas.removeElementAt((buscarCuenta(id)));
		}
	}

	@Override
	public int ingresarDinero(String id, int cantidad) throws CuentaNoExisteExc {
		if (buscarCuenta(id) == -1) {
			throw new CuentaNoExisteExc();
		}
		// ingresamos el dinero
		return cuentas.get((buscarCuenta(id))).ingresar(cantidad);
	}

	@Override
	public int retirarDinero(String id, int cantidad) throws CuentaNoExisteExc, InsuficienteSaldoExc {
		if (buscarCuenta(id) == -1) {
			throw new CuentaNoExisteExc();
		} else if (consultarSaldo(id) < cantidad) {
			throw new InsuficienteSaldoExc();
		} else {
			cuentas.get((buscarCuenta(id))).retirar(cantidad);// ingresamos el dinero
		}
		return consultarSaldo(id);
	}

	@Override
	public int consultarSaldo(String id) throws CuentaNoExisteExc {
		if (buscarCuenta(id) == -1) {
			throw new CuentaNoExisteExc();
		}
		int result = cuentas.get((buscarCuenta(id))).getSaldo();
		return result;
	}

	@Override
	public void hacerTransferencia(String idFrom, String idTo, int cantidad)
			throws CuentaNoExisteExc, InsuficienteSaldoExc {
		if (buscarCuenta(idTo) != -1) {
			retirarDinero(idFrom, cantidad);
			ingresarDinero(idTo, cantidad);
		} else
			throw new CuentaNoExisteExc();

	}

	private IndexedList<Cuenta> cuentasDNI(String dni) {
		IndexedList<Cuenta> resultado = new ArrayIndexedList<Cuenta>();
		boolean stop = false;
		for (int i = 0; i < cuentas.size() && !stop; i++) {
			if (dni.equals(cuentas.get(i).getDNI())) { // if we find the first element the rest must follow right behind
				for (int j = i; !stop; j++) {
					// We will only check if it's not an element we're looking for, if it isn't it
					// means we have found all and we can stop searching
					if (dni.equals(cuentas.get(j).getDNI()) == false) {
						stop = true;
					}
					// In case the last element of the array is also valid we will check for it
					else if (j == cuentas.size() - 1) {
						resultado.add(resultado.size(), cuentas.get(j));
						stop = true;
					}
					// We store each element that does not trigger stop
					else {
						resultado.add(resultado.size(), cuentas.get(j));
					}
				}
			}
		}
		return resultado;
	}

	@Override
	public IndexedList<String> getIdCuentas(String dni) {
		IndexedList<String> resultado = new ArrayIndexedList<String>();
		IndexedList<Cuenta> lista = cuentasDNI(dni);
		for (int i = 0; i < lista.size(); i++) {
			resultado.add(resultado.size(), lista.get(i).getId());
		}
		return resultado;
	}

	public int getSaldoCuentas(String dni) {
		int result = 0;
		IndexedList<Cuenta> lista = cuentasDNI(dni);
		for (int i = 0; i < lista.size(); i++) {
			result = result + lista.get(i).getSaldo();
		}

		return result;
	}

	// ----------------------------------------------------------------------
	// NOTAD. No se deberia cambiar este metodo.
	public String toString() {
		return "banco";
	}

}
