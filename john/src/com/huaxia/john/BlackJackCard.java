package com.huaxia.john;

public class BlackJackCard extends Card {

	BlackJackCard(String face, String suit) {
		super(face, suit);
	}

	public int getValue() {
		int v = 0;
		switch (face) {
		case "K":
		case "Q":
		case "J":
			v = 10;
			break;
		case "A":
			v = 11;
			break;
		default:
			v = Integer.parseInt(face);
			break;
		}
		return v;
	}
	
	@Override
	public boolean equals(Object obj) {
		Card c = (Card)obj;
		return this.getValue()==c.getValue();
	}

}
