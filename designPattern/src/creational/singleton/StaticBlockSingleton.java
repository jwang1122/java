package creational.singleton;
/*
 * provides option for exception handling.
 */
public class StaticBlockSingleton {
	private static StaticBlockSingleton instance;
	private int x = 5;
	
	private StaticBlockSingleton() {
	}

	// static block initialization for exception handling
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public static void main(String[] args) {
		StaticBlockSingleton obj1 = StaticBlockSingleton.getInstance();
		System.out.println(obj1);
		System.out.println(obj1.getX());
		
		StaticBlockSingleton obj2 = StaticBlockSingleton.getInstance();
		System.out.println(obj2);
		System.out.println(obj2.getX());
		obj2.setX(10);
		System.out.println(obj1.getX());

	}

}
