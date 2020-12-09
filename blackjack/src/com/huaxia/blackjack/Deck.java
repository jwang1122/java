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
	
	Deck(){
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void shuffle(){
		Collections.shuffle(deck);
	}
}
