package cache;

import es.upm.aedlib.Entry;
import es.upm.aedlib.map.Map;
import es.upm.aedlib.map.HashTableMap;

public class Storage<Key, Value> {
	HashTableMap<Key, Value> table;

	public Storage(Key[] keys, Value[] values) {
		table = new HashTableMap<Key, Value>();
		for (int i = 0; i < keys.length; i++)
			table.put(keys[i], values[i]);
	}

	public Storage(Storage<Key, Value> old) {
		table = new HashTableMap<Key, Value>();
		for (Entry<Key, Value> entry : old.table.entries()) {
			table.put(entry.getKey(), entry.getValue());
		}
	}

	public Iterable<Entry<Key, Value>> entries() {
		return table.entries();
	}

	public Value read(Key key) {
		return table.get(key);
	}

	public void write(Key key, Value value) {
		table.put(key, value);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("[");
		for (Entry<Key, Value> entry : table.entries()) {
			if (result.length() > 1)
				result.append(",");
			result.append("<" + entry.getKey() + "," + entry.getValue() + ">");
		}
		result.append("]");
		return result.toString();
	}
}
