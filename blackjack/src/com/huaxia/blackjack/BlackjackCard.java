package com.huaxia.blackjack;

public class BlackjackCard extends Card {
	// constructors
	public BlackjackCard() {
	}

	public BlackjackCard(String face, String suit) {
		super(face, suit);
	}

//	public BlackJackCard(Face face, Suit suit, String imageFile) {
//		super(face, suit, imageFile);
//	}

	public int getValue() {
		int value = 0;
		if(!isPictured()) {
			return Integer.parseInt(face);
		}
		switch(face) {
		case "A":
			value=11; 
			break;
		case "J":
		case "Q":
		case "K":
			value = 10;
			break;
		}
		return value;
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
