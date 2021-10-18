package com.huaxia.java2.card;

import com.huaxia.java2.annotation.ClassPreamble;

@ClassPreamble(author = "John Q. Wang", date = "03/01/2020", currentRevision = 1, lastModified = "12/01/2020", lastModifiedBy = "John Q. Wang", reviewers = {
		"Charles", "Ailian" })
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

	public int getValue() {
		return face.getValue();
	}

	private String getFaceDisplay() {
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
	public boolean equals(Object obj) {
		if (obj instanceof Card) {
			Card other = (Card) obj;
			return face.equals(other.face) && suit.equals(other.suit);
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("(%s, %s)", getFaceDisplay(), suit);
	}
}
