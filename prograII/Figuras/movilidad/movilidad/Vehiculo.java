package movilidad;
/**
 * Implementación del TAD Vehiculo<br>
 *{@code Vehiculo = (int color, int numeroSerie)}<br>
 * @since 7/4/19
 * @version 1.
 * @author JMB
 */
public class Vehiculo implements IVehiculo
{
// CONSTANTES PARA LOS COLORES  -------------------------------------

  public static final int AZUL = 1;
  public static final int ROJO = 3;
  public static final int VERDE = 2;

// ESTRUCTURA  ------------------------------------------------------
  
  private int color;
  private int numeroSerie;

// OPERACIONES  -----------------------------------------------------
  
  public Vehiculo (int elColor, int elNumero)
  {
    color = elColor;
    numeroSerie = elNumero;
  }  
  public String toString()
  {
    return "Vehículo: (" + color + "," + numeroSerie + ")";
  }
  public int getColor ()
  {
    return color;
  }
  public int getNumeroSerie ()
  {
    return numeroSerie;
  }
  public void setColor (int nuevoColor)
  {
    color = nuevoColor;
  }
  public void setNumeroSerie (int nuevoNumero)
  {
    numeroSerie = nuevoNumero;
  }
}