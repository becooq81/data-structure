import java.util.ArrayList;
import java.util.Iterator;

public class Hash<K, V> {
	
	class HashElement<K, V> implements Comparable<HashElement<K, V>> {
		K key;
		V value;
		public HashElement(K key, V value) {
			this.key = key;
			this.value = value;
		}
		public int compareTo(HashElement<K, V> obj) {
			return (((Comparable<K>) this.key).compareTo(obj.key));
		}
		public K getKey() {
			return this.key;
		}
		public V getValue() {
			return this.value;
		}
		public int hashCode() {
		    int result = key != null ? key.hashCode() : 0;
		    result = 31 * result + (value != null ? value.hashCode() : 0);
		    return result;
		}
		
	}
	
	int numElements, tableSize;
	double maxLoadFactor;
	LinkedList<HashElement<K, V>>[] harray;
	ArrayList<HashElement<K, V>> elements;
	public Hash(int tableSize) {
		this.tableSize = tableSize;
		maxLoadFactor = 0.75;
		numElements = 0;
		elements = (ArrayList<HashElement<K, V>>) new ArrayList();
		harray = (LinkedList<HashElement<K, V>>[]) new LinkedList[tableSize];
		for (int i = 0; i < tableSize; i++) {
			harray[i] = new LinkedList<HashElement<K, V>>();
		}
	}
	public double getLoadFactor() {
		return ((double) numElements) / tableSize;
	}
	public boolean add(K key, V value) {
		if (this.getLoadFactor() >= maxLoadFactor) {
			this.resize(tableSize*2);
		}
		HashElement<K, V> he = new HashElement(key, value);
		int hashval = key.hashCode();
		hashval = (hashval & 0x7fffffff) % tableSize;
		harray[hashval].addFirst(he);
		numElements++;
		elements.add(he);
		return true;
	}
	public boolean remove(K key, V value) {
		HashElement<K, V> he = new HashElement(key, value);
		int hashval = key.hashCode();
		hashval = (hashval & 0x7fffffff) % tableSize;
		harray[hashval].remove(he);
		numElements--;
		elements.remove(he);
		return true;
	}
	public LinkedList<Hash<K, V>.HashElement<K, V>> getValue(K key) {
		int hashval = (key.hashCode() & 0x7fffffff) % tableSize;
		if (hashval < tableSize) {
			return harray[hashval];
		}
		return null;
	}
	public void resize(int newSize) {
		LinkedList<HashElement<K, V>>[] new_array =  (LinkedList<HashElement<K, V>>[]) new LinkedList[newSize];
		for (int i = 0; i < newSize; i++) {
			new_array[i] = new LinkedList<HashElement<K, V>>();
		}
		for (HashElement<K, V> he : elements) {
			int hashval = (he.key.hashCode() & 0x7FFFFFFF) % newSize;
			new_array[hashval].addFirst(he);
		}
		harray = new_array;
		tableSize = newSize;
	}
	
}
