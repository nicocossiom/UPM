package figura;
/**
 * Especificación del TAD Figura<br>
 * Representa figuras planas en una retícula entera
 * (primer cuadrante del plano)<br>
 * @since 16/4/2018 > 6/4/19
 * @version 1.1
 * @author JGF y JMB
 */
public interface IFigura
{
/**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto
 */
  public String toString ();
/**
 * POST: resultado es cierto si "ff" es identico al objeto y es
 *       falso e.o.c.
 */
  public boolean equals (Object ff);
/**
 * POST: resultado es el punto de referencia del objeto
 */  
  public IPunto getPosicion ();
/**
 * POST: resultado es el numero de puntos que hay que recorrer desde el origen hata dicho punto, ie.:distA0(P(3,2))=3+2=5
 */
  public int distA0 ();
/**
 * POST: Traslada el objeto segun (dx,dy)
 */
  public void mover (int dx, int dy);

}
