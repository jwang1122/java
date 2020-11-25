package com.huaxia.kingdomino;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.huaxia.kingdomino.Message.MsgType;

public class Player implements Comparable<Player> {
	enum PlayerColor {
		BluePlayer, GreenPlayer, YellowPlayer, RedPlayer
	};

	static final int boardSize = 9;
	static Image imageredC, imageblueC, imagegreenC, imageyellowC, goldMedal; // castle images
	static {
		try {
			InputStream is = Player.class.getResourceAsStream("redC.png");
			imageredC = ImageIO.read(is);
			is = Player.class.getResourceAsStream("blueC.png");
			imageblueC = ImageIO.read(is);
			is = Player.class.getResourceAsStream("greenC.png");
			imagegreenC = ImageIO.read(is);
			is = Player.class.getResourceAsStream("yellowC.png");
			imageyellowC = ImageIO.read(is);
			is = Player.class.getResourceAsStream("goldmedal.jpg");
			goldMedal = ImageIO.read(is);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	Color bgColor = new Color(238, 231, 188);

	int score;
	int maxField;
	int crowns;
	String name;
	Board board;
	Image castleImage;
	PlayerBoardPanel playerPanel;
	JSplitPane mainPane;
	DominoPanel dominoPanel = new DominoPanel();
	int choosenDomino = 0;
	boolean position1Selected, position2Selected = false;
	Position position1, position2; // terrain1 and terrain2 grid positions
	JPanel previous;
	ArrayList<Domino> dominoList4;
	Kingdomino kingdomino;
	Player player;

	public Player(PlayerColor color) {
		setAttributes(color);
		name = color.toString();
		board = new Board(this, boardSize);
		playerPanel = new PlayerBoardPanel(this);
		player = this;
	}

	void doGame(Kingdomino kingdomino, ArrayList<Domino> dominoList4) {
		this.kingdomino = kingdomino;
		this.dominoList4 = dominoList4;
		displayPanel(kingdomino);
		boolean isSuccess = false;
		do {
			wait4PlayerPickAndDropDomino();
			isSuccess = playOnSelectGoodDomino(dominoList4);
			resetSelectedCases();
		} while (!isSuccess);
		reset();
	}

	private boolean playOnSelectGoodDomino(ArrayList<Domino> dominoList4) {
		if (isEmpty(dominoList4.get(choosenDomino - 1))) {
			JOptionPane.showMessageDialog(null, "You've choosen empty domino! Please try again :", "Error",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return play(dominoList4);
	}

	JSplitPane buildMainPane(ArrayList<Domino> dominoList) {
		this.dominoList4 = dominoList;
		dominoPanel.setBackground(bgColor);
		dominoPanel.setDominoList(dominoList4);
		mainPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, dominoPanel, playerPanel);
		mainPane.setSize(Kingdomino.frameSize);
		mainPane.setDividerLocation(Kingdomino.dividerLocation);
		mainPane.setBackground(bgColor);
		mainPane.addMouseListener(new DominoPositionListener());
		return mainPane;
	}

	public void displayPanel(Kingdomino kingdomino) {
		kingdomino.setVisible(false);
		kingdomino.add(mainPane);
		kingdomino.setVisible(true);
//		mainPane.repaint();
	}

	private boolean isEmpty(Domino domino) {
		return (domino.getNumber() == 0);
	}

	private boolean play(ArrayList<Domino> dominoList) {
		Domino domino = dominoList.get(choosenDomino - 1);
		Message msg = insertDomino(domino, position1, position2);
		if (msg.type == MsgType.DIAGONAL || msg.type == MsgType.OCCUPIED) {
			JOptionPane.showMessageDialog(null, msg.msg, "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		boolean giveUp = false;
		if (msg.type == MsgType.OUTSIDE_FRAME || msg.type == MsgType.NO_SAME_TERRAIN) {
			int option = JOptionPane.showInternalConfirmDialog(null, msg.msg, "Error", JOptionPane.YES_NO_OPTION);
			giveUp = option == 1;
		}
		if (msg.success || giveUp) {
			dominoList.set(choosenDomino - 1, Domino.emptyDomino);
			displayFrame();
			if (msg.success)
				JOptionPane.showMessageDialog(null, msg.msg, "Score", JOptionPane.INFORMATION_MESSAGE);
			kingdomino.setPlayer(this, choosenDomino-1);
			return true;
		}
		return msg.success;
	}

	private void wait4PlayerPickAndDropDomino() {
		while (choosenDomino == 0 || !position1Selected || !position2Selected) {
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void resetSelectedCases() {
		position1Selected = false;
		position2Selected = false;
	}

	void displayFrame() {
		mainPane.repaint();
//		frame.setVisible(true);
	}

	private void setAttributes(PlayerColor color) {
		switch (color) {
		case BluePlayer:
			castleImage = imageblueC;
			break;
		case GreenPlayer:
			castleImage = imagegreenC;
			break;
		case YellowPlayer:
			castleImage = imageyellowC;
			break;
		case RedPlayer:
			castleImage = imageredC;
			break;
		}
	}

	public void drawBoard(Graphics g) {
		board.draw(g, castleImage);
	}

	public void setScores() {
		score = board.calculateScore();
		crowns = board.totalCrowns;
		maxField = board.maxLinkedTerrains;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Image getCastleImage() {
		return castleImage;
	}

	public void setCastleImage(Image castleImage) {
		this.castleImage = castleImage;
	}

	public int getScore() {
		return score;
	}

	public int getMaxField() {
		return maxField;
	}

	public int getCrowns() {
		return crowns;
	}

	public PlayerBoardPanel getPlayerPanel() {
		return playerPanel;
	}

	public JSplitPane getMainPane() {
		return mainPane;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}

	@Override
	public int compareTo(Player other) {
		if (score == other.score) {
			if (maxField == other.maxField) {
				if (crowns == other.crowns) {
					return 0;
				}
				return score > other.score ? -1 : 1;
			}
			return maxField > other.maxField ? -1 : 1;
		}
		return score > other.score ? -1 : 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Message insertDomino(Domino domino, Position position1, Position position2) {
		return board.insertDomino(this, domino, position1, position2);
	}

	class DominoPositionListener implements MouseListener {
		int listLeftSpacing = DominoPanel.leftSpacing;
		int terrainWidth = DominoPanel.terrainWidth;
		int listTopSpacing = DominoPanel.topSpacing;
		int listRowSpacing = DominoPanel.rowSpacing;
		int boardLeftSpacing = (int) (PlayerBoardPanel.leftSpacing + Kingdomino.frameWidth * Kingdomino.dividerLocation);
		int boardTopSpacing = PlayerBoardPanel.topSpacing;

		public void mousePressed(MouseEvent e) {
			if (kingdomino==null || !kingdomino.currentPlayer.equals(player)) {
				JOptionPane.showMessageDialog(null, "Please wait for your turn.");
				return;
			}
			int x = e.getX();
			int y = e.getY();
			if (x >= listLeftSpacing && x <= listLeftSpacing + 2 * terrainWidth) {
				for (int row = 0; row < 4; row++) {
					if (y >= DominoPanel.topSpacing + listRowSpacing * row
							&& y <= listTopSpacing + listRowSpacing * row + terrainWidth) {
						choosenDomino = row + 1;
						break;
					}
				}
			}
			if (choosenDomino != 0 && x > boardLeftSpacing) { // find board row and column that player selected
				for (int row = 0; row < Board.lengthBoard; row++) {
					for (int column = 0; column < Board.lengthBoard; column++) {
						if (x >= boardLeftSpacing + terrainWidth * column
								&& x <= boardLeftSpacing + terrainWidth * (column + 1)) {
							if (y >= boardTopSpacing + terrainWidth * row
									&& y <= boardTopSpacing + terrainWidth * (row + 1)) {
								if (!position1Selected) {
									position1 = new Position(row, column);
									position1Selected = true;
								} else if (!position2Selected) {
									position2 = new Position(row, column);
									position2Selected = true;
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

	public void reset() {
		position1Selected = false;
		position2Selected = false;
	}

	public void setStatus(String status) {
		dominoPanel.setStatus(status);	
	}

	public Message buildMessage() {
		return new Message(this, MsgType.PLAYER_RESULT, score, maxField, crowns);
	}
	
	public Message buildWinnerMessage() {
		return new Message(this, MsgType.WINNER_RESULT, score, maxField, crowns);
	}

	public void showWinner() {
		dominoPanel.showWinner(this);
	}

	public void showScore() {
		dominoPanel.showScore(this);		
	}

}