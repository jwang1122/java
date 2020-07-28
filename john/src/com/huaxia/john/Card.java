package com.huaxia.john;

public class Card {
	protected String face;
	protected String suit;

	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}

	public int getValue() {
		int v = 0;
		switch (face) {
		case "K":
			v = 13;
			break;
		case "Q":
			v = 12;
			break;
		case "J":
			v = 11;
			break;
		case "A":
			v = 1;
			break;
		default:
			v = Integer.parseInt(face);
			break;
		}
		return v;
	}

	@Override
	public String toString() {
		return "[" + face + ", " + suit + "]";
	}

}
