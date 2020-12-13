package com.huaxia.learnrxjava;

public class DividedByZero {

	static double divide(double x, double y) {
		return x/y;
	}
	
	static String toUpperCase(String s) {
		return s.toUpperCase();
	}
	
	public static void main(String[] args) {
		System.out.println(divide(10.0,5.0));
		System.out.println(divide(10.0,0.0));
		
		System.out.println(toUpperCase("this is a test."));
		System.out.println(toUpperCase(null));
		
		System.out.println("Done.");
	}

}
