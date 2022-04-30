package figura;
/**
 * Implementaci�n de una Figura<--Dot<br>
 * Un Dot es un elemento de la reticula ZxZ (un Punto)
 * @since 16/4/2018
 * @version 1.0
 * @author JGF y JMB
 */
public class Dot extends Figura
{
  public Dot (IPunto posicion) 
  {
    super(posicion);
  }
  public String toString ()
  {
    return "Dot(" + super.toString() + ")";
  }

}