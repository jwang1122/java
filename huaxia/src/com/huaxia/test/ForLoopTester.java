package com.huaxia.test;

import java.util.Random;
import java.util.ArrayList;

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
//		test.simpleFor();
//		test.stepBy2();
//		test.forEach();
//		test.breakOnCondition(4);
//		test.continueOnCondition(4);
//		System.out.println(test.prime(7));
		test.findPrimeNumbersBetween(40, 50);
//		test.findGCD(40, 50);
//		test.rollDices();
	}

	void findGCD(int n1, int n2) {
		int gcd = 1;
		int min = Math.min(n1, n2);
		for (int i = 1; i <= min; ++i) {
			// Checks if i is factor of both integers
			if (n1 % i == 0 && n2 % i == 0)
				gcd = i;
		}

		System.out.printf("GCD of %d and %d is %d", n1, n2, gcd);
	}

	/**
	 * Find prime numbers between n1 and n2. and output to console.
	 * 
	 * Homework: find number of prime numbers between n1 and n2.
	 * 
	 * @param n1
	 * @param n2
	 */
	private void findPrimeNumbersBetween(int n1, int n2) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = n1; i <= n2; i++) {
			if (prime(i)) {
				numbers.add(i);
			}
		}
		System.out.printf("The prime numbers between %d and %d are %s.\n", n1, n2, numbers);
	}

	/**
	 * return true if the input parameter x is a prime number, else false
	 * 
	 * @param x: input integer number
	 * 
	 * @return true if x is prime number, false otherwise.
	 */
	boolean prime(int x) {
		boolean flag = true;
		for (int i = 2; i < x / 2; i++) {
			if (x % i == 0) {
				flag = false;
				break;
			}
		}
		return flag && x != 1;
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

	/**
	 * 1. Two six-sided dice are rolled. 
	 * What is the probability that the numbers on the dice are different?
	 * 
	 * Explain: All set are 6*6=36, there are 6 equal, 30/36 are different. 
	 * 
	 * Answer: 30/36 = 5/6 = 0.83333333
	 * 
	 * Homework:
	 * Two six-sided dice are rolled. 
	 * What is the probability that the sum of the two dice is seven? 1/6
	 * What is the probability that the sum of the two dice is three? 1/18
	 */
	void rollDices() {
		int min = 1, max = 7, count = 0, tests = 1000000;
		Random rand = new Random();
		for (int i = 0; i < tests; i++) {
			int dice1 = rand.nextInt(max-min) + min; // return number between [min, max)
			int dice2 = rand.nextInt(max-min) + min;
			if(dice1!=dice2) count++;
		}
		System.out.printf("The probability is %f.",count/(float)tests);
	}
}
