import es.upm.babel.cclib.Producto;
import es.upm.babel.cclib.Almacen;
import es.upm.babel.cclib.Semaphore;

/**
 * Implementaci�n de la clase Almacen que permite el almacenamiento
 * FIFO de hasta un determinado n�mero de productos y el uso
 * simult�neo del almac�n por varios threads.
 */
class AlmacenN implements Almacen {
	private int capacidad;
	private Producto[] almacenado = null;
	private int nDatos;
	private int aExtraer;
	private int aInsertar;
	private Semaphore mutEx;
	private Semaphore almacc;
	private Semaphore extcc;
	
	
	public AlmacenN(int n) {
		capacidad = n;
		almacenado = new Producto[capacidad];
		nDatos = 0;
		aExtraer = 0;
		aInsertar = 0;
		
		mutEx = new Semaphore(1);
		almacc = new Semaphore(capacidad);
		extcc = new Semaphore(0);
		
	}

	public void almacenar(Producto producto) {
		almacc.await();
		mutEx.await();
		// Secci�n cr�tica
		almacenado[aInsertar] = producto;
		nDatos++;
		aInsertar++;
		aInsertar %= capacidad;
		
		mutEx.signal();
		extcc.signal();
	}

	public Producto extraer() {
		extcc.await();
		mutEx.await();
		Producto result;

		// Secci�n cr�tica
		result = almacenado[aExtraer];
		almacenado[aExtraer] = null;
		nDatos--;
		aExtraer++;
		aExtraer %= capacidad;

		mutEx.signal();
		almacc.signal();
		return result;
	}
}
