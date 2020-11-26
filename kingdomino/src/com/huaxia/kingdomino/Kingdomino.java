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

import com.huaxia.kingdomino.Message.MsgType;
import com.huaxia.kingdomino.Player.PlayerColor;

public class Kingdomino extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	static final Color bgColor = new Color(238, 231, 188);
	static final int frameWidth = 1080;
	static final int frameHeight = 720;
	static final Dimension frameSize = new Dimension(frameWidth, frameHeight);
	static final double dividerLocation = 0.30;

	boolean position1Selected = false;
	boolean position2Selected = false;

	Player player1 = new Player(PlayerColor.BluePlayer);
	Player player2 = new Player(PlayerColor.GreenPlayer);
	Player player3 = new Player(PlayerColor.YellowPlayer);
	Player player4 = new Player(PlayerColor.RedPlayer);
	Deck deck = new Deck().shuffle();
	ArrayList<Player> playerList = new ArrayList<Player>();
	ArrayList<Player> playerOrderList = new ArrayList<Player>();
	JMenuItem current, displayPlayer1, displayPlayer2, displayPlayer3, displayPlayer4,exitGame;
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
		init();
	}

	public static void main(String[] args) {
		Configure config = new Configure(null, "Kingdomino Greeting", true);
		Kingdomino kingdomino = config.getKingdomino();
		if (kingdomino != null)
			kingdomino.play();
	}

	void play() {
		shufflePlayerList();
		while (deck.getDeckSize() > 0) {
			dominoList = deck.getNextDominoSet();
//			showPlayOrder();
			for (int i = 0; i < 4; i++) {
				Player player = playerList.get(i);
				currentPlayer = player;
				switchToCurrentPlayer();
				player.doGame(this, dominoList);
			}
			round++;
			this.setPlayerOrder();
		}
		showGameResult();
	}

	private void switchToCurrentPlayer() {
		setVisible(false);
		if (currentPane != null) {
			remove(currentPane);
		}
		currentPane = currentPlayer.buildMainPane(dominoList);
		setStatus();
		setVisible(true);
	}

	private void init() {
		displayPlayer1 = new JMenuItem(player1.name);
		displayPlayer2 = new JMenuItem(player2.name);
		displayPlayer3 = new JMenuItem(player3.name);
		displayPlayer4 = new JMenuItem(player4.name);
		current = new JMenuItem("current");
		exitGame = new JMenuItem("Exit");
		displayPlayer1.addActionListener(this);
		displayPlayer2.addActionListener(this);
		displayPlayer3.addActionListener(this);
		displayPlayer4.addActionListener(this);
		current.addActionListener(this);
		exitGame.addActionListener(this);
		JMenuBar mb = new JMenuBar();
		JMenu select = new JMenu("Select player");
		select.add(current);
		select.add(displayPlayer1);
		select.add(displayPlayer2);
		select.add(displayPlayer3);
		select.add(displayPlayer4);
		select.addSeparator();
		select.add(exitGame);
		mb.add(select);
		add(mb);
		setJMenuBar(mb);
	}

	private void setStatus() {
		String status = "Round: ".concat("" + round).concat("\n");
		for (int i = 0; i < playerList.size(); i++) {
			status = status.concat(playerList.get(i).name).concat(" > ");
		}
		for (int i = 0; i < playerList.size(); i++) {
			if (currentPlayer.equals(playerList.get(i))) {
				status = status.concat("\n\n").concat(currentPlayer.name).concat("'s turn.");
				currentPlayer.setStatus(status);
			} else {
				playerList.get(i).setStatus(status.concat("\n\nWait for your turn."));
			}
		}

	}

	void shufflePlayerList() {
		playerList.clear();
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		playerList.add(player4);
		playerOrderList.add(player1);
		playerOrderList.add(player2);
		playerOrderList.add(player3);
		playerOrderList.add(player4);
		Collections.shuffle(playerList);
	}

	void setPlayerOrder() {
		for (int i = 0; i < 4; i++) {
			playerList.set(i, playerOrderList.get(i));
		}
	}

	private void showGameResult() {
		player1.setScores();
		player2.setScores();
		player3.setScores();
		player4.setScores();
		Player winner = showFinalResults();
		currentPlayer = winner;
		winner.showWinner();
		displayMessage(new Message(MsgType.GAME_OVER, winner), "Game Over");
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			player.setStatus(player.getName() + " made " + player.score + ", Game Over!!!");
			if (!player.equals(winner)) {
				player.showScore();
			}
		}
		actionPerformed(null);
		// System.exit(0);
	}

	private Player showFinalResults() {
		ArrayList<Player> winnerList = getPlayerListOrderedByScores();
//		showWinnerScores(winnerList);
//		for (int i = 1; i < 4; i++) {
//			Player player = winnerList.get(i);
//			displayMessage(player.buildMessage(), "Losing");
//		}
		return winnerList.get(0);
	}

	private void displayMessage(Message msg, String title) {
		JOptionPane.showMessageDialog(null, msg.msg, title, JOptionPane.INFORMATION_MESSAGE);
	}

//	private void showWinnerScores(ArrayList<Player> listWinners) {
//		Player player = listWinners.get(0);
//		displayMessage(player.buildWinnerMessage(), "Winner");
//	}

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
		if (e == null || e.getSource() == current) {
			refreshPane(currentPlayer);
			return;
		}
		if (e.getSource() == displayPlayer1) {
			refreshPane(player1);
		}
		if (e.getSource() == displayPlayer2) {
			refreshPane(player2);
		}
		if (e.getSource() == displayPlayer3) {
			refreshPane(player3);
		}
		if (e.getSource() == displayPlayer4) {
			refreshPane(player4);
		}
		if(e.getSource()==exitGame) {
			System.exit(1);
		}

	}

	void refreshPane(Player player) {
		this.setVisible(false);
		if (currentPane != null)
			this.remove(currentPane);
		currentPane = player.getMainPane();
		if (currentPane == null)
			currentPane = player.buildMainPane(dominoList);
		this.add(currentPane);
		this.setVisible(true);
	}

	public void setPlayer(Player player, int i) {
		playerOrderList.set(i, player);
	}
}
