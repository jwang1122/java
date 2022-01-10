package blackjack;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Player {
	public static Hashtable<String, Position> seats = new Hashtable<>();
	static {
		seats.put("WEST", new Position(80, 250));
		seats.put("SOUTH", new Position(300, 500));
		seats.put("EAST", new Position(600, 250));
		seats.put("NORTH", new Position(300, 30));
	};
	static final int CARD_GAP = 30;

	protected String name;
	protected String seat;
	protected List<Card> hand = new ArrayList<>();
	protected int win = 0;
	protected int cardX, cardY;
	protected MainFrame frame;

	public Player(String name, String seat, MainFrame frame) {
		this.frame = frame;
		this.name = name;
		this.seat = seat;
		Position pos = seats.get(seat);
		cardX = pos.getX();
		cardY = pos.getY();
	}

	public void win() {
		win++;
	}

	public boolean addCardToHand(Card card) {
		boolean failed = false;
		int value = getHandValue();
		if (value > 21) {
			failed = true;
		} else {
			hand.add(card);
			frame.addCard(card, this);
			cardX += CARD_GAP;
		}
		return failed;
	}

	public void cleanHand() {
		hand.clear();
	}

	public int getHandValue() {
		int value = 0, count = 0;
		for (Card card : hand) {
			value += card.getValue();
			if (card.face == "A") {
				count++;
			}
		}
		while (value > 21 && count > 0) { // bust
			value -= 10; // correct my Ace from 11 to 1
			count--;
		}
		return value;
	}

	@Override
	public String toString() {
		return name + ":" + hand;
	}

	public Integer getHandSize() {
		return hand.size();
	}

	public String getName() {
		return name;
	}

	public int getCardX() {
		return cardX;
	}

	public int getCardY() {
		return cardY;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void resetCardPosition() {
		Position pos = seats.get(seat);
		cardX = pos.getX();
		cardY = pos.getY();
	}

	public boolean isDealer() {
		return name.equals("Dealer");
	}
}
