package com.huaxia.blackjack;

import static java.lang.System.out;

import com.huaxia.blackjack1.Deck;

public class DeckTestOne {
	public static void main(String args[]) {
		Deck deck = new Deck();
		for (int i = 0; i < 52; i++) {
			out.println(deck.nextCard());
		}

//		out.println("\n\n");
//		out.println("num cards left in the deck == " + deck.numCardsLeft());
//		out.println("\n\nshuffling");
//		deck.shuffle();
//		out.println("num cards left in the deck == " + deck.size());
//		out.println("\n\ntoString");
//		out.println(deck);

	}

}