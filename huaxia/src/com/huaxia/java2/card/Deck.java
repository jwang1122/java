package com.huaxia.java2.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
	public static Scanner input = new Scanner(System.in);
	
	private ArrayList<Card> cards = new ArrayList<>();
	private int currentIndex = 52;
	
	public Deck() {
		for (Suit suit : Suit.values()) {
			for (Face face : Face.values()) {
				cards.add(new Card(face, suit));
			}
		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public Card nextCard() {
		currentIndex--;
		if(currentIndex<0) {
			currentIndex = 51;
		}
		return cards.get(currentIndex);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	
}
