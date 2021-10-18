package com.huaxia.java2.card;

import java.util.ArrayList;
import java.util.List;

public class Player {
	protected String name;
	protected List<Card> hand = new ArrayList<>();
	protected int winCount = 0;
	protected int total;
	
	public Player() {
		
	}
	
	public Player(String name) {
		this.name = name;		
	}
	
	public void win() {
		winCount++;
	}

	public void addCardToHand(Card card) {
		hand.add(card);
	}
	
	public void cleanHand() {
		hand.clear();
	}
	
	public String showHand() {
		return String.format("%s: %s-%d(win=%d)", name, hand, getHandValue(), winCount);
	}
	
	public int getHandValue() {
		int value = 0;
		for(Card card:hand) {
			value += card.getValue();
		}
		int aCount = countAce();
		while(value>21 && aCount>0) {
			value -=10;
			aCount--;
		}
		return value;
	}
	
	private int countAce() {
		int c = 0;
		for(Card card: hand) {
			if(card.getFace()==Face.ACE) {
				c++;
			}
		}
		return c;
	}

	public boolean hit() {
		int value = getHandValue();
		if(value>=20) return false;
		System.out.print(name+", do you want another card? (y/n) ");
		String answer = Deck.input.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return true;
		}		
		return false;
	}
	
	@Override
	public String toString() {
		return "Player: " + name;
	}
	
	
}
