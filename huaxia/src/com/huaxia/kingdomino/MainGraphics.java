package com.huaxia.kingdomino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainGraphics {
	static ArrayList<Tile> list = new Data().getDeck();

	static final int lengthCase = 70;
	static final int lengthBoard = 9;
	static final int numDominos = 48;

	Player player1 = new Player(Player.PlayerColor.BluePlayer);
	Player player2 = new Player(Player.PlayerColor.GreenPlayer);
	Player player3 = new Player(Player.PlayerColor.YellowPlayer);
	Player player4 = new Player(Player.PlayerColor.RedPlayer);
	ArrayList<Player> fourPlayers = shufflePlayers();
	ArrayList<Tile> deck = shuffle(list);
	int chooseTile;
	boolean case1Selected, case2Selected = false;
	int x1, x2, y1, y2; // tile1 and tile2 grid positions
	Color fond = new Color(238, 231, 188);
	int roundNum = 1;

	public static void main(String[] args) {
		//		new Menu(null, "Menu", true);
		MainGraphics kingdomino = new MainGraphics();
		//		JOptionPane.showMessageDialog(null, "Start of the game :\n", "Start", JOptionPane.INFORMATION_MESSAGE);
		kingdomino.startPlay();
	}

	private void startPlay() {
		while (deck.size() != 0) {
			showPlayOrder(roundNum);
			ArrayList<Tile> tileList = getNewTileList(deck);
			for (int i = 0; i < 4; i++) {
				boolean isSuccess = false;
				do {
					isSuccess = doGame(fourPlayers.get(i), tileList);
				} while (!isSuccess);
			}
			fourPlayers = shufflePlayers();
			roundNum += 1;
		}
		showGameResult();
	}

	private void showPlayOrder(int roundNum) {
		JOptionPane.showMessageDialog(null, "Round " + roundNum + ":\nPlayers will start in this order :\n"
				+ fourPlayers.get(0).getName() + ", " + fourPlayers.get(1).getName() + ", "
				+ fourPlayers.get(2).getName() + ", "
				+ fourPlayers.get(3).getName(), "Round", JOptionPane.INFORMATION_MESSAGE);
	}

	private boolean doGame(Player player, ArrayList<Tile> tileList) {
		JFrame frame = new JFrame();
		displayFrame(frame, player, sortTile(tileList)); // setVisible(true)
		frame.addMouseListener(new TilePositionListener(tileList));
		waitForPlayerChooseTile();
		boolean isSuccess = playOnSelectGoodTile(player, tileList, frame);
		reset(frame);
		return isSuccess;
	}

	private void reset(JFrame frame) {
		chooseTile = 0;
		case1Selected = false;
		case2Selected = false;
		frame.dispose();
	}

	private boolean playOnSelectGoodTile(Player player, ArrayList<Tile> tileList, JFrame frame) {
		if (!isEmpty(tileList.get(chooseTile - 1))) {
			play(player, tileList, frame);
			return true;
		}
		JOptionPane.showMessageDialog(null, "This tile cannot be taken ! Please try again :", "Error", JOptionPane.INFORMATION_MESSAGE);
		return false;
	}

	private void waitForPlayerChooseTile() {
		while (chooseTile == 0) {
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void showGameResult() {
		player1.setScores();
		player2.setScores();
		player3.setScores();
		player4.setScores();
		showFinalResults();
		JOptionPane.showMessageDialog(null, "Game Over!", "Over", JOptionPane.INFORMATION_MESSAGE);
	}

	private void displayFrame(JFrame frame, Player player, ArrayList<Tile> tiles) {
		frame.setTitle(player.getName());
		frame.setSize(1080, 720);
		JPanel p = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				DeckTray(g, player); // draw all images in the board
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

	private void waitForPlayerSelect2Locations() {
		while (!case1Selected || !case2Selected) {
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleSelectedTile(Player player, Tile tile) {
		boolean success = false;
		do {
			waitForPlayerSelect2Locations();
			checkForValidLocations();
			success = dropTile(player, tile);
		} while (!success);
	}

	private void checkForValidLocations() {
		boolean valid = false;
		do {
			waitForPlayerSelect2Locations();
			if (x1 >= 0 && x1 < lengthBoard && y1 >= 0 && y1 < lengthBoard && x2 >= 0 && x2 < lengthBoard && y2 >= 0
					&& y2 < lengthBoard) {
				valid = true;
			} else {
				case1Selected = false;
				case2Selected = false;
			}
		} while (!valid);
	}

	private boolean dropTile(Player player, Tile tile) {
		if (player.graphicPlayable(tile, x1, y1, x2, y2)) {
			player.insertTile(tile, x1, y1, x2, y2);
			return true;
		}
		case1Selected = false;
		case2Selected = false;
		return false;
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
		for(int i=1; i<4; i++) {
			Player player = listWinners.get(i);
				JOptionPane.showMessageDialog(null, player.getName() + " gets a score of " + player.getScores()[0]
						+ " points!\nIts most extensive property is " + player.getScores()[1]
						+ " !\nFinally he owns a total of " + player.getScores()[2] + " Crowns!\n ", "losing", JOptionPane.INFORMATION_MESSAGE);
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

	private ArrayList<Tile> sortTile(ArrayList<Tile> list) {
		if (numEmptyTile(list) > list.size() - 2) {
			return list;
		}
		Collections.sort(list);
		return list;
	}

	private int numEmptyTile(ArrayList<Tile> list) {
		int numEmptyTile = 0;
		for (int i = 0; i < list.size(); i++) {
			if (isEmpty(list.get(i))) {
				numEmptyTile += 1;
			}
		}
		return numEmptyTile;
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
		return listDominos;
	}

	private boolean isEmpty(Tile tile) {
		return (tile.getNumber() == 0 && tile.getCrown1() == 0 && tile.getCrown2() == 0 && tile.getTile1() == '#'
				&& tile.getTile2() == '#');
	}

	public void DeckTray(Graphics g, Player player) {
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
		char terrain = player.getBoard().properties[j][i].getTile();
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
		g.drawImage(Tile.getImage(terrain), 400 + lengthCase * i, 30 + lengthCase
				* j, lengthCase, lengthCase, null);
	}

	private void displayDomino(Graphics g, ArrayList<Tile> list) {
		for (int i = 0; i < list.size(); i++) {
			Font font = new Font("Calibri", Font.BOLD, 20);
			g.setFont(font);
			g.setColor(Color.DARK_GRAY);
			g.drawString("" + list.get(i).number, 50, 145 + i * 135);
			for (int j = 0; j < 2; j++) {
				char terrain;
				int numCrowns;
				ImageObserver obs = null;
				if (j == 0) {
					terrain = list.get(i).getTile1();
					numCrowns = list.get(i).getCrown1();
				} else {
					terrain = list.get(i).getTile2();
					numCrowns = list.get(i).getCrown2();
				}
				if (terrain == '#') {
					g.setColor(new Color(188, 181, 138));
					g.fillRect(100 + j * 70, 100 + i * 140, 70, 70);
				} else {
					g.drawImage(Tile.getImage(terrain), 100 + j * 70, 100 + i * 140, obs);
				}
				if (numCrowns > 0) {
					g.setColor(Color.WHITE);
					g.drawString(String.valueOf(numCrowns), 105 + j * 70, 120 + i * 140);
				}
			}
		}
	}

	private boolean play(Player player, ArrayList<Tile> tileList, JFrame frame) {
		Tile tileEmpty = new Tile(0, 0, 0, '#', '#'); // number=0 is empty tile

		if (player.getBoard().canPlay(tileList.get(chooseTile - 1))) {
			handleSelectedTile(player, tileList.get(chooseTile - 1));
			displayFrame(frame, player, sortTile(tileList)); // setVisible(true)
			JOptionPane.showMessageDialog(null, "\n" + player.getName() + " you now have a score of "
					+ player.getBoard().copy().score() + " points!\n", "Score", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "The tile you have chosen cannot be placed! So you keep the score of "
					+ player.getBoard().copy().score() + " points!\n", "Score", JOptionPane.INFORMATION_MESSAGE);
		}
		tileList.set(chooseTile - 1, tileEmpty);
		return true;
	}

	class TilePositionListener implements MouseListener {
		ArrayList<Tile> tileList;

		public TilePositionListener(ArrayList<Tile> tileList) {
			this.tileList = tileList;
		}

		public void mousePressed(MouseEvent e) {

			int x = e.getX();
			int y = e.getY();
			//			System.out.println("mouse at (" + x + ", " + y + ")");
			if (x >= 100 && x <= 240) {
				for (int i = 0; i < tileList.size(); i++) {
					if (y >= 130 + 140 * i && y <= 200 + 140 * i) {
						chooseTile = i + 1;
					}
				}
			}
			if (chooseTile != 0) {
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