package com.huaxia.john;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	public static final String FACES[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	public static final String SUITS[] = { "HEARTS", "DIAMONDS", "SPADES", "CLUBS" };
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;
	private int topCardIndex = 51;
	private ArrayList<BlackJackCard> stackOfCards = new ArrayList<BlackJackCard>();

	// constructor
	public Deck() {
		// initialize the data
		for(String s : SUITS) {
			for(String f: FACES) {
				BlackJackCard c = new BlackJackCard(f, s);
				stackOfCards.add(c);
			}
		}
	}

	public int size() {
		return stackOfCards.size();
	}

	public int numCardsLeft() {
		return this.topCardIndex + 1;
	}

	public void shuffle() {
		Collections.shuffle(stackOfCards);
	}

	public BlackJackCard nextCard() {
		return stackOfCards.get(topCardIndex--);
	}

	public String toString() {
		return stackOfCards + " topCardIndex = " + topCardIndex;
	}
}
