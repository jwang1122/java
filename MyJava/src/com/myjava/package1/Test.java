package com.myjava.package1;

public class Test {

	/**
	 * Use the for loop to print the following pattern 
	 * 1 
	 * 2 2 
	 * 3 3 3 
	 * 4 4 4 4
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello world.");
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
