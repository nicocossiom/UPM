import es.upm.babel.cclib.Producto;
import es.upm.babel.cclib.Almacen;
import es.upm.babel.cclib.Productor;
import es.upm.babel.cclib.Consumidor;
import es.upm.babel.cclib.Consumo;
import es.upm.babel.cclib.Fabrica;

/**
 * Programa concurrente para productor-buffer-consumidor con almacen
 * de tamaño 1 implementado con semaforos (Almacen1).
 */
class CC_05_P1CSem {
    public static final void main(final String[] args)
       throws InterruptedException
    {
        // Numero de productores y consumidores
        final int N_PRODS = 2;
        final int N_CONSS = 2;

        Consumo.establecerTiempoMedioCons(500);
        Fabrica.establecerTiempoMedioProd(1000);

        // Almacen compartido
        Almacen almac = new Almacen1();

        // Declaracion de los arrays de productores y consumidores
        Productor[] productores;
        Consumidor[] consumidores;

        // Creacion de los arrays
        productores = new Productor[N_PRODS];
        consumidores = new Consumidor[N_CONSS];

        // Creacion de los productores
        for (int i = 0; i < N_PRODS; i++) {
            productores[i] = new Productor(almac);
        }

        // Creacion de los consumidores
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

        // Espera hasta la terminacion de los procesos
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
