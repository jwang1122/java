package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {
	Deck deck;
	BlackjackCard spadeA;
	
	@BeforeEach
	void setUp() throws Exception {
		deck = new Deck();
		spadeA = new BlackjackCard("A", "SPADES");
	}

	@Test
	void testGetDeck() {
		assertTrue(deck.getStackOfCards().size()==52);
	}

//	@Test
//	void testShuffle() {
//		BlackjackCard card = deck.getCard(0);
//		assertEquals(card, spadeA);
//		deck.shuffle();
//		card = deck.getCard(0);
//		assertNotEquals(card, spadeA);	
//		assertTrue(deck.topCardIndex==51);
//	}
}
