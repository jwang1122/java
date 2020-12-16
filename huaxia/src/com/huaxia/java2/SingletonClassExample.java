package com.huaxia.java2;

public class SingletonClassExample {
	private String objectState;
	private static SingletonClassExample instance = new SingletonClassExample();

	private SingletonClassExample(){
		this.objectState = "Huaxia Java Level-II";
	}

	public static SingletonClassExample getInstance() {
		return instance;
	}

	public String getObjectState() {
		return objectState;
	}

	public void setObjectState(String objectState) {
		this.objectState = objectState;
	}
	
	public static void main(String[] args) {
		SingletonClassExample obj1 = SingletonClassExample.getInstance();
		System.out.println(obj1.getObjectState());
		System.out.println("obj1" + obj1);

		SingletonClassExample obj2 = SingletonClassExample.getInstance();
		obj2.setObjectState("Hello, the world!");
		System.out.println(obj2.getObjectState());
		System.out.println("obj2: "+obj2);
		
		System.out.println(obj1.getObjectState());

	}
}