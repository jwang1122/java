package com.huaxia.blackjack1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
