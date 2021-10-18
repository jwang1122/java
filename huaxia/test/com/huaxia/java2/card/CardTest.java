package com.huaxia.java2.card;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {
	Card diamondK;
	Card clubA;
	Card heart2;
	
	@BeforeEach
	void setUp() throws Exception {
		diamondK = new Card(Face.KING, Suit.DIAMONDS);
		clubA = new Card(Face.ACE, Suit.CLUBS);
		heart2 = new Card(Face.TWO, Suit.HEARTS);
	}

	@Test
	void testGetValue() {
		assertTrue(diamondK.getValue()==10);
		assertTrue(clubA.getValue()==11);
		assertTrue(heart2.getValue()==2);
	}

	@Test
	void testToString() {
		String expected = "(KING, DIAMONDS)";
		String actual = diamondK.toString();
		assertEquals(expected, actual);
	}
	
	
}
