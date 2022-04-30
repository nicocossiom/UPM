package figura;
/**
 * Implementación del TAD Figura<br>
 * {@code Figura = (Punto posicion)}<br>
 * @since 16/4/2018 > 6/4/19
 * @version 1.1
 * @author JGF y JMB
 */
public class Figura implements IFigura
{
  private IPunto posicion;
  
  public Figura (IPunto pos) 
  {
    posicion = pos;
  }
  public String toString ()
  {
    return "Figura(" + posicion.toString() + ")";
  }
  public boolean equals (Object ff) 
  {
    IFigura f = (IFigura) ff;
    return posicion.equals(f.getPosicion());
  }
  public IPunto getPosicion ()
  {
    return posicion;
  }  
  public int distA0 ()
  {
    return posicion.distA0(); 
  }
  public void mover (int dx, int dy) 
  {
    posicion.mover(dx,dy);
  }

}
