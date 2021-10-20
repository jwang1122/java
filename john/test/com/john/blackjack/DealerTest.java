package com.john.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DealerTest {
	Dealer dealer;
	Card clubsA;
	Card hearts2;
	Card diamondsQ;
	Card spades4;

	@BeforeEach
	void setUp() throws Exception {
		dealer = new Dealer();
		clubsA = new Card(Face.ACE, Suit.CLUBS);
		hearts2 = new Card(Face.TWO, Suit.HEARTS);
		diamondsQ = new Card(Face.QUEEN, Suit.DIAMONDS);
		spades4 = new Card(Face.FOUR, Suit.SPADES);
	}

	@Test
	void testShowHand() {
		dealer.addCardToHand(clubsA);
		dealer.addCardToHand(hearts2);
		String expected = "Dealer: [(A, CLUBS), HIDDEN]";
		String actual = dealer.showHand(false);
		assertEquals(expected, actual);		
		
		dealer.addCardToHand(diamondsQ);
		expected = "Dealer: [(A, CLUBS), (2, HEARTS), (Q, DIAMONDS)]:13:0";
		actual = dealer.showHand(true);
		assertEquals(expected, actual);		
	}
	
	@Test
	void testDeal() {
		Card card = dealer.deal();
		assertTrue(card instanceof Card);
	}

	@Test
	void testHit() {
		dealer.addCardToHand(clubsA);
		dealer.addCardToHand(hearts2);
		boolean expected = true;
		boolean actual = dealer.hit();
		assertEquals(expected, actual);		

		dealer.addCardToHand(spades4);
		expected = false;
		actual = dealer.hit();
		assertEquals(expected, actual);		
		
	}
}
