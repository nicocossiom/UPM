/**
 * Especificación del TAD Agenda<br>
 * {@code Agenda = Col(Contacto)}<br>
 * @since 27/02/2018
 * @version 1.0
 * @author JMB
 */
public interface Agenda
{
/**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto
 */
  public String toString();
/**
 * POST: resultado es el Contacto de la primera aparicion con nombre
 *       "nombre". Si no se encuentra, resultado es un Contacto nulo.
 */
  public Contacto buscarNombre (String nombre);
/**
 * POST: resultado es el Contacto de la primera aparicion con telefono
 *       "numero". Si no se encuentra, resultado es un Contacto nulo.
 */
  public Contacto buscarNumero (int numero);
/**
 * POST: Añade el elemento "contacto" al objeto, poniéndolo al final.
 */
  public void poner(Contacto contacto);
/**
 * POST: Elimina del objeto el elemento "contacto". Si no existe
 *       no hace nada.
 */
  public void quitar (Contacto contacto);
 
  //OPERACIONES EXTRAS  ----------------------------------------------
 
/**
* POST: Modifica el telefono del objeto por el de "contacto".
*/ 
 public void cambiarTelefono (Contacto contacto);
 
/**
* POST: resultado es el total de los telefonos del objeto que 
*       empiezan por el prefijo "prefijo"
*/
 public int cuantosConPrefijo (int prefijo);
}