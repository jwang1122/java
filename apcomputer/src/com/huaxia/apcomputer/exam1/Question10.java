package com.huaxia.apcomputer.exam1;

public class Question10 {

	public static int whatIsIt(int x, int y) {
		if (x > y)
			return x * y;
		else
			return whatIsIt(x - 1, y);
	}

	public static void main(String[] args) {
//		System.out.println(whatIsIt(6, 10)); // x < y
//		System.out.println(whatIsIt(6, 6));  // x == y
		System.out.println(whatIsIt(10, 6)); // x > y

	}

}
