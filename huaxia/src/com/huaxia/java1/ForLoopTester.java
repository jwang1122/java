package com.huaxia.java1;

import java.util.Random;
import java.util.Scanner;
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
		test.simpleFor();
//		test.stepBy2();
//		test.stepByNeigative2();
//		test.forEach();
//		test.breakOnCondition(4);
//		test.continueOnCondition(4);
//		boolean b = test.isPrime(17);
//		b = test.isPrime(8);
//		test.findPrimeNumbersBetween(40, 50);
//		test.findGCD(40, 50);
//		test.rollDices();
//		test.infiniteLoop();
	}

	void infiniteLoop() {
		Scanner console = new Scanner(System.in);
		for (int i=1;;i++) {
			System.out.print(i + ": Do you want to continue? (y/n) ");
			String answer = console.nextLine().toLowerCase();
			if(!answer.equals("y"))
				break;
		}
		System.out.println("Bye...");
		console.close();
	}

	/**
	 * Demo statement 3 can do something else.
	 */
	void stepByNeigative2() {
		for (int i = 12, n = 0; i >= 0; i -= 2, n = i * i) {
			System.out.println(n);
		}
		System.out.println("Bye...");
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
		System.out.println("\nBye...");

	}

	/**
	 * Find prime numbers between n1 and n2. and output to console.
	 * 
	 * Homework: find number of prime numbers between n1 and n2.
	 * 
	 * @param n1
	 * @param n2
	 */
	void findPrimeNumbersBetween(int n1, int n2) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = n1; i <= n2; i++) {
			if (isPrime(i)) {
				numbers.add(i);
			}
		}
		System.out.printf("The prime numbers between %d and %d are %s.\n", n1, n2, numbers);
		System.out.printf("The number of prime numbers between %d and %d is %d.\n", n1, n2, numbers.size());
		System.out.println("\nBye...");
	}

	/**
	 * The prime numbers are the natural numbers greater than one 
	 * that are not products of two smaller natural numbers.
	 * 
	 * Positive integer greater than 1 with exactly two divisors, 1 and itself.
	 * 
	 * return true if the input parameter x is a prime number, else false
	 * 
	 * @param x: input integer number
	 * 
	 * @return true if x is prime number, false otherwise.
	 */
	boolean isPrime(int x) {
		boolean flag = true;
		for (int i = 2; i < x/2 +1; i++) {
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
		System.out.println("\nBye...");
	}

	void stepBy2() {
		for (int i = 0; i <= 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("\nBye...");
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
		System.out.println("\nBye...");
	}

	void breakOnCondition(int b) {
		for (int i = 0; i < 10; i++) {
			if (i == b) {
				break;
			}
			System.out.println(i);
		}
		System.out.println("\nBye...");
	}

	/**
	 * make code change print every i, do not skip 4-6
	 * 
	 * @param c
	 */
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
		System.out.println("\nBye...");
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
		int min = 1, max = 7, count = 0, tests = 10000;
		Random rand = new Random();
		for (int i = 0; i < tests; i++) {
			int dice1 = rand.nextInt(max - min) + min; // return number between [min, max)
			int dice2 = rand.nextInt(max - min) + min;
			if (dice1 != dice2)
				count++;
		}
		System.out.printf("The probability is %f.", count / (float) tests);
		System.out.println("\nBye...");
	}
}
