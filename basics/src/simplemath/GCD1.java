package com.huaxia.java1.math;
/*
 * GCD: Greatest Common Divisor
 */
public class GCD1 {
	/* loop is running from 1 to the smallest of both numbers
	 * In this example the loop will run from 1 to 55 because 55
	 * is the smaller number. All the numbers from 1 to 55 will be 
	 * checked. A number that perfectly divides both numbers would
	 * be stored in variable "gcd". By doing this, at the end, the 
	 * variable gcd will have the largest number that divides both
	 * numbers without remainder.
	 */
	static int gcd(int num1, int num2) {
		int gcd = 1;
		for (int i = 1; i <= num1 && i <= num2; i++) {
			if (num1 % i == 0 && num2 % i == 0)
				gcd = i;
		}
		return gcd;
	}
	
	public static void main(String[] args) {
		
		// Lets take two numbers 55 and 121 and find their GCD
		int num1 = 55, num2 = 121;
		int gcd = gcd(num1, num2);

		System.out.printf("GCD of %d and %d is: %d", num1, num2, gcd);
	}

}
