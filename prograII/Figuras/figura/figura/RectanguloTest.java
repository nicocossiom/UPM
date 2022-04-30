package figura;
/**
 * Prueba de Rectangulo.
 * @since 6/4/2019
 * @version 1.0
 * @author JMB
 */
public class RectanguloTest
{
  public static IPunto p1;
  public static IPunto p2;
  public static IPunto p3;
  public static IPunto p4;
  
  public static IFigura r1;
  public static IFigura r2;
  public static IFigura r3;
  public static IFigura r4;
  public static IFigura r5;
  
  public static void resetear ()
  {
    p1 = new Punto(10,10);
    p2 = new Punto(20,10);   
    p3 = new Punto(10,20);
    p4 = new Punto(20,20); 
    IPunto p1_bis = new Punto(10,10);
    
    r1 = new Rectangulo(p1,2,2);
    r2 = new Rectangulo(p1_bis,2,2);
    r3 = new Rectangulo(p3,6,2);
    r4 = new Rectangulo(p4,4,4);
    r5 = new Rectangulo(p4,2,6);
  }
  public static void mostrar () 
  {
    resetear();
    System.out.println("r1 = " + r1);
    System.out.println("r2 = " + r2); 
    System.out.println("r3 = " + r3);
    System.out.println("r4 = " + r4);
  }
  public static boolean pruebaEquals ()
  {
    resetear();
    Rectangulo rr1 = (Rectangulo) r1;
    Rectangulo rr2 = (Rectangulo) r2;
    Rectangulo rr3 = (Rectangulo) r3;
    Rectangulo rr4 = (Rectangulo) r4;
    Rectangulo rr5 = (Rectangulo) r5;
    // Sin casting, llama al "equals" de la Figura
    return rr1.equals(rr1) && rr1.equals(rr2) &&
           !rr3.equals(rr4) && !rr4.equals(rr5);
  }
  public static boolean pruebaGetPosicion ()
  {
    resetear();
    return r1.getPosicion().equals(p1) && r2.getPosicion().equals(p1) &&
           r3.getPosicion().equals(p3) && r4.getPosicion().equals(p4);
  }
  public static boolean pruebaGetAnchura ()
  {
    resetear();
    Rectangulo rr1 = (Rectangulo) r1;
    Rectangulo rr2 = (Rectangulo) r2;
    Rectangulo rr3 = (Rectangulo) r3;
    Rectangulo rr4 = (Rectangulo) r4;
    return (rr1.getAnchura() == 2) && (rr2.getAnchura() == 2) &&
           (rr3.getAnchura() == 6) && (rr4.getAnchura() == 4);
  }
  public static boolean pruebaGetAltura ()
  {
    resetear();
    Rectangulo rr1 = (Rectangulo) r1;
    Rectangulo rr2 = (Rectangulo) r2;
    Rectangulo rr3 = (Rectangulo) r3;
    Rectangulo rr4 = (Rectangulo) r4;
    return (rr1.getAltura() == 2) && (rr2.getAltura() == 2) &&
           (rr3.getAltura() == 2) && (rr4.getAltura() == 4);
  }
  public static boolean pruebaDistA0 ()
  {
    resetear();
    return (r1.distA0()== 20) && (r2.distA0()== 20) &&
           (r3.distA0()== 30) && (r4.distA0()== 40);
  }
  public static boolean pruebaMover ()
  {
    resetear();
    r1.mover(5,5);
    r3.mover(-5,-5);
    IPunto p11 = new Punto(15,15);
    IPunto p33 = new Punto(5,15); 
    return r1.getPosicion().equals(p11) && r3.getPosicion().equals(p33);
  }
  public static boolean pruebaArea ()
  {
    resetear();
    Rectangulo rr1 = (Rectangulo) r1;
    Rectangulo rr2 = (Rectangulo) r2;
    Rectangulo rr3 = (Rectangulo) r3;
    return (rr1.area() == rr2.area()) &&
           (rr1.area() == 4) &&
           (rr3.area() == 12);
  }

  static boolean pruebaPerimetro ()
  {
    resetear();
    Rectangulo rr1 = (Rectangulo) r1;
    Rectangulo rr2 = (Rectangulo) r2;
    Rectangulo rr3 = (Rectangulo) r3;
    return (rr1.perimetro() == rr2.perimetro()) &&
           (rr1.perimetro() == 8) &&
           (rr3.perimetro() == 16);
  }
  
  public static void main (String[] args) 
  {
    mostrar();
    System.out.println("  pruebaEquals() = " + pruebaEquals());
    System.out.println("  pruebaGetPosici�n() = " + pruebaGetPosicion());
    System.out.println("  pruebaGetAltura() = " + pruebaGetAltura());
    System.out.println("  pruebaGetAnchura() = " + pruebaGetAnchura());
    System.out.println("  pruebaDistA0() = " + pruebaDistA0());
    System.out.println("  pruebaMover() = " + pruebaMover());
    System.out.println("  prueba�rea() = " + pruebaArea());
    System.out.println("  pruebaPerimetro() = " + pruebaPerimetro());
  }
  
}
