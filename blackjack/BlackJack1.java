package com.wang.blackjack;

import static java.lang.System.out;

public class BlackJack1

{ // add in Player instance variable
	private Player player;

	// add in Dealer instance variable
	private Dealer dealer;

	public BlackJack1() {
		player = new Player();
		dealer = new Dealer();
	}

	public void playGame() {
		dealer.shuffle();
		int playerWin = 0;
		int dealerWin = 0;
		int maxWin = 0;
		do {
			player.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());
			player.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());
			int playerTotal = player.getHandValue();
			int dealerTotal = dealer.getHandValue();
			showPlayer();

			while (playerTotal < 21 && player.hit()) {
				player.addCardToHand(dealer.deal());
				playerTotal = player.getHandValue();
				showPlayer();
			}
			showDealer();
			while (dealerTotal <= 16) {
				dealer.addCardToHand(dealer.deal());
				dealerTotal = dealer.getHandValue();
				showDealer();
			}

			if (playerTotal > 21 && dealerTotal > 21) {
				out.println("Both players bust!");
			} else if ((playerTotal <= 21 && dealerTotal > 21) || (dealerTotal < playerTotal)) {
				out.println("Player wins");
				playerWin = player.getWinCount() + 1;
				player.setWinCount(playerWin);
			} else if ((dealerTotal <= 21 && playerTotal > 21) || (playerTotal < dealerTotal)) {
				out.println("Dealer wins");
				dealerWin = dealer.getWinCount() + 1;
				dealer.setWinCount(dealerWin);
			}
			if (maxWin < playerWin)
				maxWin = playerWin;
			if (maxWin < dealerWin)
				maxWin = dealerWin;

			showResult();

			player.resetHand();
			dealer.resetHand();
			dealer.shuffle();

		} while (maxWin < 3);

	}

	private void showDealer() {
		out.println("DEALER ");
		out.println("Hand Value :: " + dealer.getHandValue());
		out.println("Hand Size :: " + dealer.getHandSize());
		out.println("Cards in Hand :: " + dealer.toString());
	}

	private void showPlayer() {
		out.println("PLAYER ");
		out.println("Hand Value :: " + player.getHandValue());
		out.println("Hand Size :: " + player.getHandSize());
		out.println("Cards in Hand :: " + player.toString());
	}

	private void showResult() {
		out.println("Dealer has won " + dealer.getWinCount() + " times.");
		out.println("Player has won " + player.getWinCount() + " times.");
	}

	public static void main(String[] args) {
		BlackJack1 game = new BlackJack1();
		out.println("Game start...");
		game.playGame();
		out.println("Game ended.");
	}
}
