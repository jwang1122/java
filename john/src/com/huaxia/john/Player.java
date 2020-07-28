package com.huaxia.john;


import java.util.ArrayList;

public class Player {
	protected ArrayList <BlackJackCard> hand = new ArrayList <BlackJackCard>();
	protected int winCount = 0;
	public String toString() {
		return "hand = " + hand.toString() + " - # wins " + winCount; 
	}
	public void addCardToHand( Card temp ) {
		
	}
	public void resetHand() {
		
	}
	public boolean hit() {
		int handValue = getHandValue();
		if(handValue <= 10)
			return true;
		if(handValue >= 20)
			return false;
		return true;
	}
	public void setWinCount( int numWins ) {
		this.winCount = numWins;
	}
	
	public int getWinCount() {
		return winCount;
	}
	
	public int getHandSize() {
		return 0;
	}
	
	public int getHandValue() {
		int value = 0;
		return value;
	}
}
