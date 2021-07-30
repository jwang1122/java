package com.huaxia.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.blackjack.BlackjackCard;
import com.huaxia.blackjack.Card;
import com.huaxia.blackjack.Dealer;
import com.huaxia.blackjack.Game;
import com.huaxia.blackjack.Player;

class GameTest {

	Game game;
	Player player;
	Dealer dealer;

	Card heartsA;
	Card hearts4;
	Card diamondsQ;
	Card clubs10;
	Card spades2;
	Card spades3;

	@BeforeEach
	void setUp() throws Exception {
		game = new Game();
		player = new Player("John");
		dealer = new Dealer();
		game.playerList.add(player);
		game.dealer = dealer;

		heartsA = new BlackjackCard("A", "HEARTS");
		hearts4 = new BlackjackCard("4", "HEARTS");
		diamondsQ = new BlackjackCard("Q", "DIAMONDS");
		clubs10 = new BlackjackCard("10", "CLUBS");
		spades2 = new BlackjackCard("2", "SPADES");
		spades3 = new BlackjackCard("3", "SPADES");
	}

	@Test
	void testPlayerWin() {
		player.win();
		player.win();
		player.win();
		int expected = 3;
		int actual = player.win;
		assertEquals(expected, actual);
	}
	
	@Test
	void testDealerWin() {
		dealer.win();
		dealer.win();
		dealer.win();
		int expected = 3;
		int actual = dealer.win;
		assertEquals(expected, actual);
	}
	
	@Test
	void testPlayerNaturalDealerLess21() {
		player.addCardToHand(clubs10);
		player.addCardToHand(heartsA); // 21 in hand
		dealer.addCardToHand(diamondsQ);
		dealer.addCardToHand(hearts4);
		dealer.addCardToHand(spades3); // 17 in hand

		String expected = player.name;
		String actual = game.determineWinner();
		assertEquals(expected, actual);
	}

	@Test
	void testDealerNaturalPlayerLess21() {
		dealer.addCardToHand(clubs10);
		dealer.addCardToHand(heartsA); // 21 in hand
		player.addCardToHand(diamondsQ);
		player.addCardToHand(hearts4);
		player.addCardToHand(spades3); // 17 in hand

		String expected = dealer.name;
		String actual = game.determineWinner();
		assertEquals(expected, actual);
	}

	@Test
	void testDealerBustPlayerLess21() {
		dealer.addCardToHand(clubs10);
		dealer.addCardToHand(diamondsQ);
		dealer.addCardToHand(hearts4); // 24 in hand
		player.addCardToHand(diamondsQ);
		player.addCardToHand(hearts4);
		player.addCardToHand(spades3); // 17 in hand

		String expected = player.name;
		String actual = game.determineWinner();
		assertEquals(expected, actual);
	}

	@Test
	void testPlayerBustDealerLess21() {
		player.addCardToHand(clubs10);
		player.addCardToHand(diamondsQ);
		player.addCardToHand(hearts4); // 24 in hand
		dealer.addCardToHand(diamondsQ);
		dealer.addCardToHand(hearts4);
		dealer.addCardToHand(spades3); // 17 in hand

		String expected = dealer.name;
		String actual = game.determineWinner();
		assertEquals(expected, actual);
	}

	@Test
	void testBothPlayerDealerBust() {
		player.addCardToHand(clubs10);
		player.addCardToHand(diamondsQ);
		player.addCardToHand(hearts4); // 24 in hand
		dealer.addCardToHand(diamondsQ);
		dealer.addCardToHand(clubs10);
		dealer.addCardToHand(hearts4); // 24 in hand

		String expected = dealer.name;
		String actual = game.determineWinner();
		assertEquals(expected, actual);
	}

	@Test
	void testBothDealerPlayerLess21() {
		dealer.addCardToHand(clubs10);
		dealer.addCardToHand(hearts4);
		dealer.addCardToHand(spades3); // 17 in hand
		player.addCardToHand(diamondsQ);
		player.addCardToHand(hearts4);
		player.addCardToHand(spades3); // 17 in hand

		String expected = "tied";
		String actual = game.determineWinner();
		assertEquals(expected, actual);

		dealer.cleanHand();
		player.cleanHand();
		dealer.addCardToHand(clubs10);
		dealer.addCardToHand(hearts4);
		dealer.addCardToHand(spades3); // 17 in hand
		player.addCardToHand(diamondsQ);
		player.addCardToHand(spades3); // 13 in hand

		expected = dealer.name;
		actual = game.determineWinner();
		assertEquals(expected, actual);

		dealer.cleanHand();
		player.cleanHand();
		dealer.addCardToHand(clubs10);
		dealer.addCardToHand(hearts4);
		dealer.addCardToHand(spades3); // 17 in hand
		player.addCardToHand(heartsA);
		player.addCardToHand(hearts4);
		player.addCardToHand(spades3); // 18 in hand

		expected = player.name;
		actual = game.determineWinner();
		assertEquals(expected, actual);
	}
}
