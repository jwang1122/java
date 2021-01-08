package com.huaxia.apcomputer.exam1;

public class Question8 {

	public static void main(String[] args) {
		int n = 3; // make good guess by smallest number cover even and odd
		int count = 1;
		for (int i = 0; i < n; i += 2) { // 0, 2, 4, ...
//			if (i % 2 == 1) { // execute times will be affected by condition
			if (i < n) {
				/* perform some action */
				System.out.println(count++ + ":" + i);
			}
		}
		System.out.println("Execution times: " + (--count));
		System.out.println("Calculated execution times: " + (n + 1) / 2);
	}

}
