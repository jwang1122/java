package com.huaxia.tricks;

public class AvoidNull {
	static int num = 50;
	int arr[];
	static String var = null;

	public static AvoidNull init() {
		return null;
	}

	String convert(String s) {
		return s.toUpperCase();
	}

	public static int getValue(String s) {
		if (s == null) {
			throw new IllegalArgumentException("Arguments can not be null");
		}
		return num;
	}

	public static void main(String[] args) {
//1.  create a null object1
//		AvoidNull dummy = AvoidNull.init(); 
//		System.out.println(dummy.convert("jtp"));
//2. modify or use the null object
//		AvoidNull dummy = AvoidNull.init(); 
//		System.out.println(dummy.num);
//3. passing null object to a method
//		AvoidNull dummy = new AvoidNull(); 
//		System.out.println(dummy.convert(null));
//4. try to operate on the array object which is null
//		AvoidNull dummy = new AvoidNull(); 
//		System.out.println(dummy.arr.length);
//5. try to synchronize over null object
//		synchronized(var) {
//			System.out.println("Synchronized block...");
//		}
//6. null String comparison
//		if (var.equals("JOSON")) {
//			System.out.println("Same string object...");
//		}
// To avoid null pointer exception
//1. Always using quoted string such as "JSON" first variable later
		if ("JSON".equals(var)) {
			System.out.println("Same string...");
		} else {
			System.out.println("They are different...");
		}
//2. using ternary operator
		String msg = (var == null) ? "null value" : var.concat("Huaxia");
		System.out.println(msg);

//3. checking arguments of the method at first thing to do in the method
		try {
			int x = getValue(null);
			System.out.println(x);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Done.");
	}
}
