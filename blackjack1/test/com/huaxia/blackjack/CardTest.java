package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {
	Card heartsA = new Card("A", "HEARTS");
	Card clubs9 = new Card("9", "CLUBS");
	Card clubsQ = new Card("Q", "CLUBS");
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetValue() {
		assertTrue(heartsA.getValue()==1);
		assertTrue(clubs9.getValue()==9);
		assertTrue(clubsQ.getValue()==12);
	}

	@Test
	void testIsPictured() {
		assertTrue(heartsA.isPictured());
		assertFalse(clubs9.isPictured());
	}
}
