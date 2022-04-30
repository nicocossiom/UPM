/**
 * Especificación del TAD Contacto<br>
 * {@code Contacto = (nombre, telefono)}<br>
 * @since 27/02/2018
 * @version 1.0
 * @author JMB
 */
public interface Contacto
{
/**
 * POST: resultado es la cadena de caracteres formada por los
 *       atributos del objeto
 */
  public String toString ();
/**
 * POST: resultado es el nombre del objeto
 */
  public String getNombre ();
/**
 * POST: resultado es el numero de telefono del objeto
 */
  public int getTelefono ();
/**
 * POST: resultado es cierto si "otro" es identico al objeto y es
 *       falso e.o.c.
 */
  public boolean equals (Object cc);
/**
 * POST: resultado es cierto si "nomb" es identico al nombre del
 *       objeto y es falso e.o.c.
 */
  public boolean igualNombre (String nomb);
/**
 * POST: resultado es cierto si "num" es identico al numero de 
 *       telefono del objeto y es falso e.o.c.
 */
  public boolean igualTelefono (int num);

  //OPERACION EXTRA ("setTelefono")  ---------------------------------

/**
* POST: Modifica el numero de telefono del objeto
*/
 public void setTelefono (int num);
}

