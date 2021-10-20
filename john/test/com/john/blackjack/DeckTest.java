package com.john.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {
	Deck deck;
	Card heartsK;
	@BeforeEach
	void setUp() throws Exception {
		deck = new Deck();
		heartsK = new Card(Face.KING, Suit.HEARTS);
	}

	@Test
	void testConstructor() {
		int expected = 52;
		int actual = deck.getCardList().size();
		assertEquals(expected, actual);
		Card card = deck.nextCard();
		assertEquals(card, heartsK);
	}

	@Test
	void testShuffle() {
		deck.shuffle();
		Card card = deck.nextCard();
		assertNotEquals(card, heartsK);
	}
}
