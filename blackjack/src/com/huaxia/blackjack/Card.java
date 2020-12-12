package com.huaxia.blackjack;

import java.awt.Image;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Card {
	enum Faces {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
	enum Suits {SPADE, CLUB, DIAMOND, HEART};
	static final String[] FACES = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	static final String[] SUITS = { "SPADE", "CLUB", "DIAMOND", "HEART" };
	
	Image image;
	String face;
	String suit;
	String imageFile;
	
	Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}
	
	public Card(String face, String suit, String imageFile) {
		this.face = face;
		this.suit = suit;
		this.imageFile = imageFile;
	}

	public Card() {
		// TODO Auto-generated constructor stub
	}

	public int getValue() {
		switch(face) {
		case "A":
			return 1;
		case "J":
			return 11;
		case "Q":
			return 12;
		case "K":
			return 13;
		default:
			return Integer.parseInt(face);
		}
	}
	
	public Image getImage() {
		if(image==null) {
			try {
				InputStream is = Card.class.getResourceAsStream(imageFile);
				image = ImageIO.read(is);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
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

	@Override
	public String toString() {
		return "Card [" + face + ", " + suit + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((face == null) ? 0 : face.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (face == null) {
			if (other.face != null)
				return false;
		} else if (!face.equals(other.face))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}

	public static void main(String[] args) {
		Card diamondA = new Card(FACES[0], SUITS[2]);
		System.out.println(diamondA);
	}

}
