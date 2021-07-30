package com.huaxia.blackjack1;

public class BlackjackCard extends Card {
	
	BlackjackCard(String face, String suit){
		this.face = face;
		this.suit = suit;
	}

	@Override // method overridden
	public int getValue() {
		int value = 0;
		if(!isPictured()) {
			return Integer.parseInt(face);
		}
		switch(face) {
		case "A": value=11; break;
		case "J": 
		case "Q": 
		case "K": value=10; break;
		}
		return value;
	}
	
	
}
