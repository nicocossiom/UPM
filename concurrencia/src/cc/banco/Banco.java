package cc.banco;
import es.upm.aedlib.fifo.FIFO;
import es.upm.aedlib.fifo.FIFOArray;
import es.upm.babel.cclib.Monitor;

public interface Banco {
  /**
   * Un cajero pide que se ingrese una determinado valor v a una
   * cuenta c. Si la cuenta no existe, se crea.
   * @param c número de cuenta
   * @param v valor a ingresar
   */
  void ingresar(String c, int v);

  /**
   * Un ordenante pide que se transfiera un determinado valor v desde
   * una cuenta origen a otra cuenta destino.
   * @param o número de cuenta origen
   * @param d número de cuenta destino
   * @param v valor a transferir
   * @throws IllegalArgumentException si o y d son las mismas cuentas
   *
   */
  void transferir(String o, String d, int v);

  /**
   * Un consultor pide el saldo disponible de una cuenta c.
   * @param c número de la cuenta
   * @return saldo disponible en la cuenta id
   * @throws IllegalArgumentException si la cuenta c no existe
   */
  int disponible(String c);

  /**
   * Un avisador establece una alerta para la cuenta c. La operación
   * termina cuando el saldo de la cuenta c baja por debajo de m.
   * @param c número de la cuenta
   * @param m saldo mínimo
   * @throws IllegalArgumentException si la cuenta c no existe
   */
  void alertar(String c, int m);
}
