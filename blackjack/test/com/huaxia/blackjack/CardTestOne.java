package com.huaxia.blackjack;

import static java.lang.System.*;

public class CardTestOne {

	public static void main(String[] args) {
		Card one = new BlackJackCard();
		out.println(one);
		Card two = new BlackJackCard("A", "DIAMOND");
		out.println(two);
		Card three = new BlackJackCard("4", "CLUB");
		out.println(three);
		Card four = new BlackJackCard("Q", "SPADE");
		out.println(four);
		Card five = new BlackJackCard("Q", "HEART");
		out.println(five);
		Card six = new BlackJackCard("9", "SPADE");
		out.println(six);
		out.println(one.equals(two));
		out.println(one.equals(one));
		out.println(four.equals(five));
		out.println(three.equals(four));
	}
}
