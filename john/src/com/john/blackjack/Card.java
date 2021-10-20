package com.john.blackjack;

public class Card {
	private Face face;
	private Suit suit;

	public Card(Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}

	public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getValue() {
		return face.getValue();
	}

	private String display() {
		switch (face) {
		case ACE:
			return "A";
		case TWO:
			return "2";
		case THREE:
			return "3";
		case FOUR:
			return "4";
		case FIVE:
			return "5";
		case SIX:
			return "6";
		case SEVEN:
			return "7";
		case EIGHT:
			return "8";
		case NINE:
			return "9";
		case TEN:
			return "10";
		case JACK:
			return "J";
		case QUEEN:
			return "Q";
		case KING:
			return "K";
		}
		return "";
	}

	@Override
	public String toString() { // return a String representation of this object
		return String.format("(%s, %s)", display(), suit);
	}

	@Override
	public boolean equals(Object obj) { // polymorphism
		if (obj instanceof Card) {
			Card card = (Card) obj;
			return face == card.face && suit == card.suit;
		}
		return false;
	}

}
