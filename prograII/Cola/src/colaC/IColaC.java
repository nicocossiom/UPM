package colaC;

/**
 * Especificación del TAD Cola<br>
 * Como la ICol, pero encolar lanza una excepción propia<br>
 * @since 4/5/2020
 * @version 1.0
 * @author JMB
 */
public interface IColaC<E>
{
  public final int MAX_ELEMENTOS = 10;  // Capacidad maxima permitida.
/**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto.
 */
  public String toString ();
/**
 * POST: Comprueba si la cola esta vacia.
 */
  public boolean estaVacia ();
/**
 * PRE: La cola no esta vacia.
 * POST: Devuelve el primer elemento (el del extremo anterior).
 * @throws Cola.ColaVacia 
 */
  public E primero() throws colaC.ColaVacia;
/**
 * POST: Añade el elemento "elem" en el extremo posterior.
 */
  public void encolar (E elem) throws ColaLlena;
/**
 * POST: Elimina el primer elemento (el del extremo anterior).
 * @throws colaC.ColaVacia 
*/
  public void desencolar ();
/*
 * POST: Resultado es el número de elementos del objeto.
 */
  public int size();

}