package com.huaxia.java2.card;

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
	void testGetSize() {
		assertTrue(deck.getCards().size()==52);
	}

}
