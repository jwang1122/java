package com.huaxia.blackjack;

import java.util.*;

public class Player {
	private int winCount = 0;
	private ArrayList<Card> hand = new ArrayList<Card>();
	String name;

	Player() {

	}

	Player(String name) {
		this.name = name;
	}

	public void addCardToHand(Card temp) {
		hand.add(temp);

	}

	public void resetHand() {
		hand = new ArrayList<Card>();
	}

	public boolean hit() {
		int value = this.getHandValue();
		if (value >= 20)
			return false;
		if (value <= 10)
			return true;
		System.out.print("Do you want to hit?(y or n)");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return input.equals("y");
	}

	public void setWinCount(int numWins) {
		winCount = numWins;
	}

	public int getWinCount() {
		return winCount;
	}

	public int getHandSize() {
		return hand.size();
	}

	public int getHandValue() {
		int totalValue = 0;
		boolean containA = false;
		for (Card aCard : this.hand) {
			if(aCard.face=="A") {
				containA = true;
			}
			totalValue += aCard.getValue();
		}
		if(totalValue>21 && containA) {
			totalValue -= 10;
		}
		return totalValue;
	}

	public String toString() {
		return "hand = " + hand.toString() + " -  # wins " + winCount;
	}

}
