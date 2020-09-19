package com.huaxia.john;

public class Homework3 {

	public static void main(String[] args) {
		Homework3 hw3 = new Homework3();
		hw3.rightTriangle();

	}
	void rightTriangle() {
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
