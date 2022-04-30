import es.upm.babel.cclib.Producto;
import es.upm.babel.cclib.Almacen;
import es.upm.babel.cclib.Productor;
import es.upm.babel.cclib.Consumidor;

/**
 * Programa concurrente para productor-buffer-consumidor con almacen
 * de capacidad N implementado con sem�foros (AlmacenN).
 */
class CC_06_PNCSem {
   public static final void main(final String[] args)
      throws InterruptedException
   {
      // Capacidad del buffer
      final int CAPACIDAD = 10;

      // N�mero de productores y consumidores
      final int N_PRODS = 2;
      final int N_CONSS = 2;

      // Almacen compartido
      Almacen almac = new AlmacenN(CAPACIDAD);

      // Declaraci�n de los arrays de productores y consumidores
      Productor[] productores;
      Consumidor[] consumidores;

      // Creaci�n de los arrays
      productores = new Productor[N_PRODS];
      consumidores = new Consumidor[N_CONSS];
      // Creaci�n de los productores
      for (int i = 0; i < N_PRODS; i++) {
         productores[i] = new Productor(almac);
      }

      // Creaci�n de los consumidores
      for (int i = 0; i < N_CONSS; i++) {
         consumidores[i] = new Consumidor(almac);
      }

      // Lanzamiento de los productores
      for (int i = 0; i < N_PRODS; i++) {
         productores[i].start();
      }

      // Lanzamiento de los consumidores
      for (int i = 0; i < N_CONSS; i++) {
         consumidores[i].start();
      }

      // Espera hasta la terminaci�n de los procesos
      try {
         for (int i = 0; i < N_PRODS; i++) {
            productores[i].join();
         }
         for (int i = 0; i < N_CONSS; i++) {
            consumidores[i].join();
         }
      } catch (Exception ex) {
         ex.printStackTrace();
         System.exit (-1);
      }
   }
}