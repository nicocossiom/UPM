package bancofiel;

import java.util.Comparator;

/**
 * Implements a compator for bank accounts according to the balance (saldo) of
 * the accounts.
 */
public class ComparadorSaldo implements Comparator<Cuenta> {
	public int compare(Cuenta cuenta1, Cuenta cuenta2) {
		return cuenta1.getSaldo() - cuenta2.getSaldo();
	}
}
