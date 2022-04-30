package academia;
/**
 * Implementaci�n de una ColIndexVar gen�rica<br>
 * {@code ICol = Tupla(Entero longitud, E[] elementos)}<br>
 * {@code INV(ICol) = (longitud>0)/\(longitud<elementos.length)}<br>
 * @since 19/03/2019
 * @version 1.0
 * @author JMB
 */
public class ColTupla<E> implements ICol<E>
{

  private int longitud;
  private E[] elementos;

  @SuppressWarnings("unchecked")
  public ColTupla (int tamano)
  {
    longitud = 0;
    elementos = (E[]) new Object[tamano];
  }
  
  public String toString ()
  {
    String resultado = "<";
    for (int i = 0; i < longitud; i++)
    {
      resultado = resultado + elementos[i];
      if (i < longitud-1)
        resultado = resultado + " \n";
    }
    resultado = resultado + ">";
    return "(" + longitud + "," + resultado + ")";
  }
  public int size()
  {
    return longitud;
  }
  public E get (int pos)
  {
    return elementos[pos];
  }
  public void set (int pos, E elem)
  {
    elementos[pos] = elem;
  }
  public void add (int pos, E elem)
  {
    if (elementos.length > longitud)
    {
      for (int i = longitud; i > pos; i--)
        elementos[i] = elementos[i-1];
      elementos[pos] = elem;
      longitud = longitud + 1;
    }
  }
  public void remove (int pos)
  {
    for (int i = pos; i < longitud-1; i++)
      elementos[i] = elementos[i+1];
    longitud = longitud - 1;
  }
  public void restaurar (ICol<E> inicial)
  {
    ColTupla<E> origen = (ColTupla<E>) inicial;
    for (int i = 0; i < origen.size(); i++)
      elementos [i] = origen.get(i);
    longitud = origen.longitud;
  }

}