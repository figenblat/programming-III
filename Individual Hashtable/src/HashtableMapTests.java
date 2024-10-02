
public class HashtableMapTests {
	
	static HashtableMap<Object, Object> test = new HashtableMap<Object,Object>();
	public static boolean test1() { 
		
		Object key = "Hello";
		Object value = 330;
		
		if(test.put(key, value)==true) {
			System.out.println("test1 testing put() works!");
			return true;
		}
		else {
			System.out.println("test1 testing put() does not work");
			return false;
		}
		
	}
	public static boolean test2() { 
		Object key2 = "My";
		Object value2 = 2002;
		test.put(key2, value2);
		if(test.get(key2)== value2) {
			System.out.println("test2 testing get() works!");
			return true;
		}
		else {
			System.out.println("test2 testing get() is not working");
		}
		return false;
		}
	public static boolean test3() { 
		Object key3 = "Name";
		Object value3 = 3;
		
		test.put(key3, value3);
		
		if(test.size()!= 3) {
			System.out.println("test3 testing size() is not working");
			return false;
		}
		else {
			System.out.println("test3 testing size() works!");
			return true;
		}
		
	}
	public static boolean test4() { 
		Object key4 = 4;
		Object value4 = "Is";
		
		test.put(key4, value4);
		
		if(test.containsKey(key4)==true) {
			System.out.println("test4 testing containsKey() works!");
		}
		else {
			System.out.println("test4 testing containsKey() does not work");
			return false;
		}
		return false;
	}
	public static boolean test5() { 
		Object key5 = "Noa";
		Object value5 = 99980;
		
		test.put(key5, value5);
		
		if(test.remove(key5)==value5) {
			System.out.println("test5 testing remove() works!");
			return true;
		}
		else {
			System.out.println("test5 testing remove() does not work");
			return false;
		}	
	}
	public static void main (String[]args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}
}
