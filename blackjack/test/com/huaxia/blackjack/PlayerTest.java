package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.blackjack.Card.Face;
import com.huaxia.blackjack.Card.Suit;

class PlayerTest {
	Player player1 = new Player("John");
	Card heartA = new BlackJackCard(Face.ACE, Suit.HEART);
	Card club9 = new BlackJackCard(Face.NINE, Suit.CLUB);
	Card clubQ = new BlackJackCard(Face.QUEEN, Suit.CLUB);
	
	@BeforeEach
	void setUp() throws Exception {
		player1.addCardToHand(heartA);
	}

	@Test
	void testGetHandValue() {
		assertTrue(player1.getHandValue() == 11);
		player1.addCardToHand(clubQ);
		assertTrue(player1.getHandValue() == 21);
		player1.addCardToHand(club9);
		assertTrue(player1.getHandValue() == 20);
	}

}
