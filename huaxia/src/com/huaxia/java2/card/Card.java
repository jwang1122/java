package com.huaxia.java2.card;

import com.huaxia.java2.annotation.ClassPreamble;

@ClassPreamble(
	author = "John Q. Wang",
	date = "03/01/2020",
	currentRevision=1,
	lastModified = "12/01/2020",
	lastModifiedBy="John Q. Wang",
	reviewers = {"Charles", "Ailian"}
)
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
	
	public String toString() {
		return face + " of " + suit;
	}
}
