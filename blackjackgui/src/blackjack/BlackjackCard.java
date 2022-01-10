package blackjack;

/**
 * Single card instance for Blackjack card game, which has face, suit and cardImage. 
 * Inherits from Card override getValue() method.
 * 
 * @see Card
 * 
 * @author Rodney
 *
 */
public class BlackjackCard extends Card {
	
	BlackjackCard(String face, String suit){
		super(face, suit);
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
