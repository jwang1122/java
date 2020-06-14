package com.huaxia.test;

/**
 * while (condition){ 
 *     //code block to be executed 
 * }
 *
 */
public class WhileLoopTester {

	public static void main(String[] args) {
		WhileLoopTester test = new WhileLoopTester();
		int i = 0;
		// test.whileTest(i);
		// test.doWhileTest(i);
		// test.breakOnCondition(4);
		test.continueOnCondition(4);
	}

	void whileTest(int i) {
		while (i < 5) {
			System.out.println("whileTest: " + i);
			i++;
		}

	}

	/**
	 * do-while will do at least once, change i>= 5 will approve it.
	 * 
	 * @param i
	 */
	void doWhileTest(int i) {
		do {
			System.out.println("doWhileTest: " + i);
			i++;
		} while (i < 5);
	}

	void breakOnCondition(int i) {
		while (i < 10) {
			System.out.println(i);
			i++;
			if (i == 4) {
				break;
			}
		}
	}

	void continueOnCondition(int i) {
		while (i < 10) {
			if (i == 4) {
				i++;
				continue;
			}
			System.out.println(i);
			i++;
		}
	}
}
