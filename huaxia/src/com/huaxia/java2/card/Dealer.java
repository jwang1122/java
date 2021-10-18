package com.huaxia.java2.card;

public class Dealer extends Player{
	private Deck deck = new Deck();
	
	public Dealer() {
		this.name = "Dealer";
		deck.shuffle();
	}
	
	@Override
	public boolean hit() {
		int value = getHandValue();
		if(value<17)
			return true;
		return false;
	}
	
	public Card deal() {
		return deck.nextCard();
	}
	
	public String showHand(boolean faceUp) {
		if(!faceUp) {
			return String.format("%s: [%s, HIDDEN]", name, hand.get(0));
		}
		return super.showHand();
	}
}
