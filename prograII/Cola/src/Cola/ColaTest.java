package Cola;
/**
 * Prueba de la implementacion de Cola, Cola<br>
 * @since 10/05/2016 --> 24/4/18
 * @version 2.0
 * @author JMB y JGF
 */
public class ColaTest
{
  static ICola<Integer> cde0;
  static ICola<Integer> cde0erronea;
  static ICola<Integer> cde1;
  static ICola<Integer> cde2;
  static ICola<Integer> cde3;
  static ICola<Integer> cde5;
  
  public static void resetearColas ()
  {  
    try
    {
      cde0 = new Cola<Integer>(10);
      cde1 = new Cola<Integer>(10);
      cde2 = new Cola<Integer>(5);
      cde3 = new Cola<Integer>(5);
      cde5 = new Cola<Integer>(5);
      //cde0erronea = new Cola<Integer>(20); //Salta excepción
    }
    catch (MemoriaExcesiva e)
    {
      System.out.println(" Error en constructor de Cola");
      e.printStackTrace(); //Para saber en qué línea se produce el error.
    }
  }

  public static void cargarColas ()
  {
    resetearColas();
    
    cde1.encolar(1); 
    
    cde2.encolar(1); 
    cde2.encolar(3); 
    
    cde3.encolar(1); 
    cde3.encolar(3); 
    cde3.encolar(5); 
    
    cde5.encolar(1); 
    cde5.encolar(3); 
    cde5.encolar(5); 
    cde5.encolar(7);
    cde5.encolar(9);
  }

  public static void mostrar ()
  {
    System.out.println("cde0 -> " + cde0);
    System.out.println("cde1 -> " + cde1);
    System.out.println("cde2 -> " + cde2);
    System.out.println("cde3 -> " + cde3);
    System.out.println("cde5 -> " + cde5);
  }

  static boolean pruebaEstaVacia ()
  {
    resetearColas();
    cargarColas();
    return 
      cde0.estaVacia() == true &&
      cde2.estaVacia() == false &&
      cde3.estaVacia() == false &&
      cde5.estaVacia() == false ;
  }

  static void primeroEnColaVacia () 
  {
    resetearColas();
    try 
    {
      System.out.println("Primero: " + cde0.primero());
    }
    catch (ColaVacia e) 
    {
      System.out.println ("Error en primeroEnColaVacia() " +
                          "--> No hay primero");
    }
  }

  static void encolarEnColaLlena () 
  {
    resetearColas();
    cargarColas();
    try 
    {
      cde5.encolar(10);
      
    }
    catch (ArrayIndexOutOfBoundsException e) 
    {
      System.out.println ("Error en encolarEnColaLlena() " +
                          "--> ColaLlena " + cde5.size() + " elementos");
    }
  }

  static void pruebaEncolar ()
  {
    resetearColas();
    cargarColas();
    System.out.println("Encolando: 100 en cde0, 10 en cde1, " +
                       "20 en cde2 y 30 en cde3");
    try
    {   
      cde0.encolar(100);
      cde1.encolar(10);
      cde2.encolar(20);
      cde3.encolar(30);
      cde5.encolar(40); // ColaLlena
    }
    catch (ArrayIndexOutOfBoundsException e)
    {
      System.out.println ("Error en cde5.encolar() --> ColaLlena " +
                          cde5.size() + " elementos");
      e.printStackTrace();
    }
    finally
    {
      mostrar();
    }
  }

  static void pruebaDesencolar () throws ColaVacia
  {
    resetearColas();
    cargarColas();
    System.out.println("Desencolando: " +
                       "1 elemento en cde0, cde1, cde2 y cde3");
    System.out.println("Desencolando: 2 elementos en cde5");
    //cde0.desencolar(); // se queda como esta
    cde1.desencolar(); // se vacia
    cde2.desencolar(); // se queda con un elemento
    cde3.desencolar(); // se queda con dos elementos
    cde5.desencolar(); 
    cde5.desencolar(); // se queda con tres elementos
  }

  static void encolarDesencolar () 
  { 
    resetearColas();
    cargarColas();
    System.out.println(" Encolando en cde3  " + cde3);
    cde3.encolar(10);
    try 
    {
      System.out.println("encolar(10) ==> Primero: " + cde3.primero());
    }
    catch (ColaVacia e) 
    {
      System.out.println ("Error en encolarDesencolar() " +
                          "--> No hay primero");
    }
    cde3.encolar(30); 
    try 
    {
      System.out.println("encolar(30) ==> Primero: " + cde3.primero());
    }
    catch (ColaVacia e) 
    {
      System.out.println ("Error en encolarDesencolar() " +
                          "--> No hay primero");
    }
    try 
    {
      System.out.println(" Desencolando en cde3  " + cde3);
      cde3.desencolar();
      System.out.println("desencolar() ==> Primero: " + cde3.primero());
      cde3.desencolar();
      System.out.println("desencolar() ==> Primero: " + cde3.primero());
      cde3.desencolar();
      System.out.println("desencolar() ==> Primero: " + cde3.primero());
    }
    catch (ColaVacia e) 
    {
      System.out.println ("Error en encolarDesencolar() " +
                          "--> No hay primero");
      //e.printStackTrace();
    }
    System.out.println("cde3 -> " + cde3);
  }

//  PROGRAMA PRINCIPAL  ---------------------------------------------
  
  public static void main(String[] args) throws ColaVacia
  {
    resetearColas();
    cargarColas();
    mostrar();
System.out.println("  pruebaEstaVacia() = " + pruebaEstaVacia());
 System.out.println("  prueba_primeroEnColaVacia(): cde0  " );
 primeroEnColaVacia();
System.out.println("  prueba_encolarEnColaLlena(): cde5 ");
 encolarEnColaLlena();
System.out.println("  pruebaEncolar()  ");
pruebaEncolar();
mostrar();
System.out.println("  pruebaDesencolar()  ");
pruebaDesencolar();
mostrar();
System.out.println("  pruebaEncolarDesencolar()  ");
encolarDesencolar();
  }

}