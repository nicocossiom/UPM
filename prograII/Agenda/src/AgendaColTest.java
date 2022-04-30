/**
 * Prueba de AgendaCol<br>
 * @since 12/03/2018
 * @version 1.0
 * @author JMB
 */
public class AgendaColTest
{
//  OPERACIONES PARTICULARES  ---------------------------------------

//  DECLARACIONES DE CONSTANTES DE PRUEBAS  -------------------------
  
  static Agenda agenda1;
  
  static Contacto prueba1_1, prueba1_2, prueba1_3;
  static Contacto prueba2_1, prueba2_2, prueba2_3;
  static Contacto prueba3_1, prueba3_2, prueba3_3;
  static Contacto prueba4_1, prueba4_2, prueba4_3;
  
  static Contacto c11;
  static Contacto c12 = new ContactoTupla("Elinela",234567);
  static Contacto c21;
  static Contacto c22 = new ContactoTupla("Pablo",456789);
  static Contacto c31;
  static Contacto c32 = new ContactoTupla("Ida",654321);
  static Contacto c41;
  static Contacto c51;
  static Contacto c61 = new ContactoTupla("Laura",654000);
  static Contacto c71 = new ContactoTupla("Karla",654111);
  
  public static void resetearContactos ()
  {
    c11 = new ContactoTupla("Elinela",123456);
    c21 = new ContactoTupla("Pablo",345678);
    c31 = new ContactoTupla("Ida",567890);
    c41 = new ContactoTupla("Daniel",987654);
    c51 = new ContactoTupla("Sharif",983210);
  }  
  public static void resetear ()
  {
    agenda1 = new AgendaCol(10);
    resetearContactos();
    agenda1.poner(c11);
    agenda1.poner(c21);
    agenda1.poner(c31);
    agenda1.poner(c41);
    agenda1.poner(c51);
  }
  static void mostrar ()
  {
    System.out.println("agenda1 = \n" + agenda1);
  }

//  DECLARACIONES DE PRUEBAS  ---------------------------------------
  
  public static boolean prueba1_buscarNombre ()
  {
    resetear();
    prueba1_1 = agenda1.buscarNombre("Elinela");
    prueba1_2 = agenda1.buscarNombre("Sharif");
    prueba1_3 = agenda1.buscarNombre("Ida");
    boolean resultado = (prueba1_1.equals(c11)) &&
                        (prueba1_2.equals(c51)) &&
                        (prueba1_3.equals(c31));
    return resultado;
  }
  public static boolean prueba2_buscarNumero ()
  {
    resetear();
    prueba2_1 = agenda1.buscarNumero(123456);
    prueba2_2 = agenda1.buscarNumero(983210);
    prueba2_3 = agenda1.buscarNumero(567890);
    boolean resultado = (prueba2_1.equals(c11)) &&
                        (prueba2_2.equals(c51)) &&
                        (prueba2_3.equals(c31));
    return resultado;
  }
  public static boolean prueba3_poner ()
  {
    resetear();
    agenda1.poner(c61);
    agenda1.poner(c71);
    agenda1.poner(c12);
    prueba3_1 = agenda1.buscarNombre("Laura");
    prueba3_2 = agenda1.buscarNombre("Karla");
    prueba3_3 = agenda1.buscarNumero(234567);
    boolean resultado = (prueba3_1.equals(c61)) &&
                        (prueba3_2.equals(c71)) &&
                        (prueba3_3.equals(c12));
    if (!resultado) mostrar();  // En caso de fallo
    return resultado;
  }
  public static boolean prueba4_quitar ()
  {
    resetear();
    // Se quitan Elinela, Daniel y Pablo
    agenda1.quitar(c11);  // Elinela por Sharif
    agenda1.quitar(c41);  // Daniel
    agenda1.quitar(c21);  // Pablo por Ida
    // Quedan Sharif e Ida
    prueba4_1 = agenda1.buscarNombre("Sharif");
    prueba4_2 = agenda1.buscarNombre("Ida");
    prueba4_3 = agenda1.buscarNombre("Daniel");
    boolean resultado = (prueba4_1.equals(c51)) &&
                        (prueba4_2.equals(c31)) 
                        /*&&
                        (prueba4_3 == null)*/;
    if (!resultado) mostrar();  // En caso de fallo
    return resultado;
  }
  
  public static boolean prueba5_cambiarTelefono () {
	  resetear();
	  Contacto x21 = new ContactoTupla("Pablo",345678);
	  Contacto x31 = new ContactoTupla("Ida",567890);
	  agenda1.cambiarTelefono(x21);
	  agenda1.cambiarTelefono(x31);
	  boolean prueba5 = (agenda1.buscarNombre("Pablo").getTelefono() == x21.getTelefono()) &&
			  			(agenda1.buscarNombre("Ida").getTelefono() == x31.getTelefono());
	  return prueba5;
  }
  
  public static boolean prueba6_cuantosConPrefijo () {
	  resetear();
		int prueba6_1 = agenda1.cuantosConPrefijo(12);
		int prueba6_2 = agenda1.cuantosConPrefijo(98);
		int prueba6_3 = agenda1.cuantosConPrefijo(37);
		boolean resultado = (prueba6_1 == 1 && prueba6_2 == 2 && prueba6_3 == 0);
	    return resultado;
  }
  
//  PROGRAMA PRINCIPAL  ---------------------------------------------
  
  public static void main(String[] args)
  {
    resetear();
    mostrar();
    System.out.println("prueba1_buscarNombre: " +
                       prueba1_buscarNombre());
    System.out.println("prueba2_buscarNumero: " +
                       prueba2_buscarNumero());
    System.out.println("prueba3_poner: " + prueba3_poner());
    System.out.println("prueba4_quitar: " + prueba4_quitar());
    System.out.println("prueba5_cambiarTelefono: " + prueba5_cambiarTelefono());
    System.out.println("prueba6_cuantosConPrefijo: " + prueba6_cuantosConPrefijo());
  }
}