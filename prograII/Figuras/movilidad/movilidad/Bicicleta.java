package movilidad;
/**
 * Implementación de un Vehiculo <-- Bicicleta<br>
 * @since 7/4/19
 * @version 1.
 * @author JMB
 */
public class  Bicicleta extends Vehiculo
{
  public Bicicleta (int elColor, int elNumero)
  {
    super(elColor,elNumero);
  }
  @Override
  public String toString()
  {
    return  "Bicicleta: (" + super.toString() + ")";
  }
}