/**
 * Prueba de AgendaTupla<br>
 * @since 27/02/2018
 * @version 1.0
 * @author JMB
 */
public class AgendaTuplaTest
{
//  OPERACIONES PARTICULARES  ---------------------------------------

//  DECLARACIONES DE CONSTANTES DE PRUEBAS  -------------------------
  
  static Agenda agenda1;
  
  static Contacto prueba1_1;
  static Contacto prueba1_2;
  static Contacto prueba1_3;
  static Contacto prueba2_1;
  static Contacto prueba2_2;
  static Contacto prueba2_3;
  static Contacto prueba3_1;
  static Contacto prueba3_2;
  static Contacto prueba3_3;
  static Contacto prueba4_1;
  static Contacto prueba4_2;
  static Contacto prueba4_3;
  
  public static void resetear ()
  {
    agenda1 = new AgendaTupla(10);
    ContactoTuplaTest.resetear();
    agenda1.poner(ContactoTuplaTest.c11);
    agenda1.poner(ContactoTuplaTest.c21);
    agenda1.poner(ContactoTuplaTest.c31);
    agenda1.poner(ContactoTuplaTest.c41);
    agenda1.poner(ContactoTuplaTest.c51);
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
    boolean resultado = (prueba1_1.equals(ContactoTuplaTest.c11)) &&
                        (prueba1_2.equals(ContactoTuplaTest.c51)) &&
                        (prueba1_3.equals(ContactoTuplaTest.c31));
    return resultado;
  }
  public static boolean prueba2_buscarNumero ()
  {
    resetear();
    prueba2_1 = agenda1.buscarNumero(123456);
    prueba2_2 = agenda1.buscarNumero(983210);
    prueba2_3 = agenda1.buscarNumero(567890);
    boolean resultado = (prueba2_1.equals(ContactoTuplaTest.c11)) &&
                        (prueba2_2.equals(ContactoTuplaTest.c51)) &&
                        (prueba2_3.equals(ContactoTuplaTest.c31));
    return resultado;
  }
  public static boolean prueba3_poner ()
  {
    resetear();
    agenda1.poner(ContactoTuplaTest.c61);
    agenda1.poner(ContactoTuplaTest.c71);
    agenda1.poner(ContactoTuplaTest.c12);
    prueba3_1 = agenda1.buscarNombre("Laura");
    prueba3_2 = agenda1.buscarNombre("Karla");
    prueba3_3 = agenda1.buscarNumero(234567);
    boolean resultado = (prueba3_1.equals(ContactoTuplaTest.c61)) &&
                        (prueba3_2.equals(ContactoTuplaTest.c71)) &&
                        (prueba3_3.equals(ContactoTuplaTest.c12));
    if (!resultado) mostrar();  // En caso de fallo
    return resultado;
  }
  public static boolean prueba4_quitar ()
  {
    resetear();
    // Se quitan Elinela, Daniel y Pablo
    agenda1.quitar(ContactoTuplaTest.c11);  // Elinela por Sharif
    agenda1.quitar(ContactoTuplaTest.c41);  // Daniel
    agenda1.quitar(ContactoTuplaTest.c21);  // Pablo por Ida
    // Quedan Sharif e Ida
    prueba4_1 = agenda1.buscarNombre("Sharif");
    prueba4_2 = agenda1.buscarNombre("Ida");
    prueba4_3 = agenda1.buscarNombre("Daniel");
    boolean resultado = (prueba4_1.equals(ContactoTuplaTest.c51)) &&
                        (prueba4_2.equals(ContactoTuplaTest.c31)) &&
                        (prueba4_3 == null);
    if (!resultado) mostrar();  // En caso de fallo
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
  }
}