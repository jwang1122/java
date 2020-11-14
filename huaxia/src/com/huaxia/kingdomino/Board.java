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

	public Board(int size) {
		this.size = size;
		this.properties = new Property[size][size];
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				properties[line][column] = new Property(new Position(line, column), Terrain.emptyTerrain);
				;
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
		ArrayList<Position> fieldList = this.getFieldList();
		for (int i = 0; i < fieldList.size(); i++) {
			ArrayList<Position> frameList = frame(fieldList.get(i));
			for (int j = 0; j < frameList.size(); j++) {
				ArrayList<Position> nextToCase = nextToCase(frameList.get(j).row, frameList.get(j).column);
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
		if (!placed(position1, position2)) {
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
		if (!placed(position1, position2)) {
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
		insertTile(Tile.emptyTile, position1, position2);
		return true;
	}

	private boolean isOutOf5X5Field(Tile tile, Position position1, Position position2) {
		insertTile(tile, position1, position2); // try put the tile in the location first
		ArrayList<Position> fieldList = getFieldList();
		if (fieldList.size() == 0) {
			insertTile(Tile.emptyTile, position1, position2);
			return true;
		}
		return false;
	}

	private boolean isAdjacentHaveNoSameTerrain(Tile tile, Position position1, Position position2) {
		insertTile(tile, position1, position2); // try put the tile in the location first
		ArrayList<Position> nextToCase1 = deleteNextTo(nextToCastle(position1), position2);
		ArrayList<Position> nextToCase2 = deleteNextTo(nextToCastle(position2), position1);
		if (nextToCase1.size() + nextToCase2.size() <= 0) {
			insertTile(Tile.emptyTile, position1, position2);
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

	public boolean placed(Position position1, Position position2) {
		if (position1.row == position2.row) {
			if (position1.column == position2.column - 1 || position1.column == position2.column + 1) {
				return true;
			}
		} else if (position1.column == position2.column) {
			if (position1.row == position2.row - 1 || position1.row == position2.row + 1) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Position> nextToCase(int row, int column) {
		ArrayList<Position> list = new ArrayList<>();
		if (row - 1 >= 0) {
			Position pos = new Position(row - 1, column);
			list.add(pos);
		}
		if (column + 1 <= size - 1) {
			Position pos = new Position(row, column + 1);
			list.add(pos);
		}
		if (row + 1 <= size - 1) {
			Position pos = new Position(row + 1, column);
			list.add(pos);
		}
		if (column - 1 >= 0) {
			Position pos = new Position(row, column - 1);
			list.add(pos);
		}
		return list;
	}

	public int score() {
		Property[][] myProperties = deepClone();
		int score = 0;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (myProperties[row][column].isOccupied()) {
					int numCrowns = 0;
					int nbCases = 0;
					// find all linked terrain location
					ArrayList<Position> pack = findLinkedTerrainPositions(new Position(row, column));
					for (int compteur = 0; compteur < pack.size(); compteur++) {
						nbCases += 1;
						numCrowns += myProperties[pack.get(compteur).row][pack.get(compteur).column].getNumOfCrowns();
						// get number of linked terrains, and total number of Crowns
						// create empty property, and set all calculated terrain to be empty
						Property property = new Property(pack.get(compteur), Terrain.emptyTerrain);
						myProperties[pack.get(compteur).row][pack.get(compteur).column] = property;
					}
					score += nbCases * numCrowns;
				}
			}
		}
		return score;
	}

	private ArrayList<Position> nextToCastle(Position position) {
		int row = position.row;
		int column = position.column;
		ArrayList<Position> list = new ArrayList<>();
		if ((row - 1 >= 0) && (properties[row][column].isSameTerrain(properties[row - 1][column]) || properties[row
				- 1][column].isCastle())) {
			Position pos = new Position(row - 1, column);
			list.add(pos);
		}
		if ((column + 1 <= size - 1) && (properties[row][column].isSameTerrain(properties[row][column + 1])
				|| properties[row][column + 1].isCastle())) {
			Position pos = new Position(row, column + 1);
			list.add(pos);
		}
		if ((row + 1 <= size - 1) && (properties[row][column].isSameTerrain(properties[row + 1][column])
				|| properties[row + 1][column].isCastle())) {
			Position pos = new Position(row + 1, column);
			list.add(pos);
		}
		if ((column - 1 >= 0) && (properties[row][column].isSameTerrain(properties[row][column - 1])
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
		if ((position.row - 1 >= 0) && (properties[row][column].isSameTerrain(properties[row - 1][column]))) {
			Position pos = new Position(row - 1, column);
			list.add(pos);
		}
		if ((column + 1 <= size - 1) && (properties[row][column].isSameTerrain(properties[row][column + 1]))) {
			Position pos = new Position(row, column + 1);
			list.add(pos);
		}
		if ((row + 1 <= size - 1) && (properties[row][column].isSameTerrain(properties[row + 1][column]))) {
			Position pos = new Position(row + 1, column);
			list.add(pos);
		}
		if ((column - 1 >= 0) && (properties[row][column].isSameTerrain(properties[row][column - 1]))) {
			Position pos = new Position(row, column - 1);
			list.add(pos);
		}
		return list;
	}

	private ArrayList<Position> findLinkedTerrainPositions(Position position) {
		ArrayList<Position> list = new ArrayList<>();
		list.add(position);
		int nbCases = 0;
		while (nbCases != list.size()) {
			ArrayList<Position> next = findNearBySameTerrainPositions(list.get(nbCases));
			for (int compteur = 0; compteur < next.size(); compteur++) {
				if (!list.contains(next.get(compteur))) {
					list.add(next.get(compteur));
				}
			}
			nbCases += 1;
		}
		return list;
	}

	public int maxField() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (properties[row][column].isOccupied()) {
					ArrayList<Position> listPaquet = findLinkedTerrainPositions(new Position(row, column));
					list.add(listPaquet.size());
					for (int compteur = 0; compteur < listPaquet.size(); compteur++) {
						properties[listPaquet.get(compteur).row][listPaquet.get(compteur).column].setTerrain(Terrain.emptyTerrain);
					}
				}
			}
		}
		return max(list);
	}

	private int max(ArrayList<Integer> list) {
		int max = list.get(0);
		for (int compteur = 0; compteur < list.size(); compteur++) {
			if (list.get(compteur) > max) {
				max = list.get(compteur);
			}
		}
		return max;
	}

	public int numCrowns() {
		int numCrowns = 0;
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				numCrowns += properties[line][column].getNumOfCrowns();
			}
		}
		return numCrowns;
	}

	/**
	 * FieldList is 5X5 terrain location which cannot exceed, 
	 * the terrain can only be placed within this area. 
	 * 
	 * @return
	 */
	private ArrayList<Position> getFieldList() {
		ArrayList<Position> fieldList = new ArrayList<>();
		ArrayList<Position> listPos = this.getOccupaidPositionList();
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

	private ArrayList<Position> getOccupaidPositionList() {
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

	public void insertTile(Tile tile, Position position1, Position position2) {
		Property case1 = new Property(position1, tile.terrain1);
		Property case2 = new Property(position2, tile.terrain2);
		setcase(case1);
		setcase(case2);
	}

	public void draw(Graphics g, Image castleImage) {
		for (int i = 0; i < lengthBoard; i++) {
			for (int j = 0; j < lengthBoard; j++) {
				properties[i][j].draw(g, castleImage);
			}
		}
	}
}