package com.huaxia.ap2021.section1;

public class Question13 {

	public static void main(String[] args) {
		int x = 0;
		for (int j = 1; j < 4; j++) {
			if (x != 0 && j / x > 0)
				System.out.print(j / x + " ");
			else
				System.out.print(j * x + " ");
		}
	}

}
