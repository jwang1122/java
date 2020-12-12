package com.wang.blackjack;

public class Card {
	public static final String FACES[] = { "ZERO", "ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT",
			"NINE", "TEN", "JACK", "QUEEN", "KING" };
	public String suit;
	private int face;

	// constructors
	public Card() {
		face = 0;
		suit = "";
	}

	public Card(int f, String s) {
		face = f;
		suit = s;
	}

	// set methods

	public void setFace(int f) {
		face = f;
	}

	public int getFace() {
		return face;
	}
	
	public void setSuit(String s) {
		suit = s;
	}

	// get methods
	public String getSuit() {
		return suit;
	}

	public int getValue() {
		return face;
	}

	// equals method

	public boolean equals(Card c) {
		return suit.contentEquals(c.getSuit()) && face == c.getValue();
	}

	public String toString() {
		return FACES[face] + " of " + getSuit() + " " + "| " + "value " + "= " + getValue();
	}
}
