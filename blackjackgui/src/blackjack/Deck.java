package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	static final String[] FACES = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	static final String[] SUITS = {"spade","club","diamond","heart"};
	
	private ArrayList<Card> stackOfCards = new ArrayList<>();
	private int currentIndex;

	public Deck(){
		for(String face: FACES) {
			for (String suit : SUITS) {
				Card card = new BlackjackCard(face, suit);
				stackOfCards.add(card);
			}
		}
		currentIndex = 51;
	}
	
	public void shuffle() {
		Collections.shuffle(stackOfCards);
	}
	
	public Card nextCard() {
		int index = currentIndex;
		currentIndex--;
		if(currentIndex<0) {
			index=51;
			shuffle();
		}
		return stackOfCards.get(index);
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}

	public ArrayList<Card> getStackOfCards() {
		return stackOfCards;
	}

}