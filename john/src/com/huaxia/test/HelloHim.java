package com.huaxia.test;

import java.util.Scanner;

public class HelloHim {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("enter your name: ");
		String name = input.nextLine();
		System.out.println("Hello, " + name + "!");
		input.close();
	}

}