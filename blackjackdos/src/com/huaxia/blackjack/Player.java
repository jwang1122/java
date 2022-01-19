package com.huaxia.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.huaxia.blackjack.Card;


public class Player {
	static Scanner input = new Scanner(System.in);

	protected String name;
	protected List<Card> hand = new ArrayList<>();
	protected int win = 0;
	
	public static Player createPlayer() {
		System.out.println("Enter player name: ");
		String name = input.nextLine();
		return new Player(name);
	}
	
	public Player() {
		super();
	}

	public Player(String name){
		this.name = name;
	}
	
	public void win() {
		win++;
	}
	
	public boolean hit() {
		boolean needMoreCard = false;
		System.out.print(name + ", do you want to hit? (y/n) ");
		String answer = input.nextLine();
		needMoreCard = answer.toLowerCase().equals("y");
		return needMoreCard;
	}

	public void addCardToHand(Card card) {
		hand.add(card);
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
	
	public static void main(String[] args) {
		Player john = new Player("John");
		System.out.println(john.hit());
	}

	public boolean moreGame() {
		System.out.print("More game? (y/n) ");
		String answer = input.nextLine();
		return answer.toLowerCase().equals("y");
	}
}
