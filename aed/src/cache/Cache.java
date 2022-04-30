package cache;

import es.upm.aedlib.Entry;
import es.upm.aedlib.Position;
import es.upm.aedlib.map.*;
import es.upm.aedlib.positionlist.*;

public class Cache<Key, Value> {

	// Tamano de la cache
	private int maxCacheSize;

	// NO MODIFICA ESTOS ATTRIBUTOS, NI CAMBIA SUS NOMBRES: mainMemory,
	// cacheContents, keyListLRU

	// Para acceder a la memoria M
	private Storage<Key, Value> mainMemory;
	// Un 'map' que asocia una clave con un ``CacheCell''
	private Map<Key, CacheCell<Key, Value>> cacheContents;
	// Una PositionList que guarda las claves en orden de
	// uso -- la clave mas recientemente usado sera el keyListLRU.first()
	private PositionList<Key> keyListLRU;

	// Constructor de la cache. Especifica el tamano maximo
	// y la memoria que se va a utilizar
	public Cache(int maxCacheSize, Storage<Key, Value> mainMemory) {
		this.maxCacheSize = maxCacheSize;

		// NO CAMBIA
		this.mainMemory = mainMemory;
		this.cacheContents = new HashTableMap<Key, CacheCell<Key, Value>>();
		this.keyListLRU = new NodePositionList<Key>();
	}

	// Devuelve el valor que corresponde a una clave "Key"
	public Value get(Key key) {
		// key no tiene valor asociado
		if (mainMemory.read(key) == null && !cacheContents.containsKey(key)) {
			return null;
		}
		// key tiene valor asociado
		return StManager(key).getValue();
	}

	// A�ade al cache una key con su valor asociado, si hace falta
	private CacheCell<Key, Value> StManager(Key key) {
		CacheCell<Key, Value> elemento = null;
		// He accedido a el objeto recientemente (esta en cache)
		if (cacheContents.containsKey(key)) {
			elemento = cacheContents.get(key);
			if (!keyListLRU.first().element().equals(key)) {
				keyListLRU.remove(elemento.getPos()); // borramos pos para actualizarla
				keyListLRU.addFirst(key); // a�adimos a la lista de acceso como ultimo accedido
				elemento.setPos(keyListLRU.first()); // actualizamos la posicion
			}
		}
		// No he accedido a el objeto recientemente (no esta en cache)
		else {
			// Borro si esta lleno
			if (keyListLRU.size() == this.maxCacheSize) {
				Position<Key> aeliminar = keyListLRU.last();
				Key keydeaeliminar = aeliminar.element();
				// Gurdo antes en memoria si esta sucio
				CacheCell<Key, Value> elemaeliminar = cacheContents.get(keydeaeliminar);
				if (elemaeliminar.getDirty()) {
					mainMemory.write(keydeaeliminar, elemaeliminar.getValue());
				}
				// Borro en cache y lista de acceso
				cacheContents.remove(keydeaeliminar);
				keyListLRU.remove(aeliminar);
			}
			// He hecho hueco en cache, a�ado la key a cache
			keyListLRU.addFirst(key);
			Value valor = mainMemory.read(key);
			elemento = new CacheCell<Key, Value>(valor, false, keyListLRU.first());
			cacheContents.put(key, elemento); // meto en cache (mapa!=put de Cache)
		}
		return elemento;
	}

	// Establece un valor nuevo para la clave en la memoria cache
	public void put(Key key, Value value) {
		CacheCell<Key, Value> nuevoencache = StManager(key);
		nuevoencache.setValue(value); // cambiamos valor
		nuevoencache.setDirty(true); // sucio
	}

	// NO CAMBIA
	public String toString() {
		return "cache";
	}
}
