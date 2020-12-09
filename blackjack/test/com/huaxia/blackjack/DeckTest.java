package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {
	Deck deck;
	Card spadeA;
	
	@BeforeEach
	void setUp() throws Exception {
		deck = new Deck();
		spadeA = new Card("A", "SPADE");
	}

	@Test
	void testGetDeck() {
		assertTrue(deck.getDeck().size()==52);
	}

	@Test
	void testShuffle() {
		Card card = deck.getCard(0);
		assertEquals(card, spadeA);
		deck.shuffle();
		card = deck.getCard(0);
		assertNotEquals(card, spadeA);		
	}
}
