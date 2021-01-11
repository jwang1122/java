package com.huaxia.ap2021.iteration;

public class IteratorTest {

	public static void main(String[] args) {
		int n = 3; // some integer greater than zero
		count(n);
		System.out.println(n*(n-1));
	}

	static void count(int n) {
		int count = 0;
		int p = 0;
		int q = 0;
		for (p=1; p<n; p++)
			for(q=1; q<=n; q++)
				count++;
		System.out.println(count);
		
	}
}
