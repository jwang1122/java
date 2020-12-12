package com.wang.blackjack;

public class BlackJackCard extends Card {
	// constructors
	public BlackJackCard() {
		super();
	}

	public BlackJackCard(int n, String s) {
		super(n, s);
	}

	public int getValue() {
		int face = getFace();
		if ( face == 1)
			return 11;
		if (face >= 10)
			return 10;
		return face;
	}
}
