package com.huaxia.java2.card;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Player> playerList = new ArrayList<>();
	private Dealer dealer = new Dealer();

	public void dealOneCard() {
		for (Player player : playerList) {
			player.addCardToHand(dealer.deal());
			System.out.println(player.showHand());
		}
		dealer.addCardToHand(dealer.deal());
	}

	public void dealCards() {
		dealOneCard();
		dealOneCard();
		System.out.println(dealer.showHand(false));
	}

	public void hit() {
		for (Player player : playerList) {
			while (player.hit()) {
				player.addCardToHand(dealer.deal());
				System.out.println(player.showHand());
				while (dealer.hit()) {
					dealer.addCardToHand(dealer.deal());
				}
			}
		}
	}

	public void play() {
		while (true) {
			dealCards();
			hit();
			for (Player player : playerList) {
				winner(dealer, player);
			}
			showResult();
			System.out.print("Would you like to play another game? (y/n) ");
			String answer = Deck.input.nextLine();
			if (answer.equalsIgnoreCase("n")) {
				break;
			}
			cleanHand();
		}
		Deck.input.close();
		System.out.println("Game Over!");
	}

	public void winner(Dealer dealer, Player player) {
		dealer.total = dealer.getHandValue();
		player.total = player.getHandValue();
		if (player.total > 21) {
			dealer.win();
			return;
		}
		dealerBusted(dealer, player);
	}

	private void dealerBusted(Dealer dealer, Player player) {
		if (dealer.total > 21) {
			player.win();
			return;
		}
		tiedUp(dealer, player);
	}

	private void tiedUp(Dealer dealer, Player player) {
		if (dealer.total == player.total) {
			return;
		}
		playerLarge(dealer, player);
	}

	private void playerLarge(Dealer dealer, Player player) {
		if (player.total > dealer.total) {
			player.win();
			return;
		}
		dealer.win();
	}

	public void showResult() {
		for (Player player : playerList) {
			System.out.println(player.showHand());
		}
		System.out.println(dealer.showHand(true));
	}

	public void cleanHand() {
		dealer.cleanHand();
		for (Player player : playerList) {
			player.cleanHand();
		}
	}

	public void addPlayers() {
		while (true) {
			System.out.print("Add Player? (y/n) ");
			String answer = Deck.input.nextLine();
			if (answer.equalsIgnoreCase("n")) {
				break;
			}
			System.out.print("Enter player name: ");
			String name = Deck.input.nextLine();
			Player player = new Player(name);
			playerList.add(player);
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.addPlayers();
		game.play();

	}

}
