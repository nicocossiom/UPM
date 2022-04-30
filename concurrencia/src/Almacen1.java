import es.upm.babel.cclib.Producto;
import es.upm.babel.cclib.Almacen;
import es.upm.babel.cclib.Semaphore;
// TODO: importar la clase de los semaforos.

/**
 * Implementacion de la clase Almacen que permite el almacenamiento
 * de producto y el uso simultaneo del almacen por varios threads.
 */
class Almacen1 implements Almacen {
	// Producto a almacenar: null representa que no hay producto
	private Producto almacenado;
	private Semaphore mutex;
	private Semaphore prodacc;	  
	private Semaphore almacc;	  

	public Almacen1() {
		this.almacenado=null;
		prodacc = new Semaphore(1);
		mutex = new Semaphore(1);
		almacc = new Semaphore(1);
	}

	public void almacenar(Producto producto) {
		almacc.await();
		mutex.await();
		///Critical///
		almacenado = producto;
		//////////////
		mutex.signal();
		prodacc.signal();
	}

	public Producto extraer() {
		prodacc.await();
		mutex.await();
		Producto result=null;
		///Critical///
		result = almacenado;
		almacenado=null;
		//////////////
		mutex.signal();
		almacc.signal();
		return result;
	}

}
