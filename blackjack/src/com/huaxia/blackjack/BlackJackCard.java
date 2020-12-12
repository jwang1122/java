package com.huaxia.blackjack;

public class BlackJackCard extends Card {
	// constructors
	public BlackJackCard() {
		super();
	}

	public BlackJackCard(String face, String suit) {
		super(face, suit);
	}

	public int getValue() {
		String face = getFace();
		if (isNumeric(face)) {
			return Integer.parseInt(face);
		}
		if (face == "A")
			return 11;
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
