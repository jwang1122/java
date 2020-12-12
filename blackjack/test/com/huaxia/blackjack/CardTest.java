package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.blackjack.Card.Face;
import com.huaxia.blackjack.Card.Suit;

class CardTest {
	Card heartA = new Card(Face.ACE, Suit.HEART);
	Card club9 = new Card(Face.NINE, Suit.CLUB);
	Card clubQ = new Card(Face.QUEEN, Suit.CLUB);
	
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
