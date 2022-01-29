package blackjack;

import java.util.ArrayList;
import java.util.List;


public class Player {
	protected String name;
	protected String seat;
	protected List<Card> hand = new ArrayList<>();
	protected int win = 0;
	protected MainFrame parent;
	
	public Player() {
	}

	public Player(String name, String seat){
		this.name = name;
		this.seat = seat;
	}
	
	public Player(String name, String seat, MainFrame parent) {
		this.name = name;
		this.seat = seat;
		this.parent = parent;
	}

	public void win() {
		win++;
	}
	
	public void addCardToHand(Card card) {
		hand.add(card);
		parent.addCard(card, this);
	}
	
	public void cleanHand() {
		hand.clear();
	}
	
	public int getHandValue() {
		int value = 0;
		for(Card card:hand) {
			value += card.getValue();
		}
		if(value>21) { // bust
			if(isAceInHand()) {
				value -= 10; // correct my Ace from 11 to 1
			}
		}
		return value;
	}
	
	//Homework: write unit test to test this method
	private boolean isAceInHand() {
		boolean flag = false; // assume there is no Ace in my hand
		for(Card card : hand) {
			if(card.face.equals("A")) {
				flag = true; // find Ace in hand
				break;
			}
		}
		return flag;
	}
	
	public String showHand() {
		String myHand =name + "{";
		for(Card card: hand) { // for-each loop
			myHand += card + " ";
		}
		myHand += "}:"; 
		myHand += getHandValue();
		myHand += ":"+win;
		return myHand;
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
	
}
