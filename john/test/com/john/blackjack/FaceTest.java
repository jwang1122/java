package com.john.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FaceTest {
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetValue() {
		assertTrue(Face.ACE.getValue()==11);
		assertTrue(Face.QUEEN.getValue()==10);
		assertTrue(Face.FOUR.getValue()==4);
	}

}
