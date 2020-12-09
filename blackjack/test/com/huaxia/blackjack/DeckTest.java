package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {
	Deck deck;
	
	@BeforeEach
	void setUp() throws Exception {
		deck = new Deck();
	}

	@Test
	void testGetDeck() {
		assertTrue(deck.getDeck().size()==52);
	}

}
