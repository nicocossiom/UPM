package movilidad;
/**
 * Implementación de un Vehiculo <-- Moto<br>
 *{@code Moto = (boolean electrica)}<br>
 * @since 7/4/19
 * @version 1.
 * @author JMB
 */
public class Moto extends Vehiculo
{
// ATRIBUTOS PROPIOS  -----------------------------------------------
  
  private boolean electrica;

// OPERACIONES  -----------------------------------------------------

  public Moto (int elColor, int elNumero, boolean loEs)
  {
    super(elColor,elNumero);
    electrica = loEs;
  }  
  @Override
  public String toString()
  {
    return  "Moto: (" + super.toString() + "," + electrica + ")";
  }
  public boolean esElectrica ()
  {
    return electrica;
  }
}