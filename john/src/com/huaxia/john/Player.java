package com.huaxia.john;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	protected ArrayList<Card> hand = new ArrayList<Card>();
	protected int winCount = 0;

	public void addCardToHand(Card temp) {
		hand.add(temp);
	}

	public void resetHand() {
		hand.clear();
	}

	public boolean hit() {
		int value = getHandValue();
		if(value <=10)
			return true;
		if(value>=20)
			return false;
		out.print("Do you want more card? (y/n) ");
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine().toLowerCase();
		input.close();
		return answer.equals("y");
	}

	public void setWinCount(int numWins) {
		this.winCount = numWins;
	}

	public int getWinCount() {
		return winCount;
	}

	public int getHandSize() {
		return hand.size();
	}

	public int getHandValue() {
		int value = 0;
		for(Card c:hand) {
			value += c.getValue();
		}
		return value;
	}

	public String toString() {
		return "hand = " + hand.toString() + " - # wins " + winCount;
	}

}
