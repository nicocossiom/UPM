package movilidad;
/**
 * Implementación de un Vehiculo <-- Coche<br>
 *{@code Coche = (int cilindrada)}<br>
 * @since 7/4/19
 * @version 1.
 * @author JMB
 */
public class Coche extends Vehiculo
{
// ATRIBUTOS PROPIOS  -----------------------------------------------
  
  private int cilindrada;

// OPERACIONES  -----------------------------------------------------

  public Coche (int elColor, int elNumero, int laCilindrada)
  {
    super(elColor,elNumero);
    cilindrada = laCilindrada;
  }  
  @Override
  public String toString()
  {
    return  "Coche: (" + super.toString() + "," + cilindrada + ")";
  }
  public int getCilindrada ()
  {
    return cilindrada;
  }
  public void setCilindrada (int nuevaCilindrada)
  {
    cilindrada = nuevaCilindrada;
  }
}