package com.huaxia.ap2021.section1;

public class Question01_03 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
	}

	// precedence of /, %, + operators
	static void question1() {
		int x = 4 + 6 % 12/4;
		System.out.println(6%12/4);
		System.out.println(6%(12/4));
		System.out.println(x);		
	}
	
	// integer / integer return integer, truncate the decimal part.
	static void question2() {
		double x = (1.0 * 2.0) / (1.0 * 10);
		System.out.println("(A) " + x);		
		x = 2.0 / 10;
		System.out.println("(B) " + x);		
		x = (double) 2 / 10;
		System.out.println("(C) " + x);		
		x = (double)(2 / 10);
		System.out.println("(D) " + x);		
		x = Math.sqrt(4) / Math.sqrt(100);
		System.out.println("(E) " + x);		
	}
	
	// special character escape sequence \n, \t, \", \'
	static void question3(){
//		System.out.println(""Friends"");
//		System.out.println("//"Friends//"");
//		System.out.println("/"Friends/"");
		System.out.println("\"Friends\"");
//		System.out.println("\\"Friends\\"");
	}
}
