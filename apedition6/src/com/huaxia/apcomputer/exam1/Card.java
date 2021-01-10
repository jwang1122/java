package com.huaxia.apcomputer.exam1;

/**
 * Question 3,4.
 * 
 * @author John
 *
 */
public class Card {
	private String mySuit;
	private int myValue; //0 to 12
	
	public Card(String suit, int value) {
		mySuit = suit;
		myValue = value;
	}

	public String getSuit() {
		return mySuit;
	}

	public int getValue() {
		return myValue;
	}

	@Override
	public String toString() {
		String faceValue = "";
		if(myValue == 11)
			faceValue = "J";
		else if(myValue == 12)
			faceValue = "Q";
		else if(myValue == 0)
			faceValue = "K";
		else if(myValue == 1)
			faceValue = "A";
		if(myValue>=2 && myValue<=10)
			return myValue + " of " + mySuit;
		else
			return faceValue + " of " + mySuit;	
	}
}
