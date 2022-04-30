import es.upm.babel.cclib.Producto;
import es.upm.babel.cclib.Monitor;
import es.upm.babel.cclib.MultiAlmacen;

// importar la librer�a de monitores


class MultiAlmacenMon implements MultiAlmacen {
    private int capacidad = 0;
    private Producto almacenado[] = null;
    private int aExtraer = 0;
    private int aInsertar = 0;
    private int nDatos = 0;

   // TODO: declaraci�n de atributos extras necesarios
   // para exclusi�n mutua y sincronizaci�n por condici�n
    private Monitor mutex = new Monitor();
    private Monitor.Cond lleno;
    private Monitor.Cond vacio;

   private MultiAlmacenMon() {
   }

   public MultiAlmacenMon(int n) {
      almacenado = new Producto[n];
      aExtraer = 0;
      aInsertar = 0;
      capacidad = n;
      nDatos = 0;
      // TODO: inicializaci�n de otros atributos
   }

   private int nDatos() {
         return nDatos;
   }
   
   private int nHuecos() {
      return capacidad - nDatos;
   }

   public void almacenar(Producto[] productos) {

      // TODO: implementaci�n de c�digo de bloqueo para 
      // exclusi�n muytua y sincronizaci�n condicional 
	   mutex.enter();
	   if(productos.length > nHuecos()) {
		   lleno.await();
	   }
      // Secci�n cr�tica
      for (int i = 0; i < productos.length; i++) {
         almacenado[aInsertar] = productos[i];
         nDatos++;
         aInsertar++;
         aInsertar %= capacidad;
      }

      // TODO: implementaci�n de c�digo de desbloqueo para
      // sincronizaci�n condicional y liberaci�n de la exclusi�n mutua  
      mutex.leave();
   }

   public Producto[] extraer(int n) {
      Producto[] result = new Producto[n];

      // TODO: implementaci�n de c�digo de bloqueo para exclusi�n
      // mutua y sincronizaci�n condicional 
      mutex.enter();
	   if(nDatos>0) {
		   vacio.await();
	   }
      // Secci�n cr�tica
      for (int i = 0; i < result.length; i++) {
         result[i] = almacenado[aExtraer];
         almacenado[aExtraer] = null;
         nDatos--;
         aExtraer++;
         aExtraer %= capacidad;
      }

      // TODO: implementaci�n de c�digo de desbloqueo para
      // sincronizaci�n condicional y liberaci�n de la exclusi�n mutua  
      mutex.leave();
      return result;
   }
}