package com.huaxia.blackjack;

import static java.lang.System.out;

public class CardTestOne {

	public static void main(String[] args) {
		Card heartA = new BlackjackCard("A","HEARTS");
		out.println(heartA);
		Card diamond2 = new BlackjackCard("2", "DIAMONDS");
		out.println(diamond2);
		Card club3 = new BlackjackCard("3", "CLUBS");
		out.println(club3);
		Card spade4 = new BlackjackCard("4", "SPADES");
		out.println(spade4);
		Card heartQ = new BlackjackCard("5", "HEARTS");
		out.println(heartQ);
		Card spade9 = new BlackjackCard("9", "SPADES");
		out.println(spade9);
		out.println(heartA.equals(diamond2));
		out.println(heartA.equals(heartA));
		out.println(spade4.equals(heartQ));
		out.println(club3.equals(spade4));
	}
}
