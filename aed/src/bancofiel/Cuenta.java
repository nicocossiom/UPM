package bancofiel;

/**
 * Implements a class storing bank account information. A bank account (cuenta)
 * consists of a <em>unique</em> identifier, a DNI identifying the customer, and
 * a bank balance (saldo).
 */
public class Cuenta {
	private static int contador = 0;
	final private String id;
	final private String DNI;
	private int saldo;

	/**
	 * Creates a new bank account, with a <em>unique</em> bank account identifier.
	 */
	public Cuenta(String DNI, int saldo) {
		this.id = DNI + "/" + String.valueOf(contador++);
		this.DNI = DNI;
		this.saldo = saldo;
	}

	/**
	 * Returns the account identifier.
	 * 
	 * @return the account identifier.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the customer DNI .
	 * 
	 * @return the customer DNI.
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * Returns the account balance (saldo).
	 * 
	 * @return the account balance (saldo).
	 */
	public int getSaldo() {
		return saldo;
	}

	/**
	 * Increases the balance (saldo) of the bank account with cantidad, and returns
	 * the new balance.
	 * 
	 * @return the new balance.
	 * @throws IllegalArgumentException if cantidad is less than 0.
	 */
	public int ingresar(int cantidad) {
		if (cantidad < 0)
			throw new IllegalArgumentException();
		saldo += cantidad;
		return saldo;
	}

	/**
	 * Decreases the balance (saldo) of the bank account with cantidad, and returns
	 * the new balance.
	 * 
	 * @return the new balance.
	 * @throws InsuficienteSaldoExc     if the balance is less than cantidad.
	 * @throws IllegalArgumentException if cantidad is less than 0.
	 */
	public int retirar(int cantidad) throws InsuficienteSaldoExc {
		if (cantidad < 0)
			throw new IllegalArgumentException();
		if (saldo < cantidad)
			throw new InsuficienteSaldoExc();
		saldo -= cantidad;
		return saldo;
	}

	public String toString() {
		return "Cuenta(\"" + getId() + "\",\"" + getDNI() + "\"," + getSaldo() + ")";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Cuenta) {
			Cuenta otraCuenta = (Cuenta) obj;
			return getId().equals(otraCuenta.getId());
		} else
			return false;
	}

	public int hashCode() {
		return getId().hashCode();
	}
}
