package com.huaxia.java1.homework;

import java.util.Scanner;

public class MethodHW10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Input a year: ");
		int year = in.nextInt();
		
		String output = is_LeapYear(year)?"is":"is Not";
		System.out.printf("The %d %s a leap year.",year, output);
	}

	public static boolean is_LeapYear(int y) {
		boolean a = (y % 4) == 0;
		boolean b = (y % 100) != 0;
		boolean c = ((y % 100 == 0) && (y % 400 == 0));

		return a && (b || c);
	}
}
