package movilidad;
/**
 * Especificación del TAD Vehiculo<br>
 * Representa vehiculos automoviles<br>
 * @since 7/4/19
 * @version 1.
 * @author JMB
 */
public interface IVehiculo
{
/**
 * POST: Resultado es la cadena de caracteres con los atributos
 *       del objeto.
 */
  public String toString();
/**
 * POST: Resultado es el color del objeto.
 */
  public int getColor ();
/**
 * POST: Resultado es el numero de serie del objeto.
 */
  public int getNumeroSerie ();
/**
 * Modifica el color del objeto con "nuevoColor"
 */
  public void setColor (int nuevoColor);
/**
 * Modifica el numero de serie del objeto con "nuevoNumero"
 */
  public void setNumeroSerie (int nuevoNumero);
}