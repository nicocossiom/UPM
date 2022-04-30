package bancofiel;

import java.util.Comparator;
import es.upm.aedlib.indexedlist.IndexedList;

/**
 * This interface provides methods for administrator ("gestor" ) access to bank
 * accounts, e.g., the method ordenarCuentas.
 */

public interface GestorBanco {

	/**
	 * Return a <em>new</em> <strong>ordered</strong> indexed list with the
	 * identifiers of all bank accounts of the bank. The order in which account
	 * identifiers occurs should be determined by the cmp (Cuenta) comparator.
	 * 
	 * @return Return a <em>new</em> <strong>ordered</strong> indexed list with the
	 *         identifiers of all bank accounts of the bank.
	 */
	public IndexedList<Cuenta> getCuentasOrdenadas(Comparator<Cuenta> cmp);
}
