package com.huaxia.kingdomino;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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

	int[] scores = new int[3];
	String name;
	Board board;
	Image castleImage;
	String message;

	public Player(PlayerColor color, String name) {
		setAttributes(color);
		this.name = name;
		if(name==null || name.length()==0) {
			this.name=color.toString();
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
		this.scores[0] = board.score();
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

	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	@Override
	public int compareTo(Player other) {
		if(scores[0]==other.scores[0]) {
			if(scores[1]==other.scores[1]) {
				if(scores[2]==other.scores[2]) {
					return 0;
				}
				return scores[2]>other.scores[2]?-1:1;
			}
			return scores[1]>other.scores[1]?-1:1;
		}
		return scores[0]>other.scores[0]?-1:1;
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

	public boolean graphicPlayable(Tile tile, Position position1, Position position2) {
		return board.graphicPlayable(tile, position1, position2);
	}

	public void insertTile(Tile tile, Position position1, Position position2) {
		board.insertTile(tile, position1, position2);		
	}

}