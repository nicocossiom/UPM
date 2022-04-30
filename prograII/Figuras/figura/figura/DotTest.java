package figura;
/**
 * Prueba de Dot.
 * @since 6/4/2019
 * @version 1.0
 * @author JMB
 */
public class DotTest
{
  public static IPunto p1;
  public static IPunto p2;
  public static IPunto p3;
  public static IPunto p4;
  
  public static IFigura d1;
  public static IFigura d2;
  public static IFigura d3;
  public static IFigura d4;
  
  public static void resetear ()
  {
    p1 = new Punto(10,10);
    p2 = new Punto(20,10);   
    p3 = new Punto(10,20);
    p4 = new Punto(20,20); 
    IPunto p1_bis = new Punto(10,10);
    
    d1 = new Dot(p1);
    d2 = new Dot(p1_bis);
    d3 = new Dot(p3);
    d4 = new Dot(p4);
  }
  public static void mostrar () 
  {
    resetear();
    System.out.println("d1 = " + d1);
    System.out.println("d2 = " + d2); 
    System.out.println("d3 = " + d3);
    System.out.println("d4 = " + d4);
  }
  public static boolean pruebaEquals ()
  {
    resetear();
    return d1.equals(d1) && d1.equals(d2) && !d3.equals(d4);
  }
  public static boolean pruebaGetPosicion ()
  {
    resetear();
    return d1.getPosicion().equals(p1) && d2.getPosicion().equals(p1) &&
           d3.getPosicion().equals(p3) && d4.getPosicion().equals(p4);
  }
  public static boolean pruebaDistA0 ()
  {
    resetear();
    return (d1.distA0()== 20) && (d2.distA0()== 20) &&
           (d3.distA0()== 30) && (d4.distA0()== 40);
  }
  public static boolean pruebaMover ()
  {
    resetear();
    d1.mover(5,5);
    d3.mover(-5,-5);
    IPunto p11 = new Punto(15,15);
    IPunto p33 = new Punto(5,15); 
    return d1.getPosicion().equals(p11) && d3.getPosicion().equals(p33);
  }
  public static void main (String[] args) 
  {
    mostrar();
    System.out.println("  pruebaEquals() = " + pruebaEquals());
    System.out.println("  pruebaGetPosicion() = " + pruebaGetPosicion());
    System.out.println("  pruebaDistA0() = " + pruebaDistA0());
    System.out.println("  pruebaMover() = " + pruebaMover());
  }
  
}