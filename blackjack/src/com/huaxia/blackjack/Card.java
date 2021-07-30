package com.huaxia.blackjack1;

public class Card {
	protected String face;
	protected String suit;
	
	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}
	
	public Card() {
		
	}
	
	public boolean isPictured() {
		return "AJQK".contains(face);
	}
	
	public int getValue() {
		int value = 0;
		if(!isPictured()) {
			return Integer.parseInt(face);
		}
		switch(face) {
		case "A": value=1; break;
		case "J": value=11; break;
		case "Q": value=12; break;
		case "K": value=13; break;
		}
		return value;
	}

	public String getFace() {
		return face;
	}

	@Override
	public String toString() {
		return "[" + face + ", " + suit + "]";
	}
	
	
}
