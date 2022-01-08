package blackjack;

/**
 * Dealer instance in blackjack game responsible for deal cards to all players.
 * 
 * @author John
 *
 */
public class Dealer extends Player {
	private Deck deck;
	
	public Dealer(MainFrame mainFrame) {
		super("Dealer", "NORTH", mainFrame);
		this.deck = new Deck();
		this.deck.shuffle();
	}

	public void shuffle() {
		deck.shuffle();
	}
	
	public Card deal() {
		return deck.nextCard();
	}
	
}
