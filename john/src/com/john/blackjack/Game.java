package com.john.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	public static Scanner input = new Scanner(System.in);
	private List<Player> playerList = new ArrayList<>();
	private Dealer dealer = new Dealer();

	public static String ask(String question) {
		System.out.print(question);
		String answer = input.nextLine();
		return answer;
	}

	public void play() {
		while (true) {
			dealer.shuffle();
			dealCard();
			dealCard();
			System.out.println(dealer.showHand(false));
			hit();
			checkWinners();
			showResult();
			String answer = ask("Play again? (y/n) ");
			if(answer.equalsIgnoreCase("n"))
				break;
			startOver();
		}
		gameOver();
	}

	private void checkWinners() {
		for (Player player : playerList) {
			winner(player);
		}
	}

	private void startOver() {
		for(Player player: playerList) {
			player.cleanHand();
		}
		dealer.cleanHand();
	}

	private void showResult() {
		for(Player player: playerList) {
			System.out.println(player.showHand());
		}
		System.out.println(dealer.showHand(true));
	}

	private void winner(Player player) {
		player.total = player.getHandValue();
		dealer.total = dealer.getHandValue();
		if (player.total > 21) {
			dealer.win();
		} else if (dealer.total > 21) {
			player.win();
		} else if (dealer.total == player.total) {

		} else if (player.total > dealer.total) {
			player.win();
		} else {
			dealer.win();
		}
	}

	private void hit() {
		for (Player player : playerList) {
			while (player.hit()) {
				player.addCardToHand(dealer.deal());
				System.out.println(player.showHand());
			}
		}
		while (dealer.hit()) {
			dealer.addCardToHand(dealer.deal());
		}
	}

	private void dealCard() {
		for (Player player : playerList) {
			player.addCardToHand(dealer.deal());
			System.out.println(player.showHand());
		}
		dealer.addCardToHand(dealer.deal());
	}

	public void gameOver() {
		input.close();
		System.out.println("Game Over.");
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.addPlayers();
		game.play();
	}

	private void addPlayers() {
		String answer = "y";
		do {
			String name = ask("Enter player name: ");
			Player player = new Player(name);
			playerList.add(player);
			answer = ask("More player? (y/n) ");
		} while (answer.equals("y"));
	}

}
