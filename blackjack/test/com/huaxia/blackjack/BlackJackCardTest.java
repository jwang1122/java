package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlackJackCardTest {
	Card heartA = new BlackJackCard("A", "HEART");
	Card club9 = new BlackJackCard("9", "CLUB");
	Card clubQ = new BlackJackCard("Q", "CLUB");

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
