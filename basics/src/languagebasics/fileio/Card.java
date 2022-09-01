package languagebasics.fileio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
	static String[] FACES = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	static String[] SUITS = { "SPADES", "CLUBS", "HEARTS", "DIAMONDS" };

	String face;
	String suit;
	int value;

	Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}

	public int getValue() {
		switch(face) {
		case "A":
			return 1;
		case "J":
			return 11;
		case "Q":
			return 12;
		case "K":
			return 13;
		default:
			break;
		}
		return Integer.parseInt(face);
	}
	
	public String toString() {
		return "(" + face + ", " + suit + ")";
	}

	public static void main(String[] args) {
		List<Card> cards = new ArrayList<Card>();
		for(String face : FACES) {
			for(String suit :SUITS) {
				cards.add(new Card(face, suit));
			}
		}
		System.out.println(cards);
		Collections.shuffle(cards);
		System.out.println(cards);
	}

}
