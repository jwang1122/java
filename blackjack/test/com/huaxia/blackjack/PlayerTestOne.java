package com.huaxia.blackjack;

import static java.lang.System.out;

import com.huaxia.blackjack1.Deck;
import com.huaxia.blackjack1.Player;

public class PlayerTestOne {
	public static void main(String args[]) {
		Player player = new Player();

		Deck deck = new Deck();
		deck.shuffle();

		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());

		out.println("toString");
		out.println(player);

		out.println("handValue");
		out.println(player.getHandValue());
		out.println(player.hit());
		
		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());

		out.println("toString");
		out.println(player);

		out.println("handValue");
		out.println(player.getHandValue());

		out.println(player.hit());
	}
}