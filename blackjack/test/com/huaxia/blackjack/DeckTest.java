package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.blackjack.Card.Face;
import com.huaxia.blackjack.Card.Suit;

class DeckTest {
	Deck deck;
	BlackJackCard spadeA;
	
	@BeforeEach
	void setUp() throws Exception {
		deck = new Deck();
		spadeA = new BlackJackCard(Face.ACE, Suit.SPADE);
	}

	@Test
	void testGetDeck() {
		assertTrue(deck.getstackOfCards().size()==52);
	}

	@Test
	void testShuffle() {
		BlackJackCard card = deck.getCard(0);
		assertEquals(card, spadeA);
		deck.shuffle();
		card = deck.getCard(0);
		assertNotEquals(card, spadeA);	
		assertTrue(deck.topCardIndex==51);
	}
}
