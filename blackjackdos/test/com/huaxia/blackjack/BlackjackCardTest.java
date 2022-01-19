package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.blackjack.BlackjackCard;
import com.huaxia.blackjack.Card;

class BlackjackCardTest {
	Card heartsA;
	Card hearts4;
	Card diamondsQ;
	Card clubs10;

	@BeforeEach
	void setUp() throws Exception {
		heartsA = new BlackjackCard("A", "HEARTS");
		hearts4 = new BlackjackCard("4", "HEARTS");
		diamondsQ = new BlackjackCard("Q", "DIAMONDS");
		clubs10 = new BlackjackCard("10", "CLUBS");
	}

	@Test
	void testIsPictured() {
		assertTrue(heartsA.isPictured());
		assertFalse(hearts4.isPictured());
		assertFalse(clubs10.isPictured());
	}

	@Test
	void testGetValue() {
		assertEquals(4, hearts4.getValue());
		assertEquals(11, heartsA.getValue());
		assertEquals(10, diamondsQ.getValue());
		assertEquals(10, clubs10.getValue());
	}

}
