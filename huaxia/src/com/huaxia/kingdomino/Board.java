package com.huaxia.kingdomino;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

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

	public Board(int size) {
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

	public boolean canPlay(Tile tile) {
		ArrayList<Position> fieldList = this.get5X5FieldList();
		for (int i = 0; i < fieldList.size(); i++) {
			ArrayList<Position> frameList = frame(fieldList.get(i));
			for (int j = 0; j < frameList.size(); j++) {
				ArrayList<Position> nextToCase = getNearbyPositionList(frameList.get(j).row, frameList.get(j).column);
				ArrayList<Position> delNextToCase = delNextToCase(fieldList.get(i), nextToCase);
				if (delNextToCase.size() > 0) {
					for (int elt = 0; elt < delNextToCase.size(); elt++) {
						if (this.playable(tile, frameList.get(j), delNextToCase.get(elt))) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private boolean playable(Tile tile, Position position1, Position position2) {
		if (isDiagonal(position1, position2)) {
			return false;
		}
		if (properties[position1.row][position1.column].isOccupied()
				|| properties[position2.row][position2.column].isOccupied()) {
			return false;
		}
		if (!possible(tile, position1, position2)) {
			return false;
		}
		return true;
	}

	public boolean graphicPlayable(Tile tile, Position position1, Position position2) {
		if (position1.equals(position2)) {
			JOptionPane.showMessageDialog(null, "You cannot play on a single square!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (isDiagonal(position1, position2)) {
			JOptionPane.showMessageDialog(null, "The entered coordinates correspond to boxes not pasted!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if ((properties[position1.row][position1.column].isOccupied())
				|| (properties[position2.row][position2.column].isOccupied())) {
			JOptionPane.showMessageDialog(null, "The entered coordinate has already taken!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (isOutOf5X5Field(tile, position1, position2)) {
			JOptionPane.showMessageDialog(null, "The input coordinates go beyond the  framework!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (isAdjacentHaveNoSameTerrain(tile, position1, position2)) {
			JOptionPane.showMessageDialog(null, "Adjacent squares do not have  the same type!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean possible(Tile tile, Position position1, Position position2) {
		if (isOutOf5X5Field(tile, position1, position2)) {
			return false;
		}
		if (isAdjacentHaveNoSameTerrain(tile, position1, position2)) {
			return false;
		}
		removeDomino(position1, position2);
		return true;
	}

	private boolean isOutOf5X5Field(Tile tile, Position position1, Position position2) {
		insertDomino(tile, position1, position2); // try put the tile in the location first
		ArrayList<Position> fieldList = get5X5FieldList();
		if (fieldList.size() == 0) {
			removeDomino(position1, position2);
			return true;
		}
		return false;
	}

	private boolean isAdjacentHaveNoSameTerrain(Tile tile, Position position1, Position position2) {
		insertDomino(tile, position1, position2); // try put the tile in the location first
		ArrayList<Position> nextToCase1 = deleteNextTo(getAjacentPositionList(position1), position2);
		ArrayList<Position> nextToCase2 = deleteNextTo(getAjacentPositionList(position2), position1);
		if (nextToCase1.size() + nextToCase2.size() <= 0) {
			removeDomino(position1, position2);
			return true;
		}
		return false;
	}

	public ArrayList<Position> delNextToCase(Position position, ArrayList<Position> nextToCase) {
		ArrayList<Position> frame = frame(position);
		for (int i = 0; i < nextToCase.size(); i++) {
			Position pos = new Position(nextToCase.get(i).row, nextToCase.get(i).column);
			if (!frame.contains(pos)) {
				nextToCase.remove(i);
			}
		}
		return nextToCase;
	}

	public ArrayList<Position> deleteNextTo(ArrayList<Position> nextTo, Position position) {
		for (int i = 0; i < nextTo.size(); i++) {
			if (position.equals(nextTo.get(i))) {
				nextTo.remove(i);
			}
		}
		return nextTo;
	}

	private boolean isDiagonal(Position position1, Position position2) {
		if (position1.row == position2.row) {
			if (position1.column == position2.column - 1 || position1.column == position2.column + 1) {
				return false;
			}
		} else if (position1.column == position2.column) {
			if (position1.row == position2.row - 1 || position1.row == position2.row + 1) {
				return false;
			}
		}
		return true;
	}

	private ArrayList<Position> getNearbyPositionList(int row, int column) {
		ArrayList<Position> list = new ArrayList<>();
		if (row > 0) {
			Position pos = new Position(row - 1, column);
			list.add(pos);
		}
		if (column < size - 1) {
			Position pos = new Position(row, column + 1);
			list.add(pos);
		}
		if (row < size - 1) {
			Position pos = new Position(row + 1, column);
			list.add(pos);
		}
		if (column > 0) {
			Position pos = new Position(row, column - 1);
			list.add(pos);
		}
		return list;
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

	private ArrayList<Position> getAjacentPositionList(Position position) {
		int row = position.row;
		int column = position.column;
		ArrayList<Position> list = new ArrayList<>();
		if ((row > 0) && (properties[row][column].isSameTerrain(properties[row - 1][column]) || properties[row
				- 1][column].isCastle())) {
			Position pos = new Position(row - 1, column);
			list.add(pos);
		}
		if ((column < size - 1) && (properties[row][column].isSameTerrain(properties[row][column + 1])
				|| properties[row][column + 1].isCastle())) {
			Position pos = new Position(row, column + 1);
			list.add(pos);
		}
		if ((row < size - 1) && (properties[row][column].isSameTerrain(properties[row + 1][column]) || properties[row
				+ 1][column].isCastle())) {
			Position pos = new Position(row + 1, column);
			list.add(pos);
		}
		if ((column > 0) && (properties[row][column].isSameTerrain(properties[row][column - 1])
				|| properties[row][column - 1].isCastle())) {
			Position pos = new Position(row, column - 1);
			list.add(pos);
		}
		return list;
	}

	private ArrayList<Position> findNearBySameTerrainPositions(Position position) {
		ArrayList<Position> list = new ArrayList<>();
		int row = position.row;
		int column = position.column;
		if ((row > 0) && (properties[row][column].isSameTerrain(properties[row - 1][column]))) {
			Position pos = new Position(row - 1, column);
			list.add(pos);
		}
		if ((column < size - 1) && (properties[row][column].isSameTerrain(properties[row][column + 1]))) {
			Position pos = new Position(row, column + 1);
			list.add(pos);
		}
		if ((row < size - 1) && (properties[row][column].isSameTerrain(properties[row + 1][column]))) {
			Position pos = new Position(row + 1, column);
			list.add(pos);
		}
		if ((column > 0) && (properties[row][column].isSameTerrain(properties[row][column - 1]))) {
			Position pos = new Position(row, column - 1);
			list.add(pos);
		}
		return list;
	}

	// smart way to find all linked terrains position
	private ArrayList<Position> findLinkedTerrainPositions(Position position) {
		ArrayList<Position> list = new ArrayList<>();
		list.add(position);
		int nbCases = 0;
		while (nbCases != list.size()) {
			ArrayList<Position> next = findNearBySameTerrainPositions(list.get(nbCases));
			for (int i = 0; i < next.size(); i++) {
				if (!list.contains(next.get(i))) {
					list.add(next.get(i));
				}
			}
			nbCases += 1;
		}
		return list;
	}

	private ArrayList<Position> get5X5FieldList() {
		ArrayList<Position> fieldList = new ArrayList<>();
		ArrayList<Position> listPos = this.getOccupiedPositionList();
		for (int row = 0; row < (size / 2 + 1); row++) {
			for (int column = 0; column < (size / 2 + 1); column++) {
				Position pos = new Position(row, column);
				if (allIn(pos, listPos)) {
					fieldList.add(pos);
				}
			}
		}
		return fieldList;
	}

	private ArrayList<Position> getOccupiedPositionList() {
		ArrayList<Position> list = new ArrayList<>();
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				if (properties[line][column].isOccupied()) {
					Position pos = new Position(line, column);
					list.add(pos);
				}
			}
		}
		return list;
	}

	private boolean allIn(Position position, ArrayList<Position> listPos) {
		ArrayList<Position> frameList = this.frame(position);
		for (int compteur = 0; compteur < listPos.size(); compteur++) {
			if (!frameList.contains(listPos.get(compteur))) {
				return false;
			}
		}
		return true;
	}

	// return all positions within the frame by given left-top position
	private ArrayList<Position> frame(Position topLeft) {
		ArrayList<Position> list = new ArrayList<>();
		for (int row = topLeft.row; row < topLeft.row + (size + 1) / 2; row++) {
			for (int column = topLeft.column; column < topLeft.column + (size + 1) / 2; column++) {
				Position pos = new Position(row, column);
				list.add(pos);
			}
		}
		return list;
	}

	public void insertDomino(Tile tile, Position position1, Position position2) {
		Property case1 = new Property(position1, tile.terrain1);
		Property case2 = new Property(position2, tile.terrain2);
		setcase(case1);
		setcase(case2);
	}

	public void removeDomino(Position position1, Position position2) {
		Property case1 = new Property(position1, Terrain.emptyTerrain);
		Property case2 = new Property(position2, Terrain.emptyTerrain);
		setcase(case1);
		setcase(case2);
	}

	boolean isOutOf5X5Frame(Position pos1, Position pos2) {
		int left = leftColumn;
		int right = rightColumn;
		int top = topRow;
		int bottom = bottomRow;
		if (left > pos1.column) {
			left = pos1.column;
		}
		if (left > pos2.column) {
			left = pos2.column;
		}
		if (right < pos1.column) {
			right = pos1.column;
		}
		if (right < pos2.column) {
			right = pos2.column;
		}
		if (top > pos1.row) {
			top = pos1.column;
		}
		if (top > pos2.column) {
			top = pos2.column;
		}
		if (bottom < pos1.column) {
			bottom = pos1.column;
		}
		if (bottom < pos2.column) {
			bottom = pos2.column;
		}
		return right - left + 1 > 5 || bottom - top + 1 > 5;
	}

	public void draw(Graphics g, Image castleImage) {
		for (int i = 0; i < lengthBoard; i++) {
			for (int j = 0; j < lengthBoard; j++) {
				properties[i][j].draw(g, castleImage);
			}
		}
	}
}