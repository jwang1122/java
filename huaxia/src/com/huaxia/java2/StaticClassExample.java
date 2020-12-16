package com.huaxia.java2;

public class StaticClassExample {
	private static String str = "Huaxia Java Level-II";

	// nested class which is a Static class, can only be nested class
	public static class StaticDemo {
		// non-static method of Static class
		public void show() {
			System.out.println(str);
		}
	}

	public static void main(String args[]) {
		StaticClassExample.StaticDemo obj = new StaticClassExample.StaticDemo();
		obj.show();
	}
}
