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

	public Player() {

	}

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

	public void hit() {
	}

	public void pass() {

	}

	public void addCardToHand(Card card) {
		hand.add(card);
		frame.addCard(card, this);
		cardX += CARD_GAP;
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
		return name;
	}

	public Integer getHandSize() {
		return hand.size();
	}

	public String getName() {
		return name;
	}

	public Card getCurrentCard() {
		// TODO Auto-generated method stub
		return hand.get(hand.size()-1);
	}

	public int getCardX() {
		// TODO Auto-generated method stub
		return cardX;
	}

	public int getCardY() {
		// TODO Auto-generated method stub
		return cardY;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public int getWin() {
		return win;
	}

	public void reset() {
		Position pos = seats.get(seat);
		cardX = pos.getX();
		cardY = pos.getY();
	}

}
