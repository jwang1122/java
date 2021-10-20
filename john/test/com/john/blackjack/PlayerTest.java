package com.john.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	Card clubsA;
	Card hearts2;
	Card diamondsQ;
	Player player;
	
	@BeforeEach
	void setUp() throws Exception {
		player = new Player("John");
		clubsA = new Card(Face.ACE, Suit.CLUBS);
		hearts2 = new Card(Face.TWO, Suit.HEARTS);
		diamondsQ = new Card(Face.QUEEN, Suit.DIAMONDS);
	}

	@Test
	void testAddCardToHand() {
		player.addCardToHand(clubsA);
		assertTrue(player.hand.size()==1);
		assertTrue(player.hand.contains(clubsA));
		player.addCardToHand(hearts2);
		assertTrue(player.hand.size()==2);
		assertTrue(player.hand.contains(hearts2));
		player.cleanHand();
		assertTrue(player.hand.size()==0);
	}

	@Test
	void testShowHand() {
		player.addCardToHand(clubsA);
		player.addCardToHand(hearts2);
		String expected = "      John: [(A, CLUBS), (2, HEARTS)]:13:0";
		String actual = player.showHand();
		assertEquals(expected, actual);		
	}
	
	@Test
	void testGetHandValue1Ace() {
		player.addCardToHand(clubsA);
		player.addCardToHand(hearts2);
		int expected = 13;
		int actual = player.getHandValue();
		assertEquals(expected, actual);
	}

	@Test
	void testGetHandValue2AceBusted() {
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(diamondsQ);
		player.addCardToHand(diamondsQ);
		int expected = 22;
		int actual = player.getHandValue();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetHandValue2Ace() {
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(hearts2);
		int expected = 14;
		int actual = player.getHandValue();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetHandValue3AceBusted() {
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(diamondsQ);
		player.addCardToHand(diamondsQ);
		int expected = 23;
		int actual = player.getHandValue();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetHandValue3Ace() {
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(hearts2);
		int expected = 15;
		int actual = player.getHandValue();
		assertEquals(expected, actual);
	}

	@Test
	void testGetHandValue4AceBusted() {
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(diamondsQ);
		player.addCardToHand(diamondsQ);
		int expected = 24;
		int actual = player.getHandValue();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetHandValue4Ace() {
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(clubsA);
		player.addCardToHand(diamondsQ);
		player.addCardToHand(hearts2);
		int expected = 16;
		int actual = player.getHandValue();
		assertEquals(expected, actual);
	}
}
