package com.huaxia.java1.math;

import java.util.List;
import java.util.ArrayList;

public class Prime {
	static boolean isPrime(int x) {
		boolean flag = true;
		for (int i = 2; i < x/2 +1; i++) {
			if (x % i == 0) {
				flag = false;
				break;
			}
		}
		return flag && x != 1;
	}

	static void findPrimeNumbersBetween(int n1, int n2) {
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

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i=1; i<50; i++) {
			if (isPrime(i)) {
				list.add(i);
			}
		}
		System.out.println(list);

		findPrimeNumbersBetween(40,50);
	}

}
