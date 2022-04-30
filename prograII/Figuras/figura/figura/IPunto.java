package figura;
/**
 * Especificación del TAD Punto<br>
 * Representa un punto de una retícula entera (primer cuadrante del plano)<br>
 * @since 16/4/2018
 * @version 1.0
 * @author JGF y JMB
 */
public interface IPunto
{
/**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto
 */
  public String toString ();
/**
 * POST: resultado es la abscisa del objeto
 */  
  public int getX ();
/**
 * POST: resultado es la ordenada del objeto
 */  
  public int getY ();
/**
 * POST: resultado es cierto si "pp" es identico al objeto y es
 *       falso e.o.c.
 */
  public boolean equals (Object pp);
/**
 * POST: resultado es el minimo numero de pasos de reticula que hay del
 *       origen al objeto.
 */
  public int distA0 ();
/**
 * POST: Traslada el objeto segun (dx,dy)
 */
  public void mover (int dx, int dy); 
/**
 * POST: Resultado es una copia del objeto
 */
  public IPunto clon ();
}