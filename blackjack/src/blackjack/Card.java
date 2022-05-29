package blackjack;

import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Single card for regular card game with face and suit.
 * 
 * @author John
 *
 */
public class Card{
	public static final int IMAGE_WIDTH = 125;
	public static final int IMAGE_HEIGHT = 170;
	
	protected String face;
	protected String suit;
	protected ImageIcon image;
	
	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
		String imageFileName = "resources/".concat(suit).concat(face).concat(".gif");
		URL url = getClass().getClassLoader().getResource(imageFileName);
		image = new ImageIcon(url);
	}
	
	Card(){
		
	}
	
	public ImageIcon getImage() {
		return image;
	}

	public boolean isPictured() {
		return "AJQK".contains(face);
	}
	
	public int getValue() {
		int value = 0;
		if(!isPictured()) {
			return Integer.parseInt(face);
		}
		switch(face) {
		case "A": value=1; break;
		case "J": value=11; break;
		case "Q": value=12; break;
		case "K": value=13; break;
		}
		return value;
	}

	public String getFace() {
		return face;
	}

	@Override
	public String toString() {
		return "[" + face + ", " + suit + "]";
	}
	
	public static void main(String[] args) {
		Card card = new Card("K","diamond");
		System.out.println(card.getImage());
	}
}