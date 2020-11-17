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

import com.huaxia.kingdomino.Message.MsgType;

public class Kingdomino {
	static ArrayList<Domino> deck = new Deck().getDeck();
	static final int numDominos = 48;

	Player player1;
	Player player2;
	Player player3;
	Player player4;
	ArrayList<Player> fourPlayers;
	int choosenDomino = 0;
	boolean case1Selected, case2Selected = false;
	Position position1, position2; // terrain1 and terrain2 grid positions
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
			ArrayList<Domino> dominoList4 = getNewDominoListFromDeck();
			for (int i = 0; i < 4; i++) { // loop each player
				doGame(fourPlayers.get(i), dominoList4);
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

	private void doGame(Player player, ArrayList<Domino> dominoList4) {
		frame = new JFrame();
		displayFrame(frame, player, dominoList4); // setVisible(true)
		frame.addMouseListener(new DominoPositionListener(dominoList4));
		boolean isSuccess = false;
		do {
			wait4PlayerPickAndDropDomino();
			isSuccess = playOnSelectGoodDomino(player, dominoList4, frame);
			resetSelectedCases();
		} while (!isSuccess);
		reset(frame);
	}

	private void wait4PlayerPickAndDropDomino() {
		while (choosenDomino == 0 || !case1Selected || !case2Selected) {
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void reset(JFrame frame) {
		choosenDomino = 0;
		resetSelectedCases();
		frame.dispose();
	}

	private boolean playOnSelectGoodDomino(Player player, ArrayList<Domino> dominoList4, JFrame frame) {
		if (isEmpty(dominoList4.get(choosenDomino - 1))) {
			JOptionPane.showMessageDialog(null, "You've choosen empty domino! Please try again :", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return play(player, dominoList4, frame);
	}

	private boolean play(Player player, ArrayList<Domino> dominoList, JFrame frame) {
		Domino domino = dominoList.get(choosenDomino - 1);
		Message msg = player.insertDomino(domino, position1, position2);
		if (msg.type == MsgType.DIAGONAL || msg.type == MsgType.OCCUPIED) {
			JOptionPane.showMessageDialog(null, msg.msg, "Score", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		boolean giveUp = false;
		if (msg.type == MsgType.OUTSIDE_FRAME || msg.type == MsgType.NO_SAME_TERRAIN) {
			int option = JOptionPane.showInternalConfirmDialog(null, msg.msg, "Error", JOptionPane.YES_NO_OPTION);
			giveUp = option == 1;
		}
		if (msg.success || giveUp) {
			dominoList.set(choosenDomino - 1, Domino.emptyDomino);
			displayFrame(frame, player, dominoList);
			if (msg.success)
				JOptionPane.showMessageDialog(null, msg.msg, "Score", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		return msg.success;
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

	private void displayFrame(JFrame frame, Player player, ArrayList<Domino> dominoList4) {
		frame.setTitle(player.getName());
		frame.setSize(1080, 720);
		JPanel p = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				player.drawBoard(g);
				displayDominoList(g, dominoList4); // draw domino list
			}
		};
		frame.setBackground(fond);
		frame.add(p);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	private void resetSelectedCases() {
		case1Selected = false;
		case2Selected = false;
	}

	private void showWinnerScores(ArrayList<Player> listWinners) {
		Player player1 = listWinners.get(0);
		JOptionPane.showMessageDialog(null, "The big winner is " + player1.getName() + "!\nHe gets a score of "
				+ player1.score + " points!\nIts most extensive property is " + player1.maxField
				+ "  !\nFinally he owns a total of " + player1.crowns
				+ " crowns!\n ", "Winner", JOptionPane.INFORMATION_MESSAGE);
	}

	private void showFinalResults() {
		ArrayList<Player> listWinners = getPlayerListOrderedByScores();
		showWinnerScores(listWinners);
		for (int i = 1; i < 4; i++) {
			Player player = listWinners.get(i);
			JOptionPane.showMessageDialog(null, player.getName() + " gets a score of " + player.score
					+ " points!\nIts most extensive property is " + player.maxField + " !\nFinally he owns a total of "
					+ player.crowns + " Crowns!\n ", "losing", JOptionPane.INFORMATION_MESSAGE);
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

	private boolean isEmpty(Domino domino) {
		return (domino.getNumber() == 0);
	}

	private void displayDominoList(Graphics g, ArrayList<Domino> list) {
		for (int i = 0; i < list.size(); i++) {
			displayDominoNumber(g, list, i);
			drawTerrain(g, list.get(i).getTerrain1(), i, 0);
			drawTerrain(g, list.get(i).getTerrain2(), i, 1);
		}
	}

	private void displayDominoNumber(Graphics g, ArrayList<Domino> list, int i) {
		Font font = new Font("Calibri", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.DARK_GRAY);
		g.drawString("" + list.get(i).number, 50, 145 + i * 135);
	}

	private void drawTerrain(Graphics g, Terrain terrain, int i, int j) {
		g.drawImage(Terrain.getImage(terrain.image), 100 + j * 70, 100 + i * 140, null);
		if (terrain.numberOfCrowns > 0) {
			g.setColor(Color.WHITE);
			g.drawString(String.valueOf(terrain.numberOfCrowns), 105 + j * 70, 120 + i * 140);
		}
	}

	class DominoPositionListener implements MouseListener {
		ArrayList<Domino> dominoList4;

		public DominoPositionListener(ArrayList<Domino> dominoList4) {
			this.dominoList4 = dominoList4;
		}

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			if (x >= 100 && x <= 240) {
				for (int i = 0; i < dominoList4.size(); i++) {
					if (y >= 130 + 140 * i && y <= 200 + 140 * i) {
						choosenDomino = i + 1;
					}
				}
			}
			if (choosenDomino != 0) { // find board row and column that player selected
				for (int i = 0; i < Board.lengthBoard; i++) {
					for (int j = 0; j < Board.lengthBoard; j++) {
						if (x >= 400 + Board.lengthCase * j && x <= 400 + Board.lengthCase * (j + 1)) {
							if (y >= 60 + Board.lengthCase * i && y <= 60 + Board.lengthCase * (i + 1)) {
								if (!case1Selected) {
									position1 = new Position(i, j);
									case1Selected = true;
								} else if (!case2Selected) {
									position2 = new Position(i, j);
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