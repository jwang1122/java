package com.huaxia.java1.homework;

public class LoopHW3 {

	public static void main(String[] args) {
		int n = 6;
		int fact = 1;
		for(int i=1; i<=n; i++) {
			fact *= i;
		}
		System.out.printf("The factorial of %d is: %d\n", n, fact);
	}

}
