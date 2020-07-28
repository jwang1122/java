package com.huaxia.john;

public class Dealer extends Player {
	private Deck deck = new Deck();
	
	public void shuffle() {
		this.deck.shuffle();
		
	}
	
	public Card deal() {
		return deck.nextCard();
	}

}
