package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private int currentIndex;
	private List<Card> cardList = new ArrayList<>();
	
	public Deck() {
		currentIndex = 52;
		for(int i=1; i<Card.FACES.length; i++) {
			for(String suit: Card.SUITS) {
				Card card = new Card(Card.FACES[i], suit);
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
