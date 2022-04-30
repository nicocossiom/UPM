package figura;
/**
 * Implementación de una Figura<--Circulo<br>
 * {@code Circulo = (int radio)}<br>
 * @since 16/4/2018 > 6/4/19
 * @version 1.1
 * @author JGF y JMB
 */
public class Circulo extends Figura
{
  private int radio;
  
  public Circulo (IPunto centro, int rad)
  {
    super(centro);
    radio = rad;
  }
  public String toString ()
  {
    return "Círculo(" + super.toString() + "," + radio + ")";
  }
  public int getRadio ()
  {
    return radio;
  }  
  public boolean equals (Object f) 
  {
    Circulo c = (Circulo) f;
    return super.equals(f) && (radio == c.radio);
  }
/**
 * POST: resultado es el area del objeto.
 */
  public int area ()
  {
    return (int)(Math.PI * radio * radio);
  }
/**
 * POST: resultado es el perimetro del objeto.
 */
  public int perimetro ()
  {
    return (int)(2 * Math.PI * radio);
  }

}