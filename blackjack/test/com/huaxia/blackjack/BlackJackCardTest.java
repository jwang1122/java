package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.blackjack.Card.Face;
import com.huaxia.blackjack.Card.Suit;

class BlackJackCardTest {
	Card heartA = new BlackJackCard(Face.ACE, Suit.HEART);
	Card club9 = new BlackJackCard(Face.NINE, Suit.CLUB);
	Card clubQ = new BlackJackCard(Face.QUEEN, Suit.CLUB);

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
