package com.huaxia.java1;

public class MainMethodTest {

	public static void main(String[] args) {
		System.out.println("MainMethodTest.main()...");
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		System.out.println("Done.");
	}
}
