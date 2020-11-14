package com.huaxia.kingdomino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Kingdomino {
	static ArrayList<Tile> list = new Data().getDeck();
	static final int lengthCase = 70;
	static final int lengthBoard = 9;
	static final int numDominos = 48;

	Player player1;
	Player player2;
	Player player3;
	Player player4;
	ArrayList<Player> fourPlayers;
	ArrayList<Tile> deck = shuffle(list);
	int chooseTile = 0;
	boolean case1Selected, case2Selected = false;
	int x1, x2, y1, y2; // tile1 and tile2 grid positions
	Color fond = new Color(238, 231, 188);
	int roundNum = 1;
	JFrame frame;

	public static void main(String[] args) {
		Configure dialog = new Configure(null, "Configure Kingdomino", true);
		Kingdomino kingdomino = dialog.getKingdomino();
		kingdomino.startPlay();
	}

	private void startPlay() {
		fourPlayers = shufflePlayers();
		while (deck.size() != 0) {
			showPlayOrder(roundNum);
			ArrayList<Tile> tileList4 = getNewTileList(deck);
			for (int i = 0; i < 4; i++) { // loop each player
				doGame(fourPlayers.get(i), tileList4);
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

	private void doGame(Player player, ArrayList<Tile> tileList4) {
		frame = new JFrame();
		displayFrame(frame, player, tileList4); // setVisible(true)
		frame.addMouseListener(new TilePositionListener(tileList4));
		boolean isSuccess = false;
		do {
			wait4PlayerPickAndDropTile();
			isSuccess = playOnSelectGoodTile(player, tileList4, frame);
			resetSelections();
		} while (!isSuccess);
		reset(frame);
	}

	private void wait4PlayerPickAndDropTile() {
		while (chooseTile == 0 || !case1Selected || !case2Selected) {
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void reset(JFrame frame) {
		resetSelections();
		frame.dispose();
	}

	private boolean playOnSelectGoodTile(Player player, ArrayList<Tile> tileList, JFrame frame) {
		if (isEmpty(tileList.get(chooseTile - 1))) {
			JOptionPane.showMessageDialog(null, "You've choose empty tile! Please try again :", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return play(player, tileList, frame);
	}

	private boolean play(Player player, ArrayList<Tile> tileList, JFrame frame) {
		Tile tileEmpty = new Tile(0, 0, 0, '#', '#'); // number=0 is empty tile

		if (player.getBoard().canPlay(tileList.get(chooseTile - 1))) {
			if (dropTile(player, tileList.get(chooseTile - 1))) {
				displayFrame(frame, player, tileList); // setVisible(true)
				JOptionPane.showMessageDialog(null, "\n" + player.getName() + " you now have a score of "
						+ player.getBoard().copy().score() + " points!\n", "Score", JOptionPane.INFORMATION_MESSAGE);
				tileList.set(chooseTile - 1, tileEmpty);
				return true;
			}
			return false;
		}
		JOptionPane.showMessageDialog(null, "The tile you have chosen cannot be placed! So you keep the score of "
				+ player.getBoard().copy().score() + " points!\n", "Score", JOptionPane.INFORMATION_MESSAGE);
		tileList.set(chooseTile - 1, tileEmpty);
		return true;
	}

	private boolean dropTile(Player player, Tile tile) {
		if (player.graphicPlayable(tile, x1, y1, x2, y2)) {
			player.insertTile(tile, x1, y1, x2, y2);
			return true;
		}
		resetSelections();
		return false;
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

	private void displayFrame(JFrame frame, Player player, ArrayList<Tile> tiles) {
		frame.setTitle(player.getName());
		frame.setSize(1080, 720);
		JPanel p = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				PaintBoard(g, player); // draw all images in the board
				displayDomino(g, tiles); // draw tile list
			}
		};
		frame.setBackground(fond);
		frame.add(p);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	private void resetSelections() {
		chooseTile = 0;
		case1Selected = false;
		case2Selected = false;
	}

	private void showWinnerScores(ArrayList<Player> listWinners) {
		Player player1 = listWinners.get(0);
		JOptionPane.showMessageDialog(null, "The big winner is " + player1.getName() + "!\nHe gets a score of "
				+ player1.getScores()[0] + " points!\nIts most extensive property is " + player1.getScores()[1]
				+ "  !\nFinally he owns a total of " + player1.getScores()[2]
				+ " crowns!\n ", "Winner", JOptionPane.INFORMATION_MESSAGE);
	}

	private void showFinalResults() {
		ArrayList<Player> listWinners = getPlayerListOrderedByScores();
		showWinnerScores(listWinners);
		for (int i = 1; i < 4; i++) {
			Player player = listWinners.get(i);
			JOptionPane.showMessageDialog(null, player.getName() + " gets a score of " + player.getScores()[0]
					+ " points!\nIts most extensive property is " + player.getScores()[1]
					+ " !\nFinally he owns a total of " + player.getScores()[2]
					+ " Crowns!\n ", "losing", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private ArrayList<Player> getPlayerListOrderedByScores() {
		ArrayList<Player> list = new ArrayList<>();
		list.add(player1);
		list.add(player2);
		list.add(player3);
		list.add(player4);
		Collections.sort(list);
		return list;
	}

	private ArrayList<Tile> shuffle(ArrayList<Tile> list) {
		Collections.shuffle(list);
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

	private ArrayList<Tile> getNewTileList(ArrayList<Tile> list) {
		ArrayList<Tile> listDominos = new ArrayList<Tile>();
		for (int i = 0; i < 4; i++) {
			listDominos.add(list.get(0));
			list.remove(0);
		}
		Collections.sort(listDominos);
		return listDominos;
	}

	private boolean isEmpty(Tile tile) {
		return (tile.getNumber() == 0);
	}

	public void PaintBoard(Graphics g, Player player) {
		for (int i = 0; i < lengthBoard; i++) {
			for (int j = 0; j < lengthBoard; j++) {
				drawTerrian(g, player, i, j);
				drawCrown(g, player, i, j);
			}
		}
	}

	private void drawCrown(Graphics g, Player player, int i, int j) {
		int numCrowns = player.getBoard().properties[j][i].getCrown();
		g.setColor(Color.BLACK);
		g.drawRect(400 + lengthCase * i, 30 + lengthCase * j, lengthCase, lengthCase);
		if (numCrowns > 0) {
			Font font = new Font("Calibri", Font.PLAIN, 20);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString(String.valueOf(numCrowns), 405 + lengthCase * i, 50 + lengthCase * j);
		}
	}

	private void drawTerrian(Graphics g, Player player, int i, int j) {
		char terrain = player.getBoard().properties[j][i].getTerrain();
		if (terrain == 'C') {
			g.drawImage(player.getCastleImage(), 400 + lengthCase * i, 30 + lengthCase
					* j, lengthCase, lengthCase, null);
			return;
		}
		if (terrain == '#') {
			g.setColor(fond);
			g.fillRect(400 + lengthCase * i, 30 + lengthCase * j, lengthCase, lengthCase);
			return;
		}
		g.drawImage(Tile.getImage(terrain), 400 + lengthCase * i, 30 + lengthCase * j, lengthCase, lengthCase, null);
	}

	private void displayDomino(Graphics g, ArrayList<Tile> list) {
		for (int i = 0; i < list.size(); i++) {
			displayTileNumber(g, list, i);
			drawTerrain(g, list.get(i).getTerrain1(), list.get(i).getCrown1(), i, 0);
			drawTerrain(g, list.get(i).getTerrain2(), list.get(i).getCrown2(), i, 1);
		}
	}

	private void displayTileNumber(Graphics g, ArrayList<Tile> list, int i) {
		Font font = new Font("Calibri", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.DARK_GRAY);
		g.drawString("" + list.get(i).number, 50, 145 + i * 135);
	}

	private void drawTerrain(Graphics g, char terrain, int numCrowns, int i, int j) {
		g.drawImage(Tile.getImage(terrain), 100 + j * 70, 100 + i * 140, null);
		if (numCrowns > 0) {
			g.setColor(Color.WHITE);
			g.drawString(String.valueOf(numCrowns), 105 + j * 70, 120 + i * 140);
		}
	}

	class TilePositionListener implements MouseListener {
		ArrayList<Tile> tileList4;

		public TilePositionListener(ArrayList<Tile> tileList4) {
			this.tileList4 = tileList4;
		}

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			if (x >= 100 && x <= 240) {
				for (int i = 0; i < tileList4.size(); i++) {
					if (y >= 130 + 140 * i && y <= 200 + 140 * i) {
						chooseTile = i + 1;
					}
				}
			}
			if (chooseTile != 0) { // find board row and column that player selected
				for (int i = 0; i < lengthBoard; i++) {
					for (int j = 0; j < lengthBoard; j++) {
						if (x >= 400 + lengthCase * j && x <= 400 + lengthCase * (j + 1)) {
							if (y >= 60 + lengthCase * i && y <= 60 + lengthCase * (i + 1)) {
								if (!case1Selected) {
									x1 = i;
									y1 = j;
									case1Selected = true;
								} else if (!case2Selected) {
									x2 = i;
									y2 = j;
									case2Selected = true;
								}
							}
						}
					}
				}
			}

		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
		}
	}
}