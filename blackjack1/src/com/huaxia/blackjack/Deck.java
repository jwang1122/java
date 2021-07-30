package com.huaxia.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	static final String[] FACES = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	static final String[] SUITS = {"SPADES","CLUBS","DIAMONDS","HEARTS"};
	
	private ArrayList<BlackjackCard> stackOfCards = new ArrayList<>();
	private int currentIndex;

	public Deck(){
		for(String face: FACES) {
			for (String suit : SUITS) {
				BlackjackCard card = new BlackjackCard(face, suit);
				stackOfCards.add(card);
			}
		}
		currentIndex = 51;
	}
	
	public void shuffle() {
		Collections.shuffle(stackOfCards);
	}
	
	public BlackjackCard nextCard() {
		int index = currentIndex;
		currentIndex--;
		return stackOfCards.get(index);
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}

	public ArrayList<BlackjackCard> getStackOfCards() {
		return stackOfCards;
	}

	public void setStackOfCards(ArrayList<BlackjackCard> stackOfCards) {
		this.stackOfCards = stackOfCards;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	
}
