package blackjack;

/**
 * Dealer instance in blackjack game responsible for deal cards to all players.
 * 
 * @author John
 *
 */
public class Dealer extends Player {
	private Deck deck;
	
	public Dealer() { //constructor for Dealer
		this.name = "Dealer";
		this.deck = new Deck();
		this.deck.shuffle();
	}

	public Dealer(MainFrame mainFrame) {
		super("Dealer", "NORTH", mainFrame);
		this.deck = new Deck();
		this.deck.shuffle();
		Position pos = positions.get(seat);
		x = pos.getX();
		y = pos.getY();
	}
	

	public void shuffle() {
		deck.shuffle();
	}
	
	public Card deal() {
		return deck.nextCard();
	}
	
	public String showHand(boolean isFaceUp) {
		String myHand = name + "{";
		if(isFaceUp) {
			for(Card card: hand) { // for-each loop
				myHand += card + " ";
			}
			myHand += "}:";
			myHand += getHandValue();
			myHand += ":"+win;
		}else {
			myHand += hand.get(0)+" HIDDEN}";
		}
		return myHand;
	}

}
