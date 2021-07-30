package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlackJackCardTest {
	Card heartA = new BlackjackCard("A", "HEARTS");
	Card club9 = new BlackjackCard("9", "CLUBS");
	Card clubQ = new BlackjackCard("Q", "CLUBS");

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetValue() {
		assertTrue(heartA.getValue()==11);
		assertTrue(club9.getValue()==9);
		assertTrue(clubQ.getValue()==10);
	}

}
