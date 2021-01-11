package com.huaxia.ap2021.section1;

/**
 * use debug help yourself understand recursion process
 * 2. what is each call effect. //add each digit together.
 *
 */
public class Question39 {

	public static int f (int n) {
		if (n==0)
			return 0;
		else 
			return f(n/10)+ n % 10; // each call will change n to n/10			
	}
	public static void main(String[] args) {
		System.out.println(f(8765)) ;
	}
}
