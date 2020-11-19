package com.huaxia.kingdomino;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Kingdomino {
	static ArrayList<Domino> deck = new Deck().getDeck();
	static final int numDominos = 48;

	Player player1;
	Player player2;
	Player player3;
	Player player4;
	ArrayList<Player> fourPlayers;
	int roundNum = 1;

	public static void main(String[] args) {
		Configure dialog = new Configure(null, "Configure Kingdomino", true);
		Kingdomino kingdomino = dialog.getKingdomino();
		kingdomino.startPlay();
	}

	private void startPlay() {
		fourPlayers = shufflePlayers();
		while (deck.size() != 0) {
			showPlayOrder(roundNum);
			ArrayList<Domino> dominoList4 = getNewDominoListFromDeck();
			for (int i = 0; i < 4; i++) { // loop each player
				fourPlayers.get(i).doGame(dominoList4);
			}
			fourPlayers = shufflePlayers();
			roundNum++;
		}
		showGameResult();
	}

	private void showPlayOrder(int roundNum) {
		JOptionPane.showMessageDialog(null, "Round " + roundNum + ":\nPlayers will start in this order :\n"
				+ fourPlayers.get(0).getName() + ", " + fourPlayers.get(1).getName() + ", "
				+ fourPlayers.get(2).getName() + ", "
				+ fourPlayers.get(3).getName(), "Round", JOptionPane.INFORMATION_MESSAGE);
	}

	private void showGameResult() {
		player1.setScores();
		player2.setScores();
		player3.setScores();
		player4.setScores();
		showFinalResults();
		JOptionPane.showMessageDialog(null, "Game Over!", "Over", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	private void showWinnerScores(ArrayList<Player> listWinners) {
		Player player1 = listWinners.get(0);
		JOptionPane.showMessageDialog(null, "The big winner is " + player1.getName() + "!\nHe gets a score of "
				+ player1.score + " points!\nIts most extensive property is " + player1.maxField
				+ "  !\nFinally he owns a total of " + player1.crowns
				+ " crowns!\n ", "Winner", JOptionPane.INFORMATION_MESSAGE);
	}

	private void showFinalResults() {
		ArrayList<Player> winnerList = getPlayerListOrderedByScores();
		showWinnerScores(winnerList);
		for (int i = 1; i < 4; i++) {
			Player player = winnerList.get(i);
			JOptionPane.showMessageDialog(null, player.getName() + " gets a score of " + player.score
					+ " points!\nIts most extensive property is " + player.maxField + " !\nFinally he owns a total of "
					+ player.crowns + " Crowns!\n ", "losing", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private ArrayList<Player> getPlayerListOrderedByScores() {
		@SuppressWarnings("serial")
		ArrayList<Player> list = new ArrayList<Player>() {
			{
				add(player1);
				add(player2);
				add(player3);
				add(player4);
			}
		};
		Collections.sort(list);
		return list;
	}

	private ArrayList<Player> shufflePlayers() {
		ArrayList<Player> listPlayers = new ArrayList<Player>();
		listPlayers.add(player1);
		listPlayers.add(player2);
		listPlayers.add(player3);
		listPlayers.add(player4);
		Collections.shuffle(listPlayers);
		return listPlayers;
	}

	private ArrayList<Domino> getNewDominoListFromDeck() {
		ArrayList<Domino> listDominos = new ArrayList<Domino>();
		for (int i = 0; i < 4; i++) {
			listDominos.add(deck.get(0));
			deck.remove(0);
		}
		Collections.sort(listDominos);
		return listDominos;
	}
}