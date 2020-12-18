package com.huaxia.java1;

public class SimpleMath {
	
	public static void main(String[] args) {
		SimpleMath test = new SimpleMath();
		int sum = test.add(10, 34);
		System.out.println(sum);

	}
	
	int add(int x, int y) {
		return x+y;
	}

	int sub(int x, int y) {
		return x-y;
	}

	int mul(int x, int y) {
		return x*y;
	}

	int div(int x, int y) {
		return x/y;
	}
}
