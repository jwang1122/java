package com.huaxia.ap2021.section1;

/**
 * 1. swap pointer doesn't change the content of String object.
 * 2. String object is immutable, which means once it is created, 
 * cannot be changed.
 * 
 * @author John
 *
 */
public class Question04 {

	public static void swap(String s1, String s2) { //
		String hold = s1;
		s1 = s2;
		s2 = hold;
	}
	
	public static void main(String[] args) {
		String s1 = "elephant";
		String s2 = "lion";
		swap(s1, s2);
		s1.toUpperCase();
		s2.toUpperCase();
		System.out.println(s1 + " " + s2);
	}

}
