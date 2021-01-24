package com.huaxia.ap2021.section1;
/**
 * 
 * f1: downwards; f2: upwards; f3: Recursion call,
 *
 */
public class Question17 {

	public static int f1(int n) {
		int factorial = 1;
		for (int i = n; i > 0; i--) {
			factorial *= n;  // which variable involved in the calculation?
		}
		return factorial;
	}

	public static int f2(int n) {
		int factorial = 1;
		int j = 1;
		while (j <= n) {
			factorial *= j;
			j++;
		}
		return factorial;
	}

	public static int f3(int n) { // 1. can be stopped? 2. return a right value
		if (n == 1)
			return n;
		return n * f3(n - 1);
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(f1(n));
		System.out.println(f2(n));
		System.out.println(f3(n));
	}

}
