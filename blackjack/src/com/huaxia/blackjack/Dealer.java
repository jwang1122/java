package com.huaxia.blackjack;

import java.util.*;

public class Dealer extends Player {
	private Deck aDeck;
	private ArrayList<Card> hand;
	private int handTotal;
//	private int currentIndex = 0;

	public Dealer() {
		hand = new ArrayList<Card>();
		handTotal = 0;
		aDeck = new Deck();
		aDeck.shuffle();
	}

	public int getTotal() {
		return handTotal = super.getHandValue();
	}

	public boolean hit() {
		if (handTotal <= 16)
			return true;
		return false;
	}

	public void shuffle() {
		Collections.shuffle(hand);
	}

	public Card deal() {
		Card c = aDeck.nextCard();
		return c;

	}
}
