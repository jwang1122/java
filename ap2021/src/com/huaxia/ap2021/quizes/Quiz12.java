package com.huaxia.ap2021.quizes;

public class Quiz12 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("question 1...");
		int r = 22;
		System.out.println(r * r * Math.PI);
		double r1 = 22;
		System.out.println(r1 * r1 * Math.PI);
		System.out.println((double) r * r * Math.PI);
		System.out.println((double) (r * r) * Math.PI);
	}

	private static void question2() {
		System.out.println("question 2...");
		String s = "This is the beginning";
		String t = s.substring(5);
		int n = t.indexOf("the");
		System.out.println(n);
	}

	private static void question3() {
		System.out.println("question 3...");
		Chair c =new Chair (true);
//		c.sit();
//		if (c.padded) System.out.print ("You are sitting.");
	}

	private static void question4() {
		System.out.println("question 4...");
		//getter/setter = accessor/mutator
		System.out.println("(B) add getPadded() method.");
	}

	private static void question5() {
		System.out.println("question 5...");
		System.out.println(halfRoot(-2));
		System.out.println(halfRoot(3));
		System.out.println(halfRoot((int) 2.0));
//		System.out.println(halfRoot(3.0));

	}

	public static double halfRoot(int n) {
		return Math.sqrt(n) / 2;
	}

	public static boolean sitOnChair() {
		/* program statements */
		Chair c =new Chair (true);
		return c.isPadded();
	}

}

class Chair {
	private int numberOfLegs = 4;
	private boolean padded;

	public boolean isPadded() {
		return padded;
	}

	public Chair(boolean soft) {
		if (soft)
			padded = true;
		else
			padded = false;
	}
}
