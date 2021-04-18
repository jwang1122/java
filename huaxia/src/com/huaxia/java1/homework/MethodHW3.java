package com.huaxia.java1.homework;

public class MethodHW3 {
	
	public static String middle(String str) {
		int position;
		int length;
		if (str.length() % 2 == 0) {
			position = str.length() / 2 - 1;
			length = 2;
		} else {
			position = str.length() / 2;
			length = 1;
		}
		return str.substring(position, position + length);
	}

	public static void main(String[] args) {
		System.out.println(middle("3501"));

	}

}
