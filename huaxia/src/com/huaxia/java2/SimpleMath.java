package com.huaxia.java2;

import java.util.Random;
import java.util.Scanner;

import javax.sound.midi.InvalidMidiDataException;

public class SimpleMath {
	public int add(int x, int y) {
		return x + y;
	}
	public int sub(int x, int y) {
		return 0;
	}
	public int mul(int x, int y) {
		return 0;
	}
	public int div(int x, int y) {
		return 0;
	}
	public static double add(double x, double y) {
		return x + y;
	}

	static void doMath() {
		double x = SimpleMath.add(3.4, 4.1); // static way to call add()
		System.out.println(x);
	}

	static void generateRandomNumber4Dice() {
		Random rand = new Random();
		for (int j = 0; j < 20; j++) {
			int i = rand.nextInt(6) + 1; // build dice, [0,6)==> [1, 6]
			System.out.print(i + ", ");
		}
	}

	// Homework: make two players against each other
	static void throw2Dices() { // build a real game, get name from players, take turn until user terminate the game. Hint: while(true){}
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		System.out.print("John's turn: ");
		input.nextLine();
		int dice1 = rand.nextInt(6) + 1;
		int dice2 = rand.nextInt(6) + 1;
		System.out.println(dice1 + "," + dice2 + "=" + (dice1 + dice2));

		System.out.print("Connor's turn: ");
		input.nextLine();
		int dice3 = rand.nextInt(6) + 1;
		int dice4 = rand.nextInt(6) + 1;
		System.out.println(dice3 + "," + dice4 + "=" + (dice3 + dice4));

		int john = dice1 + dice2;
		int connor = dice3 + dice4;
		if (john > connor) {
			System.out.println("John wins.");
		} else if (john < connor) {
			System.out.println("Connor wins.");
		} else {
			System.out.println("Game tied up.");
		}
		input.close();
		System.out.println("Game over.");
	}

	// none static method
	//Prime numbers are numbers that have only 2 factors: 1 and themselves. 
	boolean isPrime(int n) {
		boolean result = true;
		for(int i=2; i<n; i++) {
			if(n%i==0) {
				result = false;	
				break;
			}
		}
		return n!=1 && result;
	}
	
	double circleArea(double r) throws InvalidMidiDataException { // re-throw the Exception
//		String s = null;
//		s.substring(1,4);
		if(r<0) {
			throw new InvalidMidiDataException("Radius of circle cannot be negative. r=" + r);
		}
		return Math.PI * r * r;
	}
	
}
