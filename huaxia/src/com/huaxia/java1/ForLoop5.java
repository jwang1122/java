package com.huaxia.java1;
/*
 * break loop on condition
 */
public class ForLoop5 {

	public static void main(String[] args) {
		int b = 4;
		for (int i = 0; i < 10; i++) {
			if (i == b) {
				break;
			}
			System.out.println(i);
		}
		System.out.println("\nBye...");
	}

}
