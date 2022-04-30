package figura;
/**
 * Implementaci�n del TAD Punto<br>
 * Representa un punto de una ret�cula entera<br>
 * {@code Punto = (int x, int y)}<br>
 * @since 16/4/2018
 * @version 1.0
 * @author JGF y JMB
 */
public class Punto implements IPunto
{
  private int x;
  private int y; 

  public Punto (int x1, int y1) 
  {
    x = x1;
    y = y1;
  }
  public String toString ()
  {  
    return new String("(" + x +  "," + y + ")"); 
  } 
  public int getX ()
  {
    return x;
  }  
  public int getY ()
  {
    return y;
  }    
  public boolean equals (Object pp)
  {
    IPunto p = (IPunto) pp;
    return (x == p.getX()) && (y == p.getY());
  }
  public int distA0 () 
  {
    return x + y; 
  }
  public void mover (int dx, int dy)
  {
    x = x + dx;
    y = y + dy;
  }
  public IPunto clon ()
  {
    return new Punto(x,y);
  }
}