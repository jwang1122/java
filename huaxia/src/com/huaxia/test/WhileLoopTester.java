package com.huaxia.test;

import java.util.Random;
import java.util.Scanner;

/**
 * while (condition){ 
 *     //code block to be executed 
 * }
 *
 */
public class WhileLoopTester {

	public static void main(String[] args) {
		WhileLoopTester test = new WhileLoopTester();
//		int i = 0;
//		test.whileTest(i);
//		test.doWhileTest(i);
//		test.breakOnCondition(4);
//		test.continueOnCondition(4);
		test.dice();
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

	/**
	 * Test break in while loop
	 * 
	 * @param i
	 */
	void breakOnCondition(int i) {
		while (i < 10) {
			System.out.println(i);
			i++;
			if (i == 4) {
				break;
			}
		}
	}

	/**
	 * Test continue in while loop
	 */
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
	
	void dice() {
		int min = 1;
		int max = 7;
		boolean roll_again = true;
		while (roll_again) {
			System.out.println("Rolling the dices...");
			Random rand = new Random();
			System.out.println("The values is " + (rand.nextInt(max-min) + min));
			System.out.print("Rolling again? (y/n) ");
			Scanner input = new Scanner(System.in);
			String answer = input.nextLine();
			if(!answer.equals("y")) {
				input.close();
				roll_again = false;
			}
		}
		System.out.println("Game Over!");
	}
}
