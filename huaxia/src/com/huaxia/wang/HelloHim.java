package com.huaxia.wang;

import java.util.Scanner;

public class HelloHim {

	public static void main(String[] args) {
		System.out.print("Enter your name please: ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("Hello, " + name + "!");
		scanner.close();
	}

}
