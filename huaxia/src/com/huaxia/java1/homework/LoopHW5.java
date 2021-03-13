package com.huaxia.java1.homework;

import java.util.Scanner;

public class LoopHW5 {

	static String reverse(String s) {
		String r = "";
		for (int i=s.length()-1; i>-1; i--) {
			r += s.charAt(i);
		}
		return r;
	}
	
	static String reverse(String s, boolean b) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a word: ");
		String s = input.nextLine();
		String r = reverse(s);
		System.out.println(r);
		
		System.out.println(reverse(s, true));
		input.close();
	}

}
