package com.john.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
	protected String name;
	protected int winCount;
	protected List<Card> hand = new ArrayList<>();
	protected int total;
	
	protected Player() {
		
	}
	
	public Player(String name) {
		this.name = name;
	}

	public void addCardToHand(Card card) {
		hand.add(card);
	}

	public void cleanHand() {
		hand.clear();
	}

	public int getHandValue() {
		int value = 0, aceCount=0;
		for (Card card : hand) {
			value += card.getValue();
			if (card.getFace() == Face.ACE)
				aceCount++;
		}
		while (value > 21 && aceCount > 0) {
			value -= 10;
			aceCount--;
		}
		return value;
	}
	
	public boolean hit() {
		int value = getHandValue();
		if(value>=20) {
			return false;
		}		
		String answer = Game.ask(name + ", do you want another card? (y/n) ");
		if (answer.equalsIgnoreCase("y"))
			return true;
		return false;
	}
	
	public String showHand() {
		return String.format("%10s: %s:%d:%d", name, hand, getHandValue(), winCount);
	}

	public void win() {
		winCount++;
	}
}
