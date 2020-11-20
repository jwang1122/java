package com.huaxia.kingdomino;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import com.huaxia.kingdomino.Player.PlayerColor;

public class Kingdomino extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	static Color bgColor = new Color(238, 231, 188);
	static Dimension frameSize = new Dimension(1080, 720);
	static double dividerLocation = 0.30;

	boolean position1Selected = false;
	boolean position2Selected = false;

	Player player1 = new Player(PlayerColor.BluePlayer);
	Player player2 = new Player(PlayerColor.GreenPlayer);
	Player player3 = new Player(PlayerColor.YellowPlayer);
	Player player4 = new Player(PlayerColor.RedPlayer);
	Deck deck = new Deck();
	ArrayList<Player> playerList = new ArrayList<Player>();
	JMenuItem displayPlayer1, displayPlayer2, displayPlayer3, displayPlayer4;
	int round = 1;
	JSplitPane currentPane;
	ArrayList<Domino> dominoList;
	Player currentPlayer;

	Kingdomino() {
		setTitle("Kingdomino Game (4 players)");
		setSize(frameSize);
		setBackground(bgColor);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		displayPlayer1 = new JMenuItem(player1.name);
		displayPlayer2 = new JMenuItem(player2.name);
		displayPlayer3 = new JMenuItem(player3.name);
		displayPlayer4 = new JMenuItem(player4.name);
		displayPlayer1.addActionListener(this);
		displayPlayer2.addActionListener(this);
		displayPlayer3.addActionListener(this);
		displayPlayer4.addActionListener(this);
		JMenuBar mb = new JMenuBar();
		JMenu select = new JMenu("Select player");
		select.add(displayPlayer1);
		select.add(displayPlayer2);
		select.add(displayPlayer3);
		select.add(displayPlayer4);
		mb.add(select);
		add(mb);
		setJMenuBar(mb);
	}

	public static void main(String[] args) {
		Kingdomino kingdomino = new Kingdomino();
		kingdomino.play();
	}

	void play() {
		while (deck.deck.size() > 0) {
			dominoList = deck.getNextDominoSet();
			buildPlayerList();
			for (int i = 0; i < 4; i++) {
				Player player = playerList.get(i);
				currentPane = player.buildMainPane(dominoList);
				currentPlayer = player;
				setStatus();
				player.doGame(this, dominoList);
			}
			round++;
		}
		showGameResult();
	}

	private void setStatus() {
		for (int i = 0; i < playerList.size(); i++) {
			if (currentPlayer.equals(playerList.get(i))) {
				currentPlayer.setStatus(currentPlayer.name + "'s turn.");
			} else {
				playerList.get(i).setStatus("Wait for your turn.");
			}
		}

	}

	void buildPlayerList() {
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		playerList.add(player4);
		Collections.shuffle(playerList);
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

	private void showFinalResults() {
		ArrayList<Player> winnerList = getPlayerListOrderedByScores();
		showWinnerScores(winnerList);
		for (int i = 1; i < 4; i++) {
			Player player = winnerList.get(i);
			JOptionPane.showMessageDialog(null,
					player.getName() + " gets a score of " + player.score + " points!\nIts most extensive property is "
							+ player.maxField + " !\nFinally he owns a total of " + player.crowns + " Crowns!\n ",
					"losing", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void showWinnerScores(ArrayList<Player> listWinners) {
		Player player1 = listWinners.get(0);
		JOptionPane.showMessageDialog(null,
				"The big winner is " + player1.getName() + "!\nHe gets a score of " + player1.score
						+ " points!\nIts most extensive property is " + player1.maxField
						+ "  !\nFinally he owns a total of " + player1.crowns + " crowns!\n ",
				"Winner", JOptionPane.INFORMATION_MESSAGE);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == displayPlayer1) {
			this.setVisible(false);
			if (currentPane != null)
				this.remove(currentPane);
			currentPane = player1.getMainPane();
			if (currentPane == null)
				currentPane = player1.buildMainPane(dominoList);
			this.add(currentPane);
			this.setVisible(true);
		}
		if (e.getSource() == displayPlayer2) {
			this.setVisible(false);
			if (currentPane != null)
				this.remove(currentPane);
			currentPane = player2.getMainPane();
			if (currentPane == null)
				currentPane = player2.buildMainPane(dominoList);
			this.add(currentPane);
			this.setVisible(true);
		}
		if (e.getSource() == displayPlayer3) {
			this.setVisible(false);
			if (currentPane != null)
				this.remove(currentPane);
			currentPane = player3.getMainPane();
			if (currentPane == null)
				currentPane = player3.buildMainPane(dominoList);
			this.add(currentPane);
			this.setVisible(true);
		}
		if (e.getSource() == displayPlayer4) {
			this.setVisible(false);
			if (currentPane != null)
				this.remove(currentPane);
			currentPane = player4.getMainPane();
			if (currentPane == null)
				currentPane = player4.buildMainPane(dominoList);
			this.add(currentPane);
			this.setVisible(true);
		}

	}

}
