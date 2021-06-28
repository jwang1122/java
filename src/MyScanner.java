package com.huaxia.java1;

import java.util.Scanner;

public class MyScanner {

	public static void main(String[] args) {
		Scanner inputFromConsole = new Scanner(System.in);
		System.out.print("Enter your data(firstName,lastName,age,id): ");
		String data = inputFromConsole.nextLine();
		inputFromConsole.close();

		String[] sa = data.split(",");
		String firstName = sa[0];
		String lastName = sa[1];
		int age = Integer.parseInt(sa[2]);
		age += 5;
		String id = sa[3];
		System.out.println(firstName+" " + lastName + " after 5 years will be " + age +" years old.");
	}

}
