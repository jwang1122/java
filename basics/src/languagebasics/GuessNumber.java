package com.huaxia.java1;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner console = new Scanner(System.in);
		boolean again = true;
		while (again) {
			int myNumber = rand.nextInt(100) + 1;
			int number = 0;
			int runs = 0;
			while (number!=myNumber) {
				System.out.print("Please guess my number (1, 100) ");
				number = console.nextInt();
				runs++;
				if (number == myNumber) {
					System.out.println("You got it! Total of " + runs + " runs.");
					System.out.print("Do you want try again? (y/n) ");
					console.nextLine();
					String answer = console.nextLine().toLowerCase();
					if (!answer.equals("y")) {
						again = false;
						break;
					}
				} else if (number > myNumber) {
					System.out.println("Your number is higher, try lower number.");
				} else {
					System.out.println("Your number is lower, try higher number.");
				}
			}
		}
		console.close();
		System.out.println("Game over, Bye!");
	}
}
