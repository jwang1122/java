package com.john.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {
	Card clubsA;
	Card hearts2;
	
	@BeforeEach
	void setUp() throws Exception {
		clubsA = new Card(Face.ACE, Suit.CLUBS);
		hearts2 = new Card(Face.TWO, Suit.HEARTS);
	}

	@Test
	void testGetValue() {
		int expected = 11;
		int actual = clubsA.getValue();
		assertEquals(expected, actual);
		expected = 2;
		actual = hearts2.getValue();
		assertEquals(expected, actual);
	}

	@Test
	void testToString() {
		String expected = "(A, CLUBS)";
		String actual = clubsA.toString();
		assertEquals(expected, actual);
		expected = "(2, HEARTS)";
		actual = hearts2.toString();
		assertEquals(expected, actual);
	}
	
}
