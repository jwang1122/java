package com.huaxia.java1.homework;

public class MethodHW7 {
	public static int getPentagonalNumber(int i) {
		return (i * (3 * i - 1)) / 2;
	}

	public static void main(String[] args) {
		int count = 1;
		for (int i = 1; i <= 50; i++) {
			System.out.printf("%-6d", getPentagonalNumber(i));
			if (count % 10 == 0)
				System.out.println();
			count++;
		}
	}

}
