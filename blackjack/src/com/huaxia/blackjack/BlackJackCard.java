package com.huaxia.blackjack;

public class BlackJackCard extends Card {
	// constructors
	public BlackJackCard() {
		super();
	}

	public BlackJackCard(Face face, Suit suit) {
		super(face, suit);
	}

	public BlackJackCard(Face face, Suit suit, String imageFile) {
		super(face, suit, imageFile);
	}

	public int getValue() {
		Face face = getFace();
		if (face == Face.ACE)
			return 11;
		if (face.value<11) {
			return face.value;
		}
		return 10;
	}

	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
