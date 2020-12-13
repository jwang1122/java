package com.huaxia.java2.card;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {
	Card diamondK = new Card(Face.KING, Suit.DIAMONDS);
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetValue() {
		assertTrue(diamondK.getValue()==13);
	}

}
