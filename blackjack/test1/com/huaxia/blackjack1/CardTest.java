package com.huaxia.blackjack1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {

	Card heartsA;
	Card hearts4;
	Card diamondsQ;
	Card clubs10;
	
	@BeforeEach
	void setUp() throws Exception {
		heartsA = new Card("A", "HEARTS");
		hearts4 = new Card("4", "HEARTS");
		diamondsQ = new Card("Q", "DIAMONDS");
		clubs10 = new Card("10", "CLUBS");
	}

	@Test
	void testIsPictured() {
		assertTrue(heartsA.isPictured());
		assertFalse(hearts4.isPictured());
		assertFalse(clubs10.isPictured());
	}
	
	@Test
	void testGetValue() {
		assertTrue(hearts4.getValue()==4);
		assertTrue(heartsA.getValue()==1);
		assertTrue(diamondsQ.getValue()==12);
		assertTrue(clubs10.getValue()==10);
	}
	
	@Test
	void testToString() {
		String expected = "[4, HEARTS]";
		String actual = hearts4.toString();
		assertEquals(actual, expected);
		
		expected = "[Q, DIAMONDS]";
		actual = diamondsQ.toString();
		assertEquals(actual, expected);
	}

}
