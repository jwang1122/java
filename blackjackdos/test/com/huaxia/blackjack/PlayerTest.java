package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.blackjack.BlackjackCard;
import com.huaxia.blackjack.Card;

class PlayerTest {

	Player player1;
	Player player2;
	Player player3;
	Card heartsA;
	Card hearts4;
	Card diamondsQ;
	Card clubs10;
	Card spades2;

	
	@BeforeEach
	void setUp() throws Exception {
		heartsA = new BlackjackCard("A", "HEARTS");
		hearts4 = new BlackjackCard("4", "HEARTS");
		diamondsQ = new BlackjackCard("Q", "DIAMONDS");
		clubs10 = new BlackjackCard("10", "CLUBS");
		spades2 = new BlackjackCard("2", "SPADES");
		
		player1 = new Player("John");
		player1.addCardToHand(heartsA);
		player1.addCardToHand(hearts4);
		player1.addCardToHand(clubs10);
		
		player2 = new Player("Wang");
		player2.addCardToHand(spades2);
		player2.addCardToHand(hearts4);
		player2.addCardToHand(clubs10);
		
		player3 = new Player("Laura ");
		player3.addCardToHand(spades2);
		player3.addCardToHand(hearts4);
		player3.addCardToHand(heartsA);		
	}

	@Test
	void testToString() {
		assertEquals("John", player1.toString());
	}

	@Test
	void testAddCardToHand() {
		Player john = new Player("John");
		john.addCardToHand(clubs10);
		assertEquals(1, john.getHandSize()); // john should has only one card 
		assertEquals(clubs10, john.hand.get(0));// and which is clubs10
	}
	
	@Test
	void testGetHandValueWithAceBust() {
		int actual = player1.getHandValue();
		assertEquals(15, actual);
	}
	
	@Test
	void testGetHandValueWithAce() {
		int actual = player3.getHandValue();
		assertEquals(17, actual);
	}
	
	@Test
	void testGetHandValueWithoutAce() {
		int actual = player2.getHandValue();
		assertEquals(16, actual);
	}
	
	@Test
	void testCleanHand() {
		player1.cleanHand();
		assertEquals(0, player1.getHandSize());
	}
	
	@Test
	void testShowHand() {
		String actual = player1.showHand();
		String expected = player1.getName() + "{[A, HEARTS] [4, HEARTS] [10, CLUBS] }:15:0";
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetHandSize() {
		int actual = player3.getHandSize();
		assertEquals(3, actual);
	}
}