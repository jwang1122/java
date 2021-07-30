package com.huaxia.blackjack1;

import java.util.ArrayList;

public class Game {
	public ArrayList<Player> playerList= new ArrayList<>();
	public Dealer dealer;

	void init() {
		while (true) {
			System.out.print("Add player? (y/n) ");
			String answer = Player.input.nextLine();
			if (answer.toLowerCase().equals("n")) {
				break;
			}
			playerList.add(Player.createPlayer());
		}
		dealer = new Dealer();
		dealer.shuffle();
	}

	void play() {
		while (true) {
			for (Player player : playerList) {
				player.addCardToHand(dealer.deal());
			}
			dealer.addCardToHand(dealer.deal());
			for (Player player : playerList) {
				player.addCardToHand(dealer.deal());
			}
			dealer.addCardToHand(dealer.deal());
			for (Player player : playerList) {
				System.out.println(player.showHand());
			}
			System.out.println(dealer.showHand(false));
			for (Player player : playerList) {
				while (player.hit()) {
					player.addCardToHand(dealer.deal());
					System.out.println(player.showHand());
				}
			}
			while (dealer.hit()) {
				dealer.addCardToHand(dealer.deal());
			}
			for (Player player : playerList) {
				System.out.println(player.showHand());
			}
			System.out.println(dealer.showHand(true));
			determineWinner();
			for (Player player : playerList) {
				System.out.println(player.showHand());
			}
			System.out.println(dealer.showHand(true));
			boolean moreGame = dealer.moreGame();
			if (!moreGame) {
				break;
			}
			for (Player player : playerList) {
				player.cleanHand();
			}
			dealer.cleanHand();
		}
		System.out.println("Game Over!");
	}

	public String determineWinner() {
		String winner = "";
		int dealerTotal = dealer.getHandValue();
		for (Player player : playerList) {
			int playerTotal = player.getHandValue();
			if (dealerTotal > 21 && playerTotal > 21) {
				winner = dealer.name;
			} else if (dealerTotal < 21 && playerTotal > 21) {
				winner = dealer.name;
			} else if (dealerTotal > 21 && playerTotal < 21) {
				winner = player.name;
			} else if (dealerTotal == 21 && playerTotal < 21) {
				winner = dealer.name;
			} else if (playerTotal == 21 && dealerTotal < 21) {
				winner = player.name;
			} else if (playerTotal < 21 && dealerTotal < 21) {
				if (playerTotal == dealerTotal) { // equal means tied
					winner = "tied";
				} else if (playerTotal < dealerTotal) { // who is greater is winner
					winner = dealer.name;
				} else {
					winner = player.name;
				}
			}
			if (winner.equals(player.name)) {
				player.win();
			}
			if (winner.equals(dealer.name)) {
				dealer.win();
			}
		}
		return winner;
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.init();
		System.out.println(game.playerList);
		game.play();
	}

}
