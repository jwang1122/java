package com.huaxia.java2;

public class Card {
	private final Face face;
	private final Suit suit;

	public Card(Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public Face getFace() {
		return face;
	}

	public String toString() {
		return face + " of " + suit;
	}
}
