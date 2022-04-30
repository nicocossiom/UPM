/**
 * Implementación de una colección acotada con ocupacion variable<br>
 * {@code ColIndexVar = Tupla(Entero longitud, Entero[] elementos)}<br>
 * {@code INV(ColIndexvar) = (longitud>0)/\(longitud<elementos.length)}<br>
 * @since 12/03/2018
 * @version 1.0
 * @author JMB
 */
public class CIContactoTupla implements CIContacto{
  
  private int longitud;
  private Contacto[] elementos;
  private final int maxelementos;

  public CIContactoTupla (int tamaño){
    longitud = 0;
    maxelementos = tamaño;
    elementos = new Contacto[maxelementos];
    
  }
  
  //Visualizador
  public String toString (){
    String resultado = "<";
    for (int i = 0; i < longitud; i++) {
      resultado = resultado + elementos[i];
      if (i < longitud-1)
        resultado = resultado + ",";
    }
    resultado = resultado + ">";
    return "(" + longitud + "," + resultado + ")";
  }
  
  //Tamaño real de la coleccion y no el el length
  public int size()
  {
    return longitud;
  }
  
  //Devuelve el contacto de la posicion que se quiera
  public Contacto get (int pos)
  {
    return elementos[pos];
  }
  //Pone el contacto en la posicion que se quiera 
  public void set (int pos, Contacto contacto)
  {
    elementos[pos] = contacto;
  }
  
  //Añade el elemento "elem" al objeto, poniéndolo en la posicion "pos".  
  public void add (int pos, Contacto contacto)
  {
    if (elementos.length > longitud)
    {
      for (int i = longitud; i > pos; i--)
        elementos[i] = elementos[i-1];
      elementos[pos] = contacto;
      longitud = longitud + 1;
    }
 }
  //Elimina del objeto el elemento que está en la posición "pos". El objeto pasa a tener un elemento menos
  public void remove (int pos)
  {
    for (int i = pos; i < longitud-1; i++)
      elementos[i] = elementos[i+1];
    longitud = longitud - 1;
  }
  
  //Restaura la "col" con los valores de "inicial"
  public void restaurar (CIContacto inicial)
  {
    CIContactoTupla origen = (CIContactoTupla) inicial;
    for (int i = 0; i < origen.size(); i++)
      elementos [i] = origen.get(i);
    longitud = origen.longitud;
  }

	
}