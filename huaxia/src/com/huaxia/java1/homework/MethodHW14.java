package com.huaxia.java1.homework;

import java.util.Scanner;

public class MethodHW14 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int n = input.nextInt();
		String s = String.format("The number %d is ", n);
		System.out.println(isPrime(n) ? s + "a prime." : s + "NOT a prime.");
		input.close();
	}

	public static boolean isPrime(int number) {
		boolean flag = true;
		if(number==1) return false;
		for (int i = 2; i <= number / 2; ++i) {
			if (number % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
