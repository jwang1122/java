package com.huaxia.blackjack1;

public class Dealer extends Player {
	private Deck deck;
	
	public Dealer() { //constructor for Dealer
		this.name = "Dealer";
		this.deck = new Deck();
	}

	public void shuffle() {
		deck.shuffle();
	}
	
	public Card deal() {
		return deck.nextCard();
	}
	
	public String showHand(boolean isFaceUp) {
		String myHand = name + "{";
		if(isFaceUp) {
			for(Card card: hand) { // for-each loop
				myHand += card + " ";
			}
			myHand += "}:";
			myHand += getHandValue();
			myHand += ":"+win;
		}else {
			myHand += hand.get(0)+" HIDDEN}";
		}
		return myHand;
	}

	@Override
	public boolean hit() {
		int value = getHandValue();
		if(value<17) {
			return true;
		}
		return false;
	}

}
