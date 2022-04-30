package academia;
/**
 * Especificación de una ColIndexVar genérica<br>
 * {@code elemento = <E>}<br>
 * @since 19/03/2019
 * @version 1.0
 * @author JMB
 */
public interface ICol<E>
{
/**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto
 */
  public String toString ();
/**
 * POST: Resultado es el número de elementos del objeto.
 */
  public int size();
/**
 * PRE: pos IN [0,size()-1]
 * POST: resultado es el elemento del objeto que esta en la
 *       posición "pos".
 */
  public E get (int pos);
/**
 * PRE: pos IN [0,size()-1]
 * POST: modifica el elemento del objeto que esta en la posición "pos".
 */
  public void set (int pos, E elem);
/**
 * PRE: pos IN [0,size()]
 * POST: Añade el elemento "elem" al objeto, poniéndolo en la
 *       posicion "pos".
 */
  public void add (int pos, E elem);
/*
 * PRE: pos IN [0,size()-1]
 * POST: Elimina del objeto el elemento que está en la posición
 *       "pos". El objeto pasa a tener un elemento menos.
*/
  public void remove (int pos);
/*
 * POST: restaura la "col" con los valores de "origen".
*/
  public void restaurar (ICol<E> inicial);

}