package com.huaxia.java1.homework;

import java.util.Scanner;

public class LoopHW8 {
	static int factorial(int num) {
		int result = 1;
		for(int i=1; i<=num; i++)
			result *= i;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int num;

		System.out.print("Enter any positive integer: ");
		num = console.nextInt();
		double result = 0.0;
		for(int i=0; i<num; i++) {
			result += 1.0/factorial(i);
		}
		System.out.println("The Euler's constant is " + result + ".");


		console.close();
	}
}
