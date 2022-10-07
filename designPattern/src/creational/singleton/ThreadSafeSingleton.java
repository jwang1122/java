package creational.singleton;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;

	private int x = 5;

	private ThreadSafeSingleton() {
	}

	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public static void main(String[] args) {
		LazyInitializedSingleton obj1 = LazyInitializedSingleton.getInstance();
		System.out.println(obj1);
		System.out.println(obj1.getX());

		LazyInitializedSingleton obj2 = LazyInitializedSingleton.getInstance();
		System.out.println(obj2);
		System.out.println(obj2.getX());
		obj2.setX(10);
		System.out.println(obj1.getX());
	}

}