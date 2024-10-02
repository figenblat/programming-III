// --== CS400 Project One File Header ==--
// Name: Noa Figenblat
// Email: figenblat@wisc.edu
// Team: red
// Group: CP
// TA: Evan Wireman
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashtableMap<K,V> implements MapADT<K,V> {
	private static int capacity;
	private Object key;
	private Object value;
	private Object []hashTable;
	private static int size;
	final double LOADFACTORTHRESH = 0.8;
	
	public HashtableMap(int capacity) {
		HashtableMap.capacity=capacity;
		HashtableMap.size=0;
		this.hashTable = new Object[capacity];
		for (int i = 0; i<capacity;i++) {
			this.hashTable[i]=null;
		}
		
		
	}
	public HashtableMap() {
		HashtableMap.capacity = 20;
		HashtableMap.size=0;
		this.hashTable= new Object[capacity];
		for(int i = 0;i<capacity;i++) {
			this.hashTable[i]=null;
		}
		
		
	}
	@Override
	public boolean put(K key, V value) {
		int index = getIndex(key);
		if(this.containsKey(key)) {
			return false;
		}
		else {
		this.key=key;
		this.value=value;
		hashTable[index]=value;
		size++;
		return true;
		}	
	}
		

	@Override
	public V get(K key) throws NoSuchElementException {
		if(key==null||)
		Object value=null;
		int index = getIndex(key);
		value=this.hashTable[index];
		return (V) value;

	}
	@Override
	public int size() {
		return this.size;

	}
	@Override
	public boolean containsKey(K key) {
		int index = getIndex(key);
		if(this.hashTable[index]!=null)
			return true;
		else
			return false;

	}
	@SuppressWarnings("unchecked")
	@Override
	public V remove(K key) {
		Object value=null;
		int index = getIndex(key);
		if(this.hashTable[index]!=null) {
			value=this.hashTable[index];
			this.put((K)hashTable[index], null);
		}	
		return (V) value;

	}
	@Override
	public void clear() {
		for(int i = 0;i<capacity;i++) {
			this.hashTable[i]=null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean reHash() {
		Object[] temp = new Object[capacity];
		for(int i = 0; i<capacity;i++) {
			temp[i]=hashTable[i];
			
		}
		HashtableMap.capacity=capacity*2;
		
		hashTable = new Object[capacity];
		for (int i = 0; i< temp.length;i++) {
			Object key = temp[i];
			
			if(key!=null) {
				int index = getIndex((K) key);
				Object value = hashTable[index];
				this.put((K)key, (V)value);
			}
		
		}
		
		return true;
	}
	private final int hashCodeGenerator(K key) {
		int hashCode = Math.abs(key.hashCode()) % hashTable.length;
		return hashCode;
	}
	public int getIndex (K key) {
		int hashCode = hashCodeGenerator(key);
		int index = hashCode % this.capacity;
		return index;
		}
	
	
	public static void main(String[]args) {
		HashtableMap test = new HashtableMap(10);
		//HashTableMap test1 = new HashtableMap(10);
		System.out.println(capacity);
		System.out.println(size);
		
		System.out.println(capacity);
		
		test.put("hello", 330);
		test.put("hi", 1100);
		test.put("hi", 1100);
		test.put("HELLO", 200);
		test.put("World", 1100);
		test.put("okay", 1100);
		test.reHash();
		test.containsKey("HELLO");
		test.containsKey("hi");
		test.containsKey("okay");
		
		
	}
}
