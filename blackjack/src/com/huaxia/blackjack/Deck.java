package com.huaxia.blackjack;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

public class Deck {
	static final String filename = "cards.csv";
	
	static ArrayList<Card> deck = new ArrayList<>();
	static Hashtable<Card, Card> cardTable = new Hashtable<>();
	static {
		InputStream is = Deck.class.getResourceAsStream(filename);
		Scanner input;
		input = new Scanner(is);
		input.nextLine(); // get rid of header line
		while (input.hasNextLine()) {
			String[] line = input.nextLine().split(",");
			Card card = new Card(line[0], line[1], line[2]);
			deck.add(card);
			cardTable.put(card, card);
		}
		input.close();
		
	}
	
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	
	Deck(){
		// initialize data - stackOfCards - topCardIndex
		topCardIndex = 51;

		stackOfCards = new ArrayList<Card>();
		// loop through suits
		// loop through faces
		// add in a new card

		for (int i = 0; i < Card.SUITS.length; i++)
			for (int j = 1; j <= Card.FACES.length; j++)
				stackOfCards.add(new BlackJackCard(Card.FACES[j], Card.SUITS[i]));
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public Card getCard(int i) {
		return deck.get(i);
	}

	// modifiers
	public void settopCardIndex(int n) {
		topCardIndex = n;
	}

	public void setstackOfCards(ArrayList<Card> d) {
		stackOfCards = d;
	}

	public void shuffle() {
		// shuffle the deck
		// reset variables as needed
		Collections.shuffle(stackOfCards);
		topCardIndex = 51;

	}

	public int getCard() {
		return topCardIndex;
	}

	public ArrayList<Card> getstackOfCards() {
		return stackOfCards;
	}

	public int size() {
		return 52;
	}

	public int numCardsLeft() {
		return 0;
	}

	public Card nextCard() {
		return stackOfCards.get(topCardIndex--);
	}

	public String toString() {
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	}
}
