package com.huaxia.blackjack;

import static java.lang.System.out;

import java.util.Scanner;

public class BlackJack{

	Player player = new Player();
	Dealer dealer = new Dealer();

	public BlackJack() {

	}
	
	public void playGame() {
		System.out.println("The game start...");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			dealer.shuffle();
			player.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());
			player.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());
			int playerTotal = player.getHandValue();
			boolean hit = true;
			while (hit) {
				out.println("PLAYER ");
				out.println("Hand Value :: " + playerTotal);
				out.println("Hand Size :: " + player.getHandSize());
				out.println("Cards in Hand :: " + player.toString());
				hit = player.hit();
				if (hit) {
					player.addCardToHand(dealer.deal());
					playerTotal = player.getHandValue();
				}
			}
			out.println("\nDEALER ");
			int dealerTotal = dealer.getHandValue();
			out.println("Hand Value :: " + dealerTotal);
			out.println("Hand Size :: " + dealer.getHandSize());
			out.println("Cards in Hand :: " + dealer.toString());
			if (playerTotal > 21 && dealerTotal <= 21) {
				out.println("\nDealer wins - Player busted!");
			} else if (playerTotal <= 21 && dealerTotal > 21) {
				out.println("\nPlayer wins - Dealer busted!");
			} else if (playerTotal > 21 && dealerTotal > 21) {
				out.println("Both players bust!");
			} else if (playerTotal < dealerTotal) {
				out.println("\nDealer has bigger hand value!");
				dealer.setWinCount(dealer.getWinCount() + 1);
				out.println("Dealer: Cards in Hand :: " + dealer.toString());
			} else {
				out.println("\nPlayer has bigger hand value!");
				player.setWinCount(player.getWinCount() + 1);
				out.println("Player: Cards in Hand :: " + player.toString());
			}

			System.out.print("Do you want to play again? (y or n)");
			String answer = scanner.nextLine();
			flag = answer.contentEquals("y");
		}
		scanner.close();
		System.out.println("The game ended.");
	}

	public static void main(String[] args) {
		BlackJack game = new BlackJack();
		game.playGame();
	}

}
