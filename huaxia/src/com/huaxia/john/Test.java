package com.huaxia.john;

public class Test {

	public static void main(String[] args) {
//		ArrayTest test = new ArrayTest();
//		test.printTest();
//		Hello h = new Hello();
//		int c = h.add(12, 34);
		Math1 math = new Math1();
		int c = math.add(10, 20);
		try {
		c = math.div(10, 0);
		}catch(Exception e) {
			System.out.println("Error: " + e);
		}
		System.out.println(c);
		System.out.println("done.");
	}

}
