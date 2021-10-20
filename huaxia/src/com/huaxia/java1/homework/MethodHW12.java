package com.huaxia.java1.homework;

import java.util.Scanner;

public class MethodHW12 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Input a number: ");
		int n = in.nextInt();
		printMatrix(n);
		in.close();
	}

	public static void printMatrix(int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print((int) (Math.random() * 2) + " ");
			}
			System.out.println();
		}
	}
}
