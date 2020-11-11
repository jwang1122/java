package com.huaxia.kingdomino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainGraphics {
	static ArrayList<Tile> list = new Data().getDeck();
	static Image imageF, imageL, imageM, imageP, imageQ, imageW; // tile images

	static {
		try {
			imageF = ImageIO.read(new File("Forest.jpg"));
			imageL = ImageIO.read(new File("Field.jpg"));
			imageM = ImageIO.read(new File("Mine.jpg"));
			imageP = ImageIO.read(new File("Swamp.jpg"));
			imageQ = ImageIO.read(new File("Mountain.jpg"));
			imageW = ImageIO.read(new File("Water.jpg"));
		} catch (IOException e) {
			System.err.println(e);
		}
	}

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
		boolean isSuccess = placeTileInBoard(player, tileList, frame);
		reset(frame);
		return isSuccess;
	}

	private void reset(JFrame frame) {
		chooseTile = 0;
		case1Selected = false;
		case2Selected = false;
		frame.dispose();
	}

	private boolean placeTileInBoard(Player player, ArrayList<Tile> tileList, JFrame frame) {
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
		printClassement4(player1, player2, player3, player4);
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

	private void play(Player player, Tile tile) {
		int nbCases = 8;

		boolean playable = true;
		do {
			while (!case1Selected || !case2Selected) {
				try {
					TimeUnit.MILLISECONDS.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			boolean x1Valid = true;
			boolean y1Valid = true;
			boolean x2Valid = true;
			boolean y2Valid = true;
			int[] info = new int[4];
			do {
				while (!case1Selected || !case2Selected) {
					try {
						TimeUnit.MILLISECONDS.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (x1 >= 0 && x1 <= nbCases) {
					info[0] = x1;
					x1Valid = false;
				} else {
					case1Selected = false;
					case2Selected = false;
				}
			} while (x1Valid);
			do {
				while (!case1Selected || !case2Selected) {
					try {
						TimeUnit.MILLISECONDS.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (y1 >= 0 && y1 <= nbCases) {
					info[1] = y1;
					y1Valid = false;
				} else {
					case1Selected = false;
					case2Selected = false;
				}
			} while (y1Valid);
			do {
				while (!case1Selected || !case2Selected) {
					try {
						TimeUnit.MILLISECONDS.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (x2 >= 0 && x2 <= nbCases) {
					info[2] = x2;
					x2Valid = false;
				} else {
					case1Selected = false;
					case2Selected = false;
				}
			} while (x2Valid);
			do {
				while (!case1Selected || !case2Selected) {
					try {
						TimeUnit.MILLISECONDS.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (y2 >= 0 && y2 <= nbCases) {
					info[3] = y2;
					y2Valid = false;
				} else {
					case1Selected = false;
					case2Selected = false;
				}
			} while (y2Valid);
			if (player.getBoard().graphicPlayable(tile, info[0], info[1], info[2], info[3])) {
				tile.insertTile(player.getBoard(), info[0], info[1], info[2], info[3]);
				playable = false;
			} else {
				case1Selected = false;
				case2Selected = false;
			}
		} while (playable);
	}

	private ArrayList<Player> winner2(Player player1, Player player2) {
		ArrayList<Player> listWinners = new ArrayList<Player>();
		int[] scoresPlayer1 = player1.getScores();
		int[] scoresPlayer2 = player2.getScores();
		int score1 = scoresPlayer1[0];
		int score2 = scoresPlayer2[0];
		int maxField1 = scoresPlayer1[1];
		int maxField2 = scoresPlayer2[1];
		int numCrowns1 = scoresPlayer1[2];
		int numCrowns2 = scoresPlayer2[2];
		if (score1 == score2) {
			if (maxField1 == maxField2) {
				if (numCrowns1 == numCrowns2) {
					listWinners.add(player1);
					listWinners.add(player2);
				} else if (numCrowns1 > numCrowns2) {
					listWinners.add(player1);
				} else {
					listWinners.add(player2);
				}
			} else if (maxField1 > maxField2) {
				listWinners.add(player1);
			} else {
				listWinners.add(player2);
			}
		} else if (score1 > score2) {
			listWinners.add(player1);
		} else {
			listWinners.add(player2);
		}
		return listWinners;
	}

	private ArrayList<Player> winner3(Player player1, Player player2, Player player3) {
		ArrayList<Player> winners = new ArrayList<Player>();
		ArrayList<Player> winnerPlayer1Player2 = winner2(player1, player2);
		if (winnerPlayer1Player2.size() == 2) {
			if (winner2(winnerPlayer1Player2.get(0), player3).size() == 2) {
				winners.add(player1);
				winners.add(player2);
				winners.add(player3);
				return winners;
			} else if (winner2(winnerPlayer1Player2.get(0), player3) == winner2(winnerPlayer1Player2.get(1), player3)) {
				winners.add(player3);
				return winners;
			} else {
				winners.add(player1);
				winners.add(player2);
				return winners;
			}
		} else {
			return winner2(winnerPlayer1Player2.get(0), player3);
		}
	}

	private ArrayList<Player> winner4(Player player1, Player player2, Player player3, Player player4) {
		ArrayList<Player> winners = new ArrayList<Player>();
		ArrayList<Player> winnerPlayer1Player2Player3 = winner3(player1, player2, player3);
		if (winnerPlayer1Player2Player3.size() == 3) {
			if (winner2(winnerPlayer1Player2Player3.get(0), player4).size() == 2) {
				winners.add(player1);
				winners.add(player2);
				winners.add(player3);
				winners.add(player4);
				return winners;
			} else if (winner2(winnerPlayer1Player2Player3.get(0), player4) == winner2(winnerPlayer1Player2Player3.get(1), player4)) {
				winners.add(player4);
				return winners;
			} else {
				winners.add(player1);
				winners.add(player2);
				winners.add(player3);
				return winners;
			}
		} else if (winnerPlayer1Player2Player3.size() == 2) {
			if (winner2(winnerPlayer1Player2Player3.get(0), player4).size() == 2) {
				winners.add(winnerPlayer1Player2Player3.get(0));
				winners.add(winnerPlayer1Player2Player3.get(1));
				winners.add(player4);
				return winners;
			} else if (winner2(winnerPlayer1Player2Player3.get(0), player4) == winner2(winnerPlayer1Player2Player3.get(1), player4)) {
				winners.add(player4);
				return winners;
			} else {
				winners.add(winnerPlayer1Player2Player3.get(0));
				winners.add(winnerPlayer1Player2Player3.get(1));
				return winners;
			}
		} else {
			return winner2(winnerPlayer1Player2Player3.get(0), player4);
		}
	}

	private void printWinners(ArrayList<Player> listWinners) {
		if (listWinners.size() == 1) {
			Player player1 = listWinners.get(0);
			JOptionPane.showMessageDialog(null, "The big winner is " + player1.getName() + "!\nHe gets a score of "
					+ player1.getScores()[0] + " points!\nIts most extensive property is " + player1.getScores()[1]
					+ "  !\nFinally he owns a total of " + player1.getScores()[2]
					+ " crowns!\n ", "Winner", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private void printClassement4(Player player1, Player player2, Player player3, Player player4) {
		ArrayList<Player> listWinners = winner4(player1, player2, player3, player4);
		printWinners(listWinners);

		if (listWinners.size() == 1) {
			if (listWinners.get(0) == player1) {
				JOptionPane.showMessageDialog(null, player2.getName() + " gets a score of " + player2.getScores()[0]
						+ " points!\nIts most extensive property is " + player2.getScores()[1]
						+ " !\nFinally he owns a total of " + player2.getScores()[2] + " Crowns!\n " + player3.getName()
						+ " gets a score of " + player3.getScores()[0] + " points!\nIts most extensive property is "
						+ player3.getScores()[1] + "  !\nFinally he owns a total of" + player3.getScores()[2]
						+ " Crowns!\n " + player4.getName() + " gets a score of " + player4.getScores()[0]
						+ " points!\nIts most extensive property is " + player4.getScores()[1]
						+ " !\nFinally he owns a total of " + player4.getScores()[2]
						+ " Crowns!\n ", "losing", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

	private ArrayList<Tile> shuffle(ArrayList<Tile> list) {
		Collections.shuffle(list);
		return list;
	}

	@SuppressWarnings("unchecked")
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
		int numCrowns = player.getBoard().property[j][i].getCrown();
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
		char terrain = player.getBoard().property[j][i].getTile();
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
		g.drawImage(getImage(terrain), 400 + lengthCase * i, 30 + lengthCase * j, lengthCase, lengthCase, null);
	}

	private Image getImage(char value) {
		switch (value) {
		case 'P':
			return imageP;
		case 'Q':
			return imageQ;
		case 'F':
			return imageF;
		case 'L':
			return imageL;
		case 'W':
			return imageW;
		case 'M':
			return imageM;
		}
		return null;
	}

	public void displayDomino(Graphics g, ArrayList<Tile> list) {
		for (int i = 0; i < list.size(); i++) {
			Font font = new Font("Calibri", Font.BOLD, 20);
			g.setFont(font);
			g.setColor(Color.DARK_GRAY);
			g.drawString(""+list.get(i).number, 50, 145+i*135);
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
					g.drawImage(getImage(terrain), 100 + j * 70, 100 + i * 140, obs);
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
			play(player, tileList.get(chooseTile - 1));
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