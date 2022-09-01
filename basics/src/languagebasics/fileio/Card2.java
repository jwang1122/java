package languagebasics.fileio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card2 {
	static String[] FACES = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	static String[] SUITS = { "SPADES", "CLUBS", "HEARTS", "DIAMONDS" };

	String face;
	String suit;
	int value;

	Card2(String face, String suit) {
		this.face = face;
		this.suit = suit;
		this.value = getCardValue(face);
	}

	private int getCardValue(String s) {
		int value = 0;
		switch (s) {
		case "A":
			value = 1;
			break;
		case "J":
			value = 11;
			break;
		case "Q":
			value = 12;
			break;
		case "K":
			value = 13;
			break;
		default:
			value = Integer.parseInt(s);
			break;
		}
		return value;
	}

	public String toString() {
		return "(" + face + ", " + suit + ")";
	}

	public static void main(String[] args) {
		List<Card2> cards = new ArrayList<Card2>();
		for(String face : FACES) {
			for(String suit :SUITS) {
				cards.add(new Card2(face, suit));
			}
		}
		System.out.println(cards);
		Collections.shuffle(cards);
		System.out.println(cards);
	}

}
