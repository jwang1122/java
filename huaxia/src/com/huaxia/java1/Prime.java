package com.huaxia.java1;

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

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i=1; i<100; i++) {
			if (isPrime(i)) {
				list.add(i);
			}
		}
		System.out.println(list);

	}

}
