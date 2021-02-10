package com.huaxia.ap2021.quizes;

public class Quiz1 {
	static String side1 = "Hello, world.";
	
	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		int a = 10;
		double b = 10.7;
//		int d = a + b;
//		int d = (int) a + b;   // (I)
//		int d = (int) (a + b); //(II)
		int d = a + (int) b; // (III)
	}

	private static void question2() {
		int a = 11;
		int b = 4;
		double x = 11;
		double y = 4;
		System.out.print(a / b);
		System.out.print(", ");
		System.out.print(x / y);
		System.out.print(", ");
		System.out.print(a / y);
		System.out.println();
	}

	private static void question3() {
		int val1 = 2, val2 = 22, val3 = 78; 
	    while (val2 % val1 == 0 || val2 % 3 == 0 ){
	        val3++; 
	        val2--; 
	    }
	    System.out.println(val3);
	}

	private static void question4() {
		System.out.print(1);
		System.out.print("1");
//		System.out.print(side1); // assume side1 is not defined any where else.
		System.out.print("side1");
	}

	private static void question5() {
		//This is a comment
	    /* This is a comment*/ 
	    // myName is a good identifier name 
	    // myname is a good identifier name 
	}

}
