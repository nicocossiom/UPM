package figura;
/**
 * Especificacion de una ColIndexVar generica<br>
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
 * POST: Resultado es el n�mero de elementos del objeto.
 */
  public int size();
/**
 * PRE: pos IN [0,size()-1]
 * POST: resultado es el elemento del objeto que esta en la
 *       posici�n "pos".
 */
  public E get (int pos);
/**
 * PRE: pos IN [0,size()-1]
 * POST: modifica el elemento del objeto que esta en la posici�n "pos".
 */
  public void set (int pos, E elem);
/**
 * PRE: pos IN [0,size()]
 * POST: A�ade el elemento "elem" al objeto, poni�ndolo en la
 *       posicion "pos".
 */
  public void add (int pos, E elem);
/*
 * PRE: pos IN [0,size()-1]
 * POST: Elimina del objeto el elemento que est� en la posici�n
 *       "pos". El objeto pasa a tener un elemento menos.
*/
  public void remove (int pos);
/*
 * POST: restaura la "col" con los valores de "origen".
*/
  public void restaurar (ICol<E> inicial);

}