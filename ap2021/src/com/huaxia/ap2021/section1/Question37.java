package com.huaxia.ap2021.section1;

public class Question37 {

	public double pow (double b, int x) {
		if (x==1) 
			return b; 
		else
//			return b + pow(b, x-1);
			return b * pow(b, x-1);
	}
	public static void main(String[] args) {
		Question37 test = new Question37();
		System.out.println(test.pow(2, 2));
		System.out.println(test.pow(2, 1));
//		System.out.println(test.pow(2, 0));
	}

}
