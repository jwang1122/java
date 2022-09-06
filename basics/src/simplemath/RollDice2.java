package simplemath;

import java.util.Scanner;

public class RollDice2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean rollAgain = true;
		while (rollAgain) {
			System.out.println("Rolling the dices...");
			System.out.print("The values is: ");
			System.out.println(getRandomNumber(1, 6));

			System.out.print("Roll the dice again? (y/n) ");
			String answer = input.nextLine();
			if (!answer.equalsIgnoreCase("y")) {
				rollAgain = false;
			}
		}
		input.close();
		System.out.println("Done.");
	}

	static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * max) + min;
	}

}
