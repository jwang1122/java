package com.huaxia.kingdomino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.huaxia.kingdomino.Message.MsgType;

public class Player implements Comparable<Player> {
	enum PlayerColor {
		BluePlayer, GreenPlayer, YellowPlayer, RedPlayer
	};

	static final int boardSize = 9;
	static Image imageredC, imageblueC, imagegreenC, imageyellowC; // castle images
	static {
		try {
			imageredC = ImageIO.read(new File("redC.png"));
			imageblueC = ImageIO.read(new File("blueC.png"));
			imagegreenC = ImageIO.read(new File("greenC.png"));
			imageyellowC = ImageIO.read(new File("yellowC.png"));
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	Color fond = new Color(238, 231, 188);

	int score;
	int maxField;
	int crowns;
	String name;
	Board board;
	Image castleImage;
	JFrame frame;
	int choosenDomino = 0;
	boolean case1Selected, case2Selected = false;
	Position position1, position2; // terrain1 and terrain2 grid positions
	JPanel previous;
	JPanel mainPanel;
	ArrayList<Domino> dominoList4;

	public Player(PlayerColor color, String name) {
		setAttributes(color);
		this.name = name;
		if (name == null || name.length() == 0) {
			this.name = color.toString();
		}
		board = new Board(this, boardSize);
		buildFrame();
	}

	private void buildFrame() {
		frame = new JFrame();
		mainPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				drawBoard(g);
				displayDominoList(g);
			}
		};
		frame.setBackground(fond);
		frame.add(mainPanel);
		frame.addMouseListener(new DominoPositionListener());
		frame.setTitle(name);
		frame.setSize(1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}

	private boolean playOnSelectGoodDomino(ArrayList<Domino> dominoList4, JFrame frame) {
		if (isEmpty(dominoList4.get(choosenDomino - 1))) {
			JOptionPane.showMessageDialog(null, "You've choosen empty domino! Please try again :", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return play(dominoList4, frame);
	}

	void doGame(ArrayList<Domino> dominoList4) {
		this.dominoList4 = dominoList4;
		displayFrame(); // setVisible(true)
		boolean isSuccess = false;
		do {
			wait4PlayerPickAndDropDomino();
			isSuccess = playOnSelectGoodDomino(dominoList4, frame);
			resetSelectedCases();
		} while (!isSuccess);
		reset();
	}

	private boolean isEmpty(Domino domino) {
		return (domino.getNumber() == 0);
	}

	private boolean play(ArrayList<Domino> dominoList, JFrame frame) {
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
			return true;
		}
		return msg.success;
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

	private void resetSelectedCases() {
		case1Selected = false;
		case2Selected = false;
	}

	void displayFrame() {
		mainPanel.repaint();
		frame.setVisible(true);
	}

	private void displayDominoList(Graphics g) {
		if (dominoList4 == null)
			return;
		for (int i = 0; i < dominoList4.size(); i++) {
			displayDominoNumber(g, dominoList4, i);
			drawTerrain(g, dominoList4.get(i).getTerrain1(), i, 0);
			drawTerrain(g, dominoList4.get(i).getTerrain2(), i, 1);
		}
	}

	private void displayDominoNumber(Graphics g, ArrayList<Domino> list, int i) {
		Font font = new Font("Calibri", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.DARK_GRAY);
		int number = list.get(i).number;
		if (number != 0)
			g.drawString("" + number, 50, 145 + i * 135);
	}

	private void drawTerrain(Graphics g, Terrain terrain, int i, int j) {
		g.drawImage(Terrain.getImage(terrain.image), 100 + j * 70, 100 + i * 140, null);
		if (terrain.numberOfCrowns > 0) {
			g.setColor(Color.WHITE);
			g.drawString(String.valueOf(terrain.numberOfCrowns), 105 + j * 70, 120 + i * 140);
		}
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

	public Player(String name, Board board) {
		this.name = name;
		this.board = board;

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

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			if (x >= 100 && x <= 240) {
				for (int i = 0; i < 4; i++) {
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

	public void reset() {
		case1Selected = false;
		case2Selected = false;
		frame.setVisible(false);
	}

}