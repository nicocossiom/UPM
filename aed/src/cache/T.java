package cache;

public class T {
	public static void main(String[] args) {
		Integer[] a = new Integer[] { 1 };
		String[] b = new String[] { "a" };
		Storage<Integer, String> m = new Storage<Integer, String>(a, b);
		Cache<Integer, String> c = new Cache<Integer, String>(2, m);
		c.put(2, "b");
		System.out.println(c.get(2));
		System.out.println(c.get(2));
	}
}