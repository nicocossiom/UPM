import es.upm.babel.cclib.Producto;
import es.upm.babel.cclib.Monitor;
import es.upm.babel.cclib.MultiAlmacen;

// importar la librería de monitores


class MultiAlmacenMon implements MultiAlmacen {
    private int capacidad = 0;
    private Producto almacenado[] = null;
    private int aExtraer = 0;
    private int aInsertar = 0;
    private int nDatos = 0;

   // TODO: declaración de atributos extras necesarios
   // para exclusión mutua y sincronización por condición
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
      // TODO: inicialización de otros atributos
   }

   private int nDatos() {
         return nDatos;
   }
   
   private int nHuecos() {
      return capacidad - nDatos;
   }

   public void almacenar(Producto[] productos) {

      // TODO: implementación de código de bloqueo para 
      // exclusión muytua y sincronización condicional 
	   mutex.enter();
	   if(productos.length > nHuecos()) {
		   lleno.await();
	   }
      // Sección crítica
      for (int i = 0; i < productos.length; i++) {
         almacenado[aInsertar] = productos[i];
         nDatos++;
         aInsertar++;
         aInsertar %= capacidad;
      }

      // TODO: implementación de código de desbloqueo para
      // sincronización condicional y liberación de la exclusión mutua  
      mutex.leave();
   }

   public Producto[] extraer(int n) {
      Producto[] result = new Producto[n];

      // TODO: implementación de código de bloqueo para exclusión
      // mutua y sincronización condicional 
      mutex.enter();
	   if(nDatos>0) {
		   vacio.await();
	   }
      // Sección crítica
      for (int i = 0; i < result.length; i++) {
         result[i] = almacenado[aExtraer];
         almacenado[aExtraer] = null;
         nDatos--;
         aExtraer++;
         aExtraer %= capacidad;
      }

      // TODO: implementación de código de desbloqueo para
      // sincronización condicional y liberación de la exclusión mutua  
      mutex.leave();
      return result;
   }
}