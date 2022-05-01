package blackjack;

public class Card {
	static String[] FACES = { "B", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	static String[] SUITS = { "SPADES", "CLUBS", "HEARTS", "DIAMONDS" };

	private String face;
	private String suit;

	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getValue() {
		int value = 0;
		try {
			value = Integer.parseInt(face);
		}catch(Exception e) {
			switch(face) {
			case "J":
			case "Q":
			case "K":
				return 10;
			case "A":
				return 11;
			}
		}
		return value;
	}


	@Override
	public String toString() { // return a String representation of this object
		return String.format("(%s, %s)", face, suit);
	}

	@Override
	public boolean equals(Object obj) { // polymorphism
		if (obj instanceof Card) {
			Card card = (Card) obj;
			return face == card.face && suit == card.suit;
		}
		return false;
	}

}
