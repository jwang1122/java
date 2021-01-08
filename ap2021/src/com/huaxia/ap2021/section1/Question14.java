package com.huaxia.ap2021.section1;

public class Question14 {

	public static void main(String[] args) {
		String space = " ";
		String symbol = "*";
		int num = 5;
		for (int i = 1; i <= num; i++) {
			System.out.print(symbol);
		}
		System.out.println();
		for (int i = 1; i <= num; i++) {
			for (int j = num - i; j > 0; j--) {
				System.out.print(space);
			}
			System.out.println(symbol);
		}
		for (int i = 1; i <= num; i++) {
			System.out.print(symbol);
		}
	}

}
