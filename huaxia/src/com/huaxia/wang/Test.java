package com.huaxia.wang;

public class Test {

	public static void main(String[] args) {
//		ArrayTest test = new ArrayTest();
//		test.printTest();
//		Hello h = new Hello();
//		int c = h.add(12, 34);
		Math1 math = new Math1();
		int c = math.add(10, 20);
		System.out.printf("10 + 20 = %d\n",c);
		try {
			int x = 10;
			int y = 2;
			c = math.div(x, y);
			System.out.printf("%d / %d = %d\n",x, y, c);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		System.out.println("done.");
	}

}
