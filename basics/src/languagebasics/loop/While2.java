package com.huaxia.java1.loop;

import java.util.Scanner;

public class While2 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int i = 0;
		while (true) {
			System.out.print(++i + ": Do you want to continue? (y/n) ");
			String answer = console.nextLine().toLowerCase();
			if (!answer.equals("y"))
				break;
		}
		System.out.println("Bye...");
		console.close();
	}

}
