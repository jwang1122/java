package com.huaxia.java1;

public class Print {

	public static void main(String[] args) {
		Print test = new Print();
//		test.basicPrint();
//		test.rightTriangle();
//		test.equilateralTriangle();
//		test.upsideDownTriangle();
//		test.diamond();
		test.diamond(8);
	}

	/**
	 * if i = 8, your output should look like below
	 *       1
	 *      2 2
	 *     3 3 3
	 *    4 4 4 4
	 *   5 5 5 5 5
	 *  6 6 6 6 6 6 
	 * 7 7 7 7 7 7 7
	 *  6 6 6 6 6 6
	 *   5 5 5 5 5
	 *    4 4 4 4
	 *     3 3 3
	 *      2 2
	 *       1
	 * @param i
	 */
	private void diamond(int i) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Learn nested for loop, demo in class
	 * 1
	 * 2 2
	 * 3 3 3
	 * 4 4 4 4
	 */
	void rightTriangle() {
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Homework
	 *     1
	 *    2 2
	 *   3 3 3
	 *  4 4 4 4 
	 */
	void equilateralTriangle() {
		for (int i = 1; i < 5; i++) {
			for (int k = 5; k > i; k--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Homework
	 *   3 3 3 
	 *    2 2 
	 *     1 
	 */
	void upsideDownTriangle() {
		for (int i = 3; i > 0; i--) {
			System.out.print(" ");
			for (int k = 4; k > i; k--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Homework
	 *     1 
     *    2 2 
     *   3 3 3 
     *  4 4 4 4 
     *   3 3 3 
     *    2 2 
     *     1 
	 */
	void diamond() {
		equilateralTriangle();
		upsideDownTriangle();
	}

	void basicPrint() {
		String name = "John";
		String sf1 = String.format("name is %s.", name);
		String sf2 = String.format("value is %f.", 3.1415926);
		String sf3 = String.format("value is %5.3f.", 3.1415926);
		System.out.println(sf1);
		System.out.println(sf2);
		System.out.println(sf3);
		System.out.println("2020-20=" + (2020 - 20));// bad practice, hardcode everything!
		int a = 2040;
		int b = 20;
		sf1 = String.format("2020-20=%d", (2020 - 20));
		System.out.println(sf1);
		sf1 = String.format("%d-%d=%d", a, b, (a - b));
		System.out.println(sf1);
		System.out.printf("%d-%d=%d", a,b,(a-b));
		System.out.println();
	}

}
