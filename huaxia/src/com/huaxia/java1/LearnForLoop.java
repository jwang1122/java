package com.huaxia.java1;

public class LearnForLoop {

	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.println(i + ", " + j);
			}
		}
	}
}
/*
* 1
* 2 2
* 3 3 3
* 4 4 4 4
*/
