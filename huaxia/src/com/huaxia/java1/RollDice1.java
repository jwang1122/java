package com.huaxia.java1;

import java.util.Scanner;

public abstract class RollDice1 {
	abstract void todo();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int min = 1;
		int max = 6;
		boolean rollAgain = true;
		while (rollAgain) {
			System.out.println("Rolling the dices...");
			System.out.print("The values is: ");
			System.out.println((int) (Math.random() * max) + min);

			System.out.print("Roll the dice again? (y/n) ");
			String answer = input.nextLine();
			if (!answer.equalsIgnoreCase("y")) {
				rollAgain = false;
			}
		}
		input.close();
		System.out.println("Done.");
	}

}
