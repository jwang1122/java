package com.huaxia.java1;

public class HomeworkDemo {

	public static void main(String[] args) {
		// problem 1. simple straight way.
		System.out.println("01. 2020 - 20 = " + (2020 - 20));

		// problem 1. better way to use variables instead hard coded numbers
		int a = 2020;
		int b = 20;
		int c = a - b;
		String result = String.format("01: %d - %d = %d", a, b, c);
		System.out.println(result);

		// problem 1. better way use method which take care all sub() problems
		sub(a, b, 1);
		// problem 15.
		sub(681, 292, 15);

		// problem 2. better way to use method
		a = 498;
		b = 118;
		add(a, b, 2);

		// problem 3.
		String s = "1296";
		result = String.format("03: The tens digit of %s is %c", s, s.charAt(s.length() - 2));
		System.out.println(result);

		// problem 4. Simple way
		System.out.println(String.format("04: 60 / 5 = %d", 60 / 5));

		// problem 6.
		System.out.println("06. The remainder of 66 / 4 is " + (66 % 4));

		// problem 7.
		System.out.println("07. The product of 14 and 3 is " + (14 * 3));

		// problem 11.
		a = 1987;
		b = (a + 5) / 10 * 10;
		System.out.printf("11: %d rounded to the nearest ten is %d.", a, b);
		System.out.println();

		// problem 17. DCLXXVI in Arabic Numerals is
		int problem = 17;
		System.out.printf("%2d: I don't know how to do this problem.", problem);
		System.out.println();

		// problem 23. Greatest Common Divisor
		gcd(28, 21, 23);
		System.out.println();

		// problem 28.
		// Google Search: fraction java program
		// Search Result: How to work with Fractions in java
		// URL: https://codippa.com/how-to-work-with-fractions-in-java/
		Fraction frac1 = new Fraction(5, 8);
		Fraction frac2 = new Fraction(1, 24);
		Fraction frac3 = frac1.add(frac2);
		System.out.println(String.format("%2d: %s + %s = %s", 28, frac1, frac2, frac3));

		// problem 34. Least Common Multiple
		// Google Search: LCM java program
		// Search Result: Java Program to Find LCM of two Numbers
		// URL: https://www.programiz.com/java-programming/examples/lcm
		int n1 = 28, n2 = 21;
		int lcm = LCM.lcm(n1, n2);
		System.out.printf("%2d: The LCM of %d and %d is %d.", 34, n1, n2, lcm);
		System.out.println();

		// problem 36.
		System.out.print("36: The number of multiples of 5 between 11 and 51 are ");
		for (int i = 11; i <= 52; i++) {
			if (i % 5 == 0) {
				System.out.print(i + "; ");
			}
		}
		System.out.println();

		// problem 38.
		int count = 0;
		for (int i = 40; i <= 50; i++) {
			boolean flag = true;
			// check each number for i%j == 0 (not a prime)
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) // find a prime number, increase the count by 1
				count++;
		}
		System.out.println("38: THe number of prime numbers that are between 40 and 50 is " + count);
		
		// problem 40.
		double d = Math.pow(511111., 1/3.);
		System.out.println("40: (estimate) (511111)^(1/3) = " + d);
		System.out.printf("40: (prove) %f^3 = %f", d, d*d*d);
		System.out.println("\nDone.");
	}

	static void add(int a, int b, int problem) {
		int c = a + b;
		String result = String.format("%02d: %d + %d = %d", problem, a, b, c);
		System.out.println(result);
	}

	static void sub(int a, int b, int problem) {
		int c = a - b;
		String result = String.format("%02d: %d - %d = %d", problem, a, b, c);
		System.out.println(result);
	}

	// GCD: Greatest Common Divisor
	static void gcd(int a, int b, int problem) {
		int gcd = 1;
		int min = Math.min(a, b);
		for (int i = 1; i <= min; ++i) {
			// Checks if i is factor of both integers
			if (a % i == 0 && b % i == 0)
				gcd = i;
		}

		System.out.printf("%2d: GCD of %d and %d is %d", problem, a, b, gcd);
	}

}
