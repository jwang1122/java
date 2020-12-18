package com.huaxia.java1;

public class ForLoop4 {
	/**
	 * for (type variableName : arrayName) {
	 *    // code block to be executed
	 * }
	 */
	void forEach() {
		String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
		for (String i : cars) {
			System.out.println(i);
		}
		System.out.println("\nBye...");
		
	}

	public static void main(String[] args) {
		ForLoop4 test = new ForLoop4();
		test.forEach();

	}

}
