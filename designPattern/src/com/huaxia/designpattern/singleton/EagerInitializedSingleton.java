package com.huaxia.designpattern.singleton;
/**
 * it has a drawback that instance is created even though client application 
 * might not be using it.
 * @author John
 *
 */
public class EagerInitializedSingleton {
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
	private int x = 5;
	
	// private constructor to avoid client applications to use constructor
	private EagerInitializedSingleton() {
	}

	public static EagerInitializedSingleton getInstance() {
		return instance;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public static void main(String[] args) {
		EagerInitializedSingleton obj1 = EagerInitializedSingleton.getInstance();
		System.out.println(obj1);
		System.out.println(obj1.getX());
		
		EagerInitializedSingleton obj2 = EagerInitializedSingleton.getInstance();
		System.out.println(obj2);
		System.out.println(obj2.getX());
		obj2.setX(10);
		System.out.println(obj1.getX());
	}

}
