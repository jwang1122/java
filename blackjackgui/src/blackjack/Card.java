package blackjack;

import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Single card for regular card game with face, suit and cardImage.
 * 
 * @author Rodney
 *
 */
public class Card {
	static final String RESOURCE_PREFIX = "resources/";
	static final int CARD_WIDTH = 125;
	static final int CARD_HEIGHT = 170;
	
	protected String face;
	protected String suit;
	ImageIcon cardImage;
	
	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
		URL url = getClass().getClassLoader().getResource(RESOURCE_PREFIX.concat(suit).concat(face).concat(".gif"));
		cardImage = new ImageIcon(url);
	}
	
	public Card() {
		
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

	public ImageIcon getCardImage() {
		return cardImage;
	}

	@Override
	public String toString() {
		return "[" + face + ", " + suit + "]";
	}
	
	
}
