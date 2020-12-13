package com.huaxia.java2.card;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<>();

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

}
