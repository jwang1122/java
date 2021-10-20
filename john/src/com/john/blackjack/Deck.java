package com.john.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private int currentIndex;
	private List<Card> cardList = new ArrayList<>();
	
	public Deck() {
		currentIndex = 52;
		for(Face face:Face.values()) {
			for(Suit suit: Suit.values()) {
				Card card = new Card(face, suit);
				cardList.add(card);
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cardList);
	}
	
	public Card nextCard() {
		currentIndex--;
		return cardList.get(currentIndex);
	}
	public int getCurrentIndex() {
		return currentIndex;
	}

	public List<Card> getCardList() {
		return cardList;
	}

}
