package figura;
/**
 * Prueba de Figura.
 * @since 16/4/2018
 * @version 1.0
 * @author JGF y JMB
 */
public class FiguraTest
{
  public static IPunto p1;
  public static IPunto p2;
  public static IPunto p3;
  public static IPunto p4;
  
  public static IFigura f1;
  public static IFigura f2;
  public static IFigura f3;
  public static IFigura f4;
  
  public static void resetear ()
  {
    p1 = new Punto(10,10);
    p2 = new Punto(20,10);   
    p3 = new Punto(10,20);
    p4 = new Punto(20,20); 
    IPunto p1_bis = new Punto(10,10);
    
    f1 = new Figura(p1);
    f2 = new Figura(p1_bis);
    f3 = new Figura(p3);
    f4 = new Figura(p4);
  }
  public static void mostrar () 
  {
    resetear();
    System.out.println("f1 = " + f1);
    System.out.println("f2 = " + f2); 
    System.out.println("f3 = " + f3);
    System.out.println("f4 = " + f4);
  }
  public static boolean pruebaEquals ()
  {
    resetear();
    return f1.equals(f1) && f1.equals(f2) && !f3.equals(f4);
  }
  public static boolean pruebaGetPosicion ()
  {
    resetear();
    return f1.getPosicion().equals(p1) && f2.getPosicion().equals(p1) &&
           f3.getPosicion().equals(p3) && f4.getPosicion().equals(p4);
  }
  public static boolean pruebaDistA0 ()
  {
    resetear();
    return (f1.distA0()== 20) && (f2.distA0()== 20) &&
           (f3.distA0()== 30) && (f4.distA0()== 40);
  }
  public static boolean pruebaMover ()
  {
    resetear();
    f1.mover(5,5);
    f3.mover(-5,-5);
    IPunto p11 = new Punto(15,15);
    IPunto p33 = new Punto(5,15); 
    return f1.getPosicion().equals(p11) && f3.getPosicion().equals(p33);
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