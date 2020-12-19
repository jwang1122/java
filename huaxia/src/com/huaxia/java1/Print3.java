package com.huaxia.java1;

public class print3 {

	public static void main(String[] args) {
//		test.equilateralTriangle();
//		test.upsideDownTriangle();
//		test.diamond();
//		test.diamond(8);
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
	public void diamond(int i) {
		// TODO Auto-generated method stub
		
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

}
