package com.huaxia.test;

/**
 * for (statement 1; statement 2; statement 3) {
 *   // code block to be executed
 * }
 * statement 1: is executed one time before the execution of the code block
 * statement 2: defines the condition for executing the code block
 * statement 3: is executed every time after the code block has been executed
 * 
 * @author wang, qianjiang
 *
 */
public class ForLoopTester {

	public static void main(String[] args) {
		ForLoopTester test = new ForLoopTester();
		// test.simpleFor();
		// test.stepBy2();
		// test.forEach();
		// test.breakOnCondition(4);
		test.continueOnCondition(4);
	}

	/**
	 * i increased by 1 for every println statement.
	 */
	void simpleFor() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
	}

	void stepBy2() {
		for (int i = 0; i <= 10; i += 2) {
			System.out.println(i);
		}
	}

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
	}

	void breakOnCondition(int b) {
		for (int i = 0; i < 10; i++) {
			if (i == b) {
				break;
			}
			System.out.println(i);
		}
	}

	void continueOnCondition(int c) {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			if (i >= c && i <= c + 2) {
				sum += i;
				continue;
			}
			System.out.println(i);
		}
		System.out.println(sum);
	}
}
