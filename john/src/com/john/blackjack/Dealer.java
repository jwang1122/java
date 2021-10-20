package com.john.blackjack;

public class Dealer extends Player {
	private Deck deck;
	
	public Dealer() {
		name = "Dealer";
		deck = new Deck();
	}

	public Card deal() {
		return deck.nextCard();
	}

	public void shuffle() {
		deck.shuffle();
	}
	
	public String showHand(boolean faceup) {
		if(faceup) {
			return super.showHand();
		}
		return String.format("%10s: [%s, HIDDEN]",name,hand.get(0));
	}

	@Override
	public boolean hit() {
		int value = getHandValue();
		if(value<17)
			return true;
		return false;
	}
}
