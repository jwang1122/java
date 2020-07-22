package com.huaxia.john;

public class Card {
	String face;
	String suit;
	
	Card(String face, String suit){
		this.face = face;
		this.suit = suit;
	}

	@Override
	public String toString() {
		return "[" + face + ", " + suit + "]";
	}
	
}
