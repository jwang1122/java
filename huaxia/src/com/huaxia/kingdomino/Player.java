package com.huaxia.kingdomino;

import java.awt.Graphics;
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

	int score;
	int maxField;
	int crowns;
	String name;
	Board board;
	Image castleImage;

	public Player(PlayerColor color, String name) {
		setAttributes(color);
		this.name = name;
		if(name==null || name.length()==0) {
			this.name=color.toString();
		}
		board = new Board(boardSize);
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
		if(score==other.score) {
			if(maxField==other.maxField) {
				if(crowns==other.crowns) {
					return 0;
				}
				return score>other.score?-1:1;
			}
			return maxField>other.maxField?-1:1;
		}
		return score>other.score?-1:1;
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

	public boolean graphicPlayable(Domino tile, Position position1, Position position2) {
		return board.graphicPlayable(tile, position1, position2);
	}

	public void insertTile(Domino tile, Position position1, Position position2) {
		board.insertDomino(tile, position1, position2);		
	}

}