package com.huaxia.test;

public class MathTest {

	public static void main(String[] args) {
		double x = Math.max(3 / 4., 5. / 8);
		System.out.println(x);
		x = Math.min(3 / 4., 5. / 8);
		System.out.println(x);
		x = Math.sqrt(81);
		System.out.println(x);
		x = Math.abs(-3.4);
		System.out.println(x);
		for (int i = 0; i < 10; i++) {
			int y = (int) (Math.random() * 101);
			System.out.println(y);
		}
	}

}
