package com.huaxia.java1.homework;

/**
 * https://en.wikipedia.org/wiki/E_(mathematical_constant)
 * 
 * @author John
 *
 */
public class LoopHW3 {
	// Euler's number 1/(n!)
	
	static long factorial(int n) {
		long result = 1;
		for(int i=1; i<=n; i++) {
			result *= i;
		}
		return result;
	}
	
	static double eulerNumber(int n) {
		double result = 0;
		for(int i = 0; i<=n; i++) {
			result += 1.0/factorial(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int n =  20;
		System.out.printf("The factorial of %d is: %d\n", n, factorial(n));
		System.out.println(eulerNumber(n));
	}

}
