package com.huaxia.java1;

public class BlackjackCard extends Card {
	BlackjackCard(String face, String suit){
		super(face, suit);
	}
	
	@Override
	public int getValue() {
		switch(face) {
		case "A":
			return 11;
		case "J":
		case "Q":
		case "K":
			return 10;
		}
		return Integer.parseInt(face);
	}
		
}
