package com.huaxia.blackjack;

import static java.lang.System.*;

import com.huaxia.blackjack.Card.Face;
import com.huaxia.blackjack.Card.Suit;

public class CardTestOne {

	public static void main(String[] args) {
		Card heartA = new BlackJackCard(Face.ACE,Suit.HEART);
		out.println(heartA);
		Card diamond2 = new BlackJackCard(Face.TWO, Suit.DIAMOND);
		out.println(diamond2);
		Card club3 = new BlackJackCard(Face.THREE, Suit.CLUB);
		out.println(club3);
		Card spade4 = new BlackJackCard(Face.FOUR, Suit.SPADE);
		out.println(spade4);
		Card heartQ = new BlackJackCard(Face.QUEEN, Suit.HEART);
		out.println(heartQ);
		Card spade9 = new BlackJackCard(Face.NINE, Suit.SPADE);
		out.println(spade9);
		out.println(heartA.equals(diamond2));
		out.println(heartA.equals(heartA));
		out.println(spade4.equals(heartQ));
		out.println(club3.equals(spade4));
	}
}
