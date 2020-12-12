package com.wang.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = { "CLUBS", "SPADES", "DIAMONDS", "HEARTS" };

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck() {
		// initialize data - stackOfCards - topCardIndex
		topCardIndex = 51;

		stackOfCards = new ArrayList<Card>();
		// loop through suits
		// loop through faces
		// add in a new card

		for (int i = 0; i < SUITS.length; i++)
			for (int j = 1; j <= NUMFACES; j++)
				stackOfCards.add(new BlackJackCard(j, SUITS[i]));
	}

	// modifiers
	public void settopCardIndex(int n) {
		topCardIndex = n;
	}

	public void setstackOfCards(ArrayList<Card> d) {
		stackOfCards = d;
	}

	public void shuffle() {
		// shuffle the deck
		// reset variables as needed
		Collections.shuffle(stackOfCards);
		topCardIndex = 51;

	}

	// accessors

	public int getCard() {
		return topCardIndex;
	}

	public ArrayList<Card> getstackOfCards() {
		return stackOfCards;
	}

	public int size() {
		return 52;
	}

	public int numCardsLeft() {
		return 0;
	}

	public Card nextCard() {
		return stackOfCards.get(topCardIndex--);
	}

	public String toString() {
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	}
}
