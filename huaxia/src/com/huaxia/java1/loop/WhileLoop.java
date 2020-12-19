package com.huaxia.java1;

import java.util.Random;
import java.util.Scanner;

/**
 * while (condition){ 
 *     //code block to be executed 
 * }
 *
 */
public class WhileLoop1 {

	public static void main(String[] args) {
		WhileLoop1 test = new WhileLoop1();
		int i = 0; // change to i=6
		test.whileTest(i);
//		test.doWhileTest(i);
//		test.breakOnCondition(4);
//		test.continueOnCondition(4);
//		test.dice();
//		test.infiniteLoop();
	}

	void infiniteLoop() {
		Scanner console = new Scanner(System.in);
		int i = 0;
		while (true) {
			System.out.print(++i + ": Do you want to continue? (y/n) ");
			String answer = console.nextLine().toLowerCase();
			if (!answer.equals("y"))
				break;
		}
		System.out.println("Bye...");
		console.close();
	}

	/**
	 * Demo the difference between ++i and i++
	 * 
	 * @param i
	 */
	void whileTest(int i) {
		while (i < 5) {
			System.out.println("whileTest: " + ++i);
		}
		System.out.println("\nBye...\n");
	}

	/**
	 * do-while will do at least once, change i>= 5 will approve it.
	 * 
	 * Demo the difference between ++i and i++
	 * 
	 * @param i
	 */
	void doWhileTest(int i) {
		do {
			System.out.println("doWhileTest: " + i++);
		} while (i < 5);
		System.out.println("\nBye...\n");
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
		System.out.println("\nBye...\n");
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
		System.out.println("\nBye...\n");
	}

	void dice() {
		int min = 1;
		int max = 7;
		boolean roll_again = true;
		while (roll_again) {
			System.out.println("Rolling the dices...");
			Random rand = new Random();
			System.out.println("The values is " + (rand.nextInt(max - min) + min));
			System.out.print("Rolling again? (y/n) ");
			Scanner input = new Scanner(System.in);
			String answer = input.nextLine();
			if(!answer.equals("y")) {
//			if (answer != "y") { // answer is a String object variable not assign as constant
				input.close();
				roll_again = false;
			}
		}
		System.out.println("\nGame Over!");
	}
}
