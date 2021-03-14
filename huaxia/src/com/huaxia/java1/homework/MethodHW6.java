package com.huaxia.java1.homework;

public class MethodHW6 {
	public static int sumDigits(long n) {
		int result = 0;
		
		while(n > 0) {
			result += n % 10;
			n /= 10;
		}
		
		return result;
	}
	public static void main(String[] args) {
		System.out.println(sumDigits(25));

	}

}
