package com.huaxia.john;

import static java.lang.System.out;

public class CardTest {

	public static void main(String[] args) {
        Card one = new BlackJackCard("1","DIAMONDS"); 
        out.println(one);
        Card two = new BlackJackCard("4","CLUBS"); 
        out.println(two);
        Card three = new BlackJackCard("Q","SPADES"); 
        out.println(three);
        Card four = new BlackJackCard("Q","HEARTS"); 
        out.println(four);
        Card five = new BlackJackCard("9","SPADES"); 
        out.println(five);
        Card six = new BlackJackCard("K", "DIAMONDS");
        out.println(six);
        out.println(one.equals(two)); 
        out.println(one.equals(one)); 
        out.println(four.equals(five)); 
        out.println(three.equals(four));
        out.println(five.equals(six));	}

}
