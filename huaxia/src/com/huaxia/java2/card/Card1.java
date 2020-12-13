package com.huaxia.java2.card;

public class Card1 {
	static final String[] Face = { "A", "2", "3", "4", "6", "7", "8", "9", "10", "J", "Q", "K" };
	static final String[] Suit = { "SPADES", "CLUBS", "DIAMONDS", "HEARTS" };

	String face;
	String suit;

	Card1(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}

	int getValue() {
		switch (face) {
		case "A":
			return 1;
		case "J":
			return 11;
		case "Q":
			return 12;
		case "K":
			return 13;
		default:
			return Integer.parseInt(face);
		}
	}

	@Override
	public String toString() {
		return "Card1 [face=" + face + ", suit=" + suit + "]";
	}

	public static void main(String[] args) {
		Card1 card = new Card1("A", "SPADES");
		System.out.println(card + ":" + card.getValue());
		Card1 card2 = new Card1(Face[1], Suit[2]);
		System.out.println(card2 + ":" + card2.getValue());
	}

}
