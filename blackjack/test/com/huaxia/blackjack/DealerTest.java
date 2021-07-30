package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.blackjack.BlackjackCard;
import com.huaxia.blackjack.Card;
import com.huaxia.blackjack.Dealer;

class DealerTest {

	Dealer dealer;
	Card heartsA;
	Card hearts4;
	Card diamondsQ;
	Card clubs10;
	Card spades2;
	
	@BeforeEach
	void setUp() throws Exception {
		dealer = new Dealer();
		heartsA = new BlackjackCard("A", "HEARTS");
		hearts4 = new BlackjackCard("4", "HEARTS");
		diamondsQ = new BlackjackCard("Q", "DIAMONDS");
		clubs10 = new BlackjackCard("10", "CLUBS");
		spades2 = new BlackjackCard("2", "SPADES");
	}

	@Test
	void testToString() {
		assertEquals("Dealer", dealer.toString());
	}

	@Test
	void testAddCardToHand() {
		Dealer dealer = new Dealer();
		dealer.addCardToHand(clubs10);
		assertEquals(1, dealer.getHandSize()); // john should has only one card 
		assertEquals(clubs10, dealer.hand.get(0));// and which is clubs10
	}

	@Test
	void testGetHandValueWithAceBust() {
		dealer.addCardToHand(clubs10);
		dealer.addCardToHand(heartsA);
		dealer.addCardToHand(spades2);
		int actual = dealer.getHandValue();
		assertEquals(13, actual);
	}
	
	@Test
	void testGetHandValueWithAce() {
		dealer.addCardToHand(clubs10);
		dealer.addCardToHand(heartsA);
		int actual = dealer.getHandValue();
		assertEquals(21, actual);
	}
	
	@Test
	void testGetHandValueWithoutAce() {
		dealer.addCardToHand(clubs10);
		dealer.addCardToHand(diamondsQ);
		dealer.addCardToHand(spades2);
		int actual = dealer.getHandValue();
		assertEquals(22, actual);
	}
	
	@Test
	void testCleanHand() {
		dealer.cleanHand();
		assertEquals(0, dealer.getHandSize());
	}
	
	@Test
	void testShowHandFaceDown() {
		dealer.addCardToHand(heartsA);
		dealer.addCardToHand(hearts4);
		String actual = dealer.showHand(false);
		String expected = dealer.getName() + "{[A, HEARTS] HIDDEN}";
		assertEquals(expected, actual);
	}
	
	@Test
	void testShowHandFaceUp() {
		dealer.addCardToHand(heartsA);
		dealer.addCardToHand(hearts4);
		dealer.addCardToHand(spades2);
		String actual = dealer.showHand(true);
		String expected = dealer.getName() + "{[A, HEARTS] [4, HEARTS] [2, SPADES] }:17:0";
		assertEquals(expected, actual);		
	}
	
	@Test
	void testHit() {
		dealer.addCardToHand(heartsA);
		dealer.addCardToHand(hearts4);
		assertEquals(true, dealer.hit());		
		dealer.addCardToHand(spades2);
		assertEquals(false, dealer.hit());		
	}
	
	@Test
	void testGetHandSize() {
		int actual = dealer.getHandSize();
		assertEquals(0, actual);
	}

}
