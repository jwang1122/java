package com.huaxia.java1.loop;

import java.util.Random;
import java.util.Scanner;

public class While6 {

	public static void main(String[] args) {
		int min = 1;
		int max = 7;
		boolean roll_again = true;
		while (roll_again) {
			System.out.println("Rolling the dices...");
			Random rand = new Random();
			System.out.println("The values is " + (rand.nextInt(max - min) + min));
			System.out.print("Rolling again? (y/n) ");
			Scanner input = new Scanner(System.in);
			String answer = input.nextLine();
			if(!answer.equals("y")) {
//			if (answer != "y") { // answer is a String object variable not assign as constant
				input.close();
				roll_again = false;
			}
		}
		System.out.println("\nGame Over!");
	}

}
