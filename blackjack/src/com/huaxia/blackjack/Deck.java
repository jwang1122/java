package com.huaxia.blackjack;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

import com.huaxia.blackjack.Card.Face;
import com.huaxia.blackjack.Card.Suit;

public class Deck {
	static final String filename = "cards.csv";

	static ArrayList<BlackJackCard> deck = new ArrayList<>();
	static Hashtable<Card, Card> cardTable = new Hashtable<>();
	static {
		InputStream is = Deck.class.getResourceAsStream(filename);
		Scanner input;
		input = new Scanner(is);
		input.nextLine(); // get rid of header line
		while (input.hasNextLine()) {
			String[] line = input.nextLine().split(",");
			BlackJackCard card = new BlackJackCard(getFace(line[0]), getSuit(line[1]), line[2]);
			deck.add(card);
			cardTable.put(card, card);
		}
		input.close();

	}

	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	static Face getFace(String face) {
		switch (face) {
		case "A":
			return Face.ACE;
		case "2":
			return Face.TWO;
		case "3":
			return Face.THREE;
		case "4":
			return Face.FOUR;
		case "5":
			return Face.FIVE;
		case "6":
			return Face.SIX;
		case "7":
			return Face.SEVEN;
		case "8":
			return Face.EIGHT;
		case "9":
			return Face.NINE;
		case "10":
			return Face.TEN;
		case "J":
			return Face.JACK;
		case "Q":
			return Face.QUEEN;
		case "K":
			return Face.KING;
		default:
			break;
		}
		return null;
	}

	static Suit getSuit(String suit) {
		switch (suit) {
		case "SPADE":
			return Suit.SPADE;
		case "CLUB":
			return Suit.CLUB;
		case "DIAMOND":
			return Suit.DIAMOND;
		case "HEART":
			return Suit.HEART;
		default:
			break;
		}
		return null;
	}

	int topCardIndex;

	Deck() {
		// initialize data - stackOfCards - topCardIndex
		topCardIndex = 51;
	}

	public ArrayList<BlackJackCard> getDeck() {
		return deck;
	}

	public BlackJackCard getCard(int i) {
		return deck.get(i);
	}

	// modifiers
	public void settopCardIndex(int n) {
		topCardIndex = n;
	}

	public void setstackOfCards(ArrayList<BlackJackCard> d) {
		deck = d;
	}

	public void shuffle() {
		// shuffle the deck
		// reset variables as needed
		Collections.shuffle(deck);
		topCardIndex = 51;
	}

	public int getCard() {
		return topCardIndex;
	}

	public ArrayList<BlackJackCard> getstackOfCards() {
		return deck;
	}

	public int size() {
		return 52;
	}

	public int numCardsLeft() {
		return 0;
	}

	public Card nextCard() {
		return deck.get(topCardIndex--);
	}

	public String toString() {
		return deck + "   topCardIndex = " + topCardIndex;
	}
}
