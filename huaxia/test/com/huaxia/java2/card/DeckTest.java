package com.huaxia.java2.card;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {
	Deck deck;
	Card kHeart;
	
	@BeforeEach
	void setUp() throws Exception {
		deck = new Deck();
		kHeart = new Card(Face.KING, Suit.HEARTS);
	}

	@Test
	void testGetSize() {
		assertTrue(deck.getCards().size()==52);
	}

	@Test
	void testNextCard() {
		Card card = deck.nextCard();
		assertTrue(card instanceof Card);
		assertEquals(card, kHeart);
	}
	
	@Test
	void testShuffle() {
		deck.shuffle();
		Card card = deck.nextCard();
		assertNotEquals(card, kHeart);		
	}
}
