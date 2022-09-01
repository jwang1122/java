package com.huaxia.java1;

public class OperatorTest {

	public static void main(String[] args) {
		OperatorTest test = new OperatorTest();
		test.mathOperator();
//		test.doubleOperator();
//		test.comparisionOperator();
//		test.logicOperator();
//		test.ternaryOperator(12);
	}

	void ternaryOperator(int x) {
		String result = (x % 2 == 0) ? String.format("%d is enven number.",x) : String.format("%d is odd number.", x);
		System.out.println(result);
	}

	void mathOperator() {
		double x = 100 + 50;
		System.out.println(x);
		x = 100 - 3;
		System.out.println(x);
		x = 24 * 12;
		System.out.println(x);
		x = (13.0 / 12);
		System.out.println(x);
		x = 13 % 12;
		System.out.println(x);
	}

	void compoundOperator() {
		int i = 5;
		System.out.println(++i);
		i--;
		System.out.println("30: " + --i);
		System.out.println("31: " + i--);
		System.out.println(i);
		i += 10; // i = i + 10
		System.out.println(i);
		// Try yourself in class
		// +=; -=; *=; /=; %=;
	}

	void comparisionOperator() {
		/*
		 * ==; Equal to !=; Not equal >; Greater than <; Less than >=; Greater than or
		 * equal to <=; Less than or equal to
		 */
		int a = 5;
		int b = 5;
		if (a == b) {
			System.out.println("a is equal to b.");
		}
		String s1 = "John";
		String s2 = "John";
		System.out.println(s1 == s2);
		// Try others comparison operator by yourself in class
	}

	void logicOperator() {
		/*
		 * &&; logical and ||; logical or !; logical not
		 */
		int x = 5;
		if ((x > 3) && (x < 10)) {
			System.out.println(x);
		}

		if (x > 3 || x < 4) {
			System.out.println(x);
		}
		// try ! in class
		System.out.println(! (x<3));
	}
}
