package com.huaxia.ap2021.quizes;

public class Quiz16 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("question 1...");
		Tester test = new Tester();
		test.firstTestMethod();
		System.out.println();
	}

	private static void question2() {
		System.out.println("question 2...");
		Tester test = new Tester();
		test.secondTestMethod();
		;
		System.out.println();
	}

	private static void question3() {
		System.out.println("question 3...");
		int n = 7;
		int count = 1;
		for (int i = 0; i < n; i += 2) {
			if (n >= 0) // make condition always true
				/* perform some action */
				count++;
		}
		System.out.println(count);
	}

	private static void question4() {
		System.out.println("question 4...");
		System.out.println("(C) the specification shoud be modified.");
	}

	private static void question5() {
		System.out.println("question 5...");
		whatlslt(6, 5); // x<=y will cause stack overflow
	}

	public static int whatlslt(int x, int y) {
		if (x > y)
			return x * y;
		else
			return whatlslt(x - 1, y);
	}

}

class Tester {
	private int[] testArray = { 3, 4, 5 };

	// Add 1 to n.
	public void increment(int n) {
		n++;
	}

	public void firstTestMethod() {
		for (int i = 0; i < testArray.length; i++) {
			increment(testArray[i]);
			System.out.print(testArray[i] + " ");
		}
	}

	public void secondTestMethod() {
		for (int element : testArray) {
			increment(element);
			System.out.print(element + " ");
		}
	}
}
