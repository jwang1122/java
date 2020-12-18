package com.huaxia.java1;
/*
 * Nested for loop
 */
public class ForLoop12 {

	public static void main(String[] args) {
		ForLoop12 test = new ForLoop12();
		test.rightTriangle();
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

}
