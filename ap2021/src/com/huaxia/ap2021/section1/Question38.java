package com.huaxia.ap2021.section1;

public class Question38 {
	public double pow(double b, int x) {
//		if (x == 0)
//			return 0;
//		if (x == 1) // blows up
//			return 1;
		if (x == 1)
			return b;
		else
			return b + pow(b, x - 1); // wrong calculation
	}

	public static void main(String[] args) {
		Question38 test = new Question38();
		System.out.println(test.pow(2, 2));
		System.out.println(test.pow(2, 3));
//		System.out.println(test.pow(2, 0)); // if(x==0) return 0
		System.out.println(test.pow(2, 1));

	}

}
