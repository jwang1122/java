package com.huaxia.kingdomino;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import com.huaxia.kingdomino.Message.MsgType;
import com.huaxia.kingdomino.Terrain.TerrainImage;

public class Board {
	static final int lengthCase = 70;
	static final int lengthBoard = 9;
	int size;
	Property[][] properties;
	int maxLinkedTerrains = 0;
	int totalCrowns = 0;
	int leftColumn = 4;
	int rightColumn = 4;
	int topRow = 4;
	int bottomRow = 4;
	Player player;

	public Board(Player player, int size) {
		this.player = player;
		this.size = size;
		this.properties = new Property[size][size];
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				properties[line][column] = new Property(new Position(line, column), Terrain.emptyTerrain);
			}
		}
		Property castle = new Property(new Position(size / 2, size / 2), new Terrain(TerrainImage.CASTLE, 0));
		setcase(castle);
	}

	public Property[][] deepClone() {
		Property[][] result = new Property[properties.length][];
		for (int i = 0; i < properties.length; i++) {
			result[i] = Arrays.copyOf(properties[i], properties.length);
		}
		return result;
	}

	public void setcase(Property property) {
		properties[property.getRow()][property.getColumn()] = property;
	}

	public int calculateScore() {
		Property[][] workingProperties = deepClone(); // will be damaged while calculating.
		maxLinkedTerrains = 0;
		totalCrowns = 0;
		int score = 0;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (workingProperties[row][column].isOccupied()) {
					int numCrowns = 0;
					// find all linked terrain locations
					ArrayList<Position> pack = findLinkedTerrainPositions(new Position(row, column));
					if (pack.size() > maxLinkedTerrains) {
						maxLinkedTerrains = pack.size();
					}
					for (int i = 0; i < pack.size(); i++) {
						Position pos = pack.get(i);
						// get number of linked terrains, and total number of Crowns
						numCrowns += workingProperties[pos.row][pos.column].getNumOfCrowns();
						// create empty property, and set all calculated terrain to be empty
						// must create new property, cannot set the property's terrain, otherwise the original
						// properties will be damaged.
						Property property = new Property(pos, Terrain.emptyTerrain);
						workingProperties[pos.row][pos.column] = property;
					}
					score += pack.size() * numCrowns;
					totalCrowns += numCrowns;
				}
			}
		}
		return score;
	}

	// find out whether if there has same terrain include castle around give position
	private ArrayList<Position> getAjacentPositionList(Property property) {
		int row = property.getRow();
		int column = property.getColumn();
		ArrayList<Position> list = new ArrayList<>();
		if ((row > 0) && (property.isSameTerrain(properties[row - 1][column]) || properties[row
				- 1][column].isCastle())) {
			Position pos = new Position(row - 1, column);
			list.add(pos);
		}
		if ((column < size - 1) && (property.isSameTerrain(properties[row][column + 1])
				|| properties[row][column + 1].isCastle())) {
			Position pos = new Position(row, column + 1);
			list.add(pos);
		}
		if ((row < size - 1) && (property.isSameTerrain(properties[row + 1][column]) || properties[row
				+ 1][column].isCastle())) {
			Position pos = new Position(row + 1, column);
			list.add(pos);
		}
		if ((column > 0) && (property.isSameTerrain(properties[row][column - 1])
				|| properties[row][column - 1].isCastle())) {
			Position pos = new Position(row, column - 1);
			list.add(pos);
		}
		return list;
	}

	// smart way to find all linked terrains position for calculate score
	private ArrayList<Position> findLinkedTerrainPositions(Position position) {
		Position castlePosition = new Position(4,4);
		ArrayList<Position> list = new ArrayList<>();
		list.add(position);
		int nbCases = 0;
		while (nbCases != list.size()) {
			Position pos = list.get(nbCases);
			Property property = properties[pos.row][pos.column];
			ArrayList<Position> linkedPosition = getAjacentPositionList(property);
			for (int i = 0; i < linkedPosition.size(); i++) {
				Position p = linkedPosition.get(i);
				if (!p.equals(castlePosition) && !list.contains(p)) {
					list.add(p);
				}
			}
			nbCases += 1;
		}
		return list;
	}

	public Message insertDomino(Player player, Domino domino, Position pos1, Position pos2) {
		Message msg = null;
		if (isDiagonal(pos1, pos2)) {
			msg = new Message(player, MsgType.DIAGONAL, calculateScore());
			return msg;
		}
		if (isOccupied(pos1, pos2)) {
			msg = new Message(player, MsgType.OCCUPIED, calculateScore());
			return msg;
		}
		if (isOutOf5X5Frame(pos1, pos2)) {
			msg = new Message(player, MsgType.OUTSIDE_FRAME, calculateScore());
			return msg;
		}
		if (!hasSameTerrainAround(domino, pos1, pos2)) {
			msg = new Message(player, MsgType.NO_SAME_TERRAIN, calculateScore());
			return msg;
		}
		setcase(new Property(pos1, domino.terrain1));
		setcase(new Property(pos2, domino.terrain2));
		msg = new Message(player, MsgType.SUCCESS, calculateScore());
		adjustFrameBound(pos1, pos2);
		return msg;
	}

	private void adjustFrameBound(Position pos1, Position pos2) {
		adjustFrameBoundByPosition(pos1);
		adjustFrameBoundByPosition(pos2);
	}

	private void adjustFrameBoundByPosition(Position pos) {
		if (topRow > pos.row) {
			topRow = pos.row;
		}
		if (bottomRow < pos.row) {
			bottomRow = pos.row;
		}
		if (leftColumn > pos.column) {
			leftColumn = pos.column;
		}
		if (rightColumn < pos.column) {
			rightColumn = pos.column;
		}
		
	}

	boolean isDiagonal(Position position1, Position position2) {
		if (position1.row == position2.row) {
			if (position1.column == position2.column - 1 || position1.column == position2.column + 1) {
				return false;
			}
		}
		if (position1.column == position2.column) {
			if (position1.row == position2.row - 1 || position1.row == position2.row + 1) {
				return false;
			}
		}
		return true;
	}

	boolean isOccupied(Position pos1, Position pos2) {
		return properties[pos1.row][pos1.column].isOccupied() || properties[pos2.row][pos2.column].isOccupied();
	}

	boolean isOutOf5X5Frame(Position pos1, Position pos2) {
		int left = adjustLeft(leftColumn, pos1, pos2);
		int right = adjustRight(rightColumn, pos1, pos2);
		int top = adjustTop(topRow, pos1, pos2);
		int bottom = adjustBottom(bottomRow, pos1, pos2);
		return right - left + 1 > 5 || bottom - top + 1 > 5;
	}

	private int adjustBottom(int bottom, Position pos1, Position pos2) {
		if (bottom < pos1.row) {
			bottom = pos1.row;
		}
		if (bottom < pos2.row) {
			bottom = pos2.row;
		}
		return bottom;
	}

	private int adjustTop(int top, Position pos1, Position pos2) {
		if (top > pos1.row) {
			top = pos1.row;
		}
		if (top > pos2.row) {
			top = pos2.row;
		}
		return top;
	}

	private int adjustRight(int right, Position pos1, Position pos2) {
		if (right < pos1.column) {
			right = pos1.column;
		}
		if (right < pos2.column) {
			right = pos2.column;
		}
		return right;
	}

	private int adjustLeft(int left, Position pos1, Position pos2) {
		if (left > pos1.column) {
			left = pos1.column;
		}
		if (left > pos2.column) {
			left = pos2.column;
		}
		return left;
	}

	boolean hasSameTerrainAround(Domino domino, Position pos1, Position pos2) {
		Property property1 = new Property(pos1, domino.terrain1);
		Property property2 = new Property(pos2, domino.terrain2);
		ArrayList<Position> list = getAjacentPositionList(property1);
		if (list.size() > 0) {
			return true;
		}
		list = getAjacentPositionList(property2);
		return list.size() > 0;
	}

	public void draw(Graphics g, Image castleImage) {
		for (int i = 0; i < lengthBoard; i++) {
			for (int j = 0; j < lengthBoard; j++) {
				properties[i][j].draw(g, castleImage);
			}
		}
	}
}