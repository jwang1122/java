package com.huaxia.java1.loop;

public class While3 {

	public static void main(String[] args) {
		int i = 0;
		while (i < 10) {
			System.out.println(i);
			i++;
			if (i == 4) {
				break;
			}
		}
		System.out.println("\nBye...\n");
	}

}
