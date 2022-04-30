package bancofiel;

import es.upm.aedlib.indexedlist.IndexedList;

/**
 * This interface provides methods for customer access to bank accounts, e.g.,
 * creating a new account (crearCuenta), depositing money (ingresarDinero). An
 * account is identified by a <em>unique</em> bank identifier, returned by the
 * method crearCuenta. Note that there should never be two bank accounts with
 * the same id; this property must be guaranteed by implementations of the
 * interface methods.
 */

public interface ClienteBanco {

	/**
	 * Creates a new bank account associated with the customer identified by dni,
	 * with a starting balance (saldo) equal to saldoInicial.
	 * 
	 * @return the <em>unique</em> identifier of the bank account.
	 */
	public String crearCuenta(String dni, int saldoIncial);

	/**
	 * Deletes the bank account identified by id. <strong>Note that it is an error
	 * deleting a bank account with a balance (saldo) different from 0.</strong>
	 * 
	 * @throws CuentaNoExisteExc if there is no bank account with identifier id.
	 * @throws CuentaNoVaciaExc  if the balance of the bank account is not 0.
	 */
	public void borrarCuenta(String id) throws CuentaNoExisteExc, CuentaNoVaciaExc;

	/**
	 * Increases the balance (saldo) of the bank account identified by id with the
	 * quantity cantidad.
	 * 
	 * @return the new balance of the account.
	 * @throws CuentaNoExisteExc if there is no bank account with identifier id.
	 */
	public int ingresarDinero(String id, int cantidad) throws CuentaNoExisteExc;

	/**
	 * Decreases the balance (saldo) of the bank account identified by id with the
	 * quantity cantidad.
	 * 
	 * @return the new balance of the account.
	 * @throws CuentaNoExisteExc    if there is no bank account with identifier id.
	 * @throws InsuficienteSaldoExc if the balance of the account is less than
	 *                              cantidad when the method is invoked.
	 */
	public int retirarDinero(String id, int cantidad) throws CuentaNoExisteExc, InsuficienteSaldoExc;

	/**
	 * Returns the balance (saldo) of the bank account identified by id.
	 * 
	 * @return the balance of the account.
	 * @throws CuentaNoExisteExc if there is no bank account with identifier id.
	 */
	public int consultarSaldo(String id) throws CuentaNoExisteExc;

	/**
	 * Transfers cantidad funds from the bank account identified by idFrom to the
	 * bank account identified by idTo. <strong>Note that idFrom and idTo may be the
	 * same account.</strong>
	 * 
	 * @throws CuentaNoExisteExc    if there is no bank account with identifier
	 *                              idFrom, or no bank account with identifier idTo.
	 * @throws InsuficienteSaldoExc if the balance of the bank account idFrom is
	 *                              less than cantidad.
	 */
	public void hacerTransferencia(String idFrom, String idTo, int cantidad)
			throws CuentaNoExisteExc, InsuficienteSaldoExc;

	/**
	 * Returns a <em>new</em> indexed list containing the identifiers (ids) for all
	 * accounts owned by the customer with DNI dni.
	 * 
	 * @return a list with all account ids for the customer with DNI dni.
	 */
	public IndexedList<String> getIdCuentas(String dni);

	/**
	 * Returns the sum of the balances for all accounts owned by the customer with
	 * DNI dni.
	 * 
	 * @return the sum of the balances (saldos) for all accounts owned by the
	 *         customer with DNI dni.
	 */
	public int getSaldoCuentas(String dni);
}
