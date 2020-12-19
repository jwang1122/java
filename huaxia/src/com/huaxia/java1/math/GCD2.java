package com.huaxia.java1.math;

public class GCD2 {

	static int gcd(int num1, int num2) {
        while (num1 != num2) {
        	if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
        return num2;
	}
	public static void main(String[] args) {
		int num1 = 55, num2 = 121;
		int gcd = gcd(num1, num2);
		System.out.printf("GCD of %d and %d is: %d", num1, num2, gcd);
	}

}
