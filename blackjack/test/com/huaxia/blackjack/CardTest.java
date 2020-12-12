package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {
	Card heartA = new Card("A", "HEART");
	Card club9 = new Card("9", "CLUB");
	Card clubQ = new Card("Q", "CLUB");
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetValue() {
		assertTrue(heartA.getValue()==1);
		assertTrue(club9.getValue()==9);
		assertTrue(clubQ.getValue()==12);
	}

}
