package figura;
/**
 * Prueba de Circulo.
 * @since 6/4/2019
 * @version 1.0
 * @author JMB
 */
public class CirculoTest
{
  public static IPunto p1;
  public static IPunto p2;
  public static IPunto p3;
  public static IPunto p4;
  
  public static IFigura c1;
  public static IFigura c2;
  public static IFigura c3;
  public static IFigura c4;
  public static IFigura c5;
  
  public static void resetear ()
  {
    p1 = new Punto(10,10);
    p2 = new Punto(20,10);   
    p3 = new Punto(10,20);
    p4 = new Punto(20,20); 
    IPunto p1_bis = new Punto(10,10);
    
    c1 = new Circulo(p1,3);
    c2 = new Circulo(p1_bis,3);
    c3 = new Circulo(p3,2);
    c4 = new Circulo(p4,1);
    c5 = new Circulo(p4,4);
  }
  public static void mostrar () 
  {
    resetear();
    System.out.println("c1 = " + c1);
    System.out.println("c2 = " + c2); 
    System.out.println("c3 = " + c3);
    System.out.println("c4 = " + c4);
  }
  public static boolean pruebaEquals ()
  {
    resetear();
    Circulo cc1 = (Circulo) c1;
    Circulo cc2 = (Circulo) c2;
    Circulo cc3 = (Circulo) c3;
    Circulo cc4 = (Circulo) c4;
    Circulo cc5 = (Circulo) c5;
    // Sin casting, llama al "equals" de la Figura
    return cc1.equals(cc1) && cc1.equals(cc2) &&
           !cc3.equals(cc4) && !cc4.equals(cc5);
  }
  public static boolean pruebaGetPosicion ()
  {
    resetear();
    return c1.getPosicion().equals(p1) && c2.getPosicion().equals(p1) &&
           c3.getPosicion().equals(p3) && c4.getPosicion().equals(p4);
  }
  public static boolean pruebaGetRadio ()
  {
    resetear();
    Circulo cc1 = (Circulo) c1;
    Circulo cc2 = (Circulo) c2;
    Circulo cc3 = (Circulo) c3;
    Circulo cc4 = (Circulo) c4;
    return (cc1.getRadio() == 3) && (cc2.getRadio() == 3) &&
           (cc3.getRadio() == 2) && (cc4.getRadio() == 1);
  }
  public static boolean pruebaDistA0 ()
  {
    resetear();
    return (c1.distA0()== 20) && (c2.distA0()== 20) &&
           (c3.distA0()== 30) && (c4.distA0()== 40);
  }
  public static boolean pruebaMover ()
  {
    resetear();
    c1.mover(5,5);
    c3.mover(-5,-5);
    IPunto p11 = new Punto(15,15);
    IPunto p33 = new Punto(5,15); 
    return c1.getPosicion().equals(p11) && c3.getPosicion().equals(p33);
  }
  public static boolean pruebaArea ()
  {
    resetear();
    Circulo cc1 = (Circulo) c1;
    Circulo cc2 = (Circulo) c2;
    return (cc1.area() == cc2.area()) && (cc1.area() == (int)(Math.PI*3*3));
  }

  static boolean pruebaPerimetro ()
  {
    resetear();
    Circulo cc1 = (Circulo) c1;
    Circulo cc2 = (Circulo) c2;
    return (cc1.perimetro() == cc2.perimetro()) &&
           (cc1.perimetro() == (int)(2*Math.PI*3));
  }
  
  public static void main (String[] args) 
  {
    mostrar();
    System.out.println("  pruebaEquals() = " + pruebaEquals());
    System.out.println("  pruebaGetPosición() = " + pruebaGetPosicion());
    System.out.println("  pruebaGetRadio() = " + pruebaGetRadio());
    System.out.println("  pruebaDistA0() = " + pruebaDistA0());
    System.out.println("  pruebaMover() = " + pruebaMover());
    System.out.println("  pruebaÁrea() = " + pruebaArea());
    System.out.println("  pruebaPerimetro() = " + pruebaPerimetro());
  }
  
}