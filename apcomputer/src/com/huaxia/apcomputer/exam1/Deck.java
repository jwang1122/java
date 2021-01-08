package com.huaxia.apcomputer.exam1;

/**
 * Question 3,4.
 * 
 * @author John
 *
 */
public class Deck {
	private Card[] myDeck;
	private final String[] SUITS = {"SPADES", "CLUBS", "DIAMONDS", "HEARTS"};
	public final static int NUMCARDS = 52;
	
	public Deck() {
		int index = 0;
		myDeck = new Card[52];
		for(int j=0; j<4; j++) {
			for (int i=0; i<13; i++) {
				Card card = new Card(SUITS[j], i);
				myDeck[index++] = card;
			}
		}
	}
	
	public void writeDeck() {
		System.out.println(myDeck);
//		for (Card card : myDeck)
//			System.out.println((String)card); // refer to TextBook.main()
		for (Card card : myDeck)
			System.out.println(card);
	}
	
	public void shuffle() {
		
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.writeDeck();
	}
}
