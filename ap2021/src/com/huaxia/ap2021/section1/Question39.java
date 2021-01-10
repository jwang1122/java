package com.huaxia.ap2021.section1;

public class Question39 {

	public static int f (int n) {
		if (n==0)
			return 0;
		else 
			return f(n/10)+ n % 10; 
			
	}
	public static void main(String[] args) {
		System.out.println(f(8765)) ;
	}

}
