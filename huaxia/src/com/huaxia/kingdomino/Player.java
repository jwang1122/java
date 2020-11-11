package com.huaxia.kingdomino;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Player {
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

	int[] scores = new int[3];
	String name;
	Board board;
	Image castleImage;
	String message;

	public Player(PlayerColor color) {
		setAttributes(color);
//		name = JOptionPane.showInputDialog(null, message, "Players", JOptionPane.QUESTION_MESSAGE);
		if(name==null || name.length()==0) {
			name=color.toString();
		}
		board = new Board(boardSize);
		scores = new int[3];
	}

	private void setAttributes(PlayerColor color) {
		switch (color) {
		case BluePlayer:
			castleImage = imageblueC;
			message = "Blue player's name";
			break;
		case GreenPlayer:
			castleImage = imagegreenC;
			message = "Green player's name";
			break;
		case YellowPlayer:
			castleImage = imageyellowC;
			message = "Yellow player's name";
			break;
		case RedPlayer:
			castleImage = imageredC;
			message = "Red player's name";
			break;
		}
	}

	public int[] getScores() {
		return this.scores;
	}

	public void setScores() {
		this.scores[0] = board.copy().score();
		this.scores[1] = board.maxField();
		this.scores[2] = board.numCrowns();
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
		int[] scores = { 0, 0, 0 };
		this.scores = scores;
		this.name = name;
		this.board = board;

	}

	public int choosetile(ArrayList<Tile> deck, int[] crowns) {
		int choice = 0;
		int value = 0;
		for (int domino = 0; domino < deck.size(); domino++) {
			if (value < deck.get(domino).evaluate(crowns)) {
				value = deck.get(domino).evaluate(crowns);
				choice = domino;
			}
		}
		return choice;
	}

	public int[] choosemove(Tile tile) {
		int[] choice = new int[4];
		choice[0] = -1;
		choice[3] = -1;
		int score = -1;
		char[][] totest = this.getBoard().copy().playable(tile, 1);
		int size = totest.length;
		int currentscore = -1;
		for (int column = 0; column < size; column++) {
			for (int line = 0; line < size; line++) {
				if (totest[column][line] == 'O') {
					if (this.getBoard().playable(tile, line, column, line + 1, column)) {
						Board board = this.getBoard().copy();
						tile.insertTile(board, line, column, line + 1, column);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = line;
							choice[1] = column;
							choice[2] = line + 1;
							choice[3] = column;
						}
					}
					if (this.getBoard().playable(tile, line, column, line - 1, column)) {
						Board board = this.getBoard().copy();
						tile.insertTile(board, line, column, line - 1, column);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = line;
							choice[1] = column;
							choice[2] = line - 1;
							choice[3] = column;
						}
					}
					if (this.getBoard().playable(tile, line, column, line, column + 1)) {
						Board board = this.getBoard().copy();
						tile.insertTile(board, line, column, line, column + 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = line;
							choice[1] = column;
							choice[2] = line;
							choice[3] = column + 1;
						}
					}
					if (this.getBoard().playable(tile, line, column, line, column - 1)) {
						Board board = this.getBoard().copy();
						tile.insertTile(board, line, column, line, column - 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = line;
							choice[1] = column;
							choice[2] = line;
							choice[3] = column - 1;

						}
					}
				}
			}
		}
		totest = this.getBoard().copy().playable(tile, 2);
		size = totest.length;
		for (int column = 0; column < size; column++) {
			for (int line = 0; line < size; line++) {
				if (totest[column][line] == 'O') {
					if (this.getBoard().playable(tile, line, column, line + 1, column)) {
						Board board = this.getBoard().copy();
						tile.insertTile(board, line, column, line + 1, column);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = line;
							choice[1] = column;
							choice[2] = line + 1;
							choice[3] = column;
						}
					}
					if (this.getBoard().playable(tile, line, column, line - 1, column)) {
						Board board = this.getBoard().copy();
						tile.insertTile(board, line, column, line - 1, column);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = line;
							choice[1] = column;
							choice[2] = line - 1;
							choice[3] = column;
						}
					}
					if (this.getBoard().playable(tile, line, column, line, column + 1)) {
						Board board = this.getBoard().copy();
						tile.insertTile(board, line, column, line, column + 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = line;
							choice[1] = column;
							choice[2] = line;
							choice[3] = column + 1;
						}
					}
					if (this.getBoard().playable(tile, line, column, line, column - 1)) {
						Board board = this.getBoard().copy();
						tile.insertTile(board, line, column, line, column - 1);
						currentscore = board.score();
						if (currentscore >= score) {
							score = currentscore;
							choice[0] = line;
							choice[1] = column;
							choice[2] = line;
							choice[3] = column - 1;

						}
					}
				}
			}
		}
		return choice;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}

	public void setNewScore() {
		this.scores[0] = board.copy().score();
		this.scores[1] = board.maxField();
		this.scores[2] = board.numCrowns();
	}

}