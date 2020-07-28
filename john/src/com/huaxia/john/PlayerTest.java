package com.huaxia.john;

import static java.lang.System.out;

public class PlayerTest {
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
		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());
		out.println("toString");
		out.println(player);
		out.println("handValue");
		out.println(player.getHandValue());
		out.println(player.hit());
	}
}