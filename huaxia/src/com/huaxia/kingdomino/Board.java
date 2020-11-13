package com.huaxia.kingdomino;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Board {
	int size;
	Property[][] properties;

	public Board(int size) {
		this.size = size;
		this.properties = new Property[size][size];
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				Property tile = new Property(line, column, 0, '#');
				properties[line][column] = tile;
			}
		}
		Property castle = new Property(size / 2, size / 2, 0, 'C');
		setcase(castle);
	}

	public int getsize() {
		return this.size;
	}

	public Property[][] getProperties() {
		return this.properties;
	}

	/**
	 * used by Tile class.
	 * 
	 * @param tile
	 */
	public void setcase(Property tile) {
		int x = tile.getRow();
		int y = tile.getColumn();
		properties[x][y] = tile;
	}

	/**
	 * used by MainGraphics class.
	 * 
	 * @param tile
	 * @return
	 */
	public boolean canPlay(Tile tile) {
		properties = this.getProperties();
		ArrayList<Integer[]> fieldList = this.getFieldList();
		for (int i = 0; i < fieldList.size(); i++) {
			ArrayList<Integer[]> frameList = frame(fieldList.get(i)[0], fieldList.get(i)[1]);
			for (int j = 0; j < frameList.size(); j++) {
				ArrayList<Integer[]> nextToCase = nextToCase(frameList.get(j)[0], frameList.get(j)[1]);
				ArrayList<Integer[]> delNextToCase = delNextToCase(fieldList.get(i)[0], fieldList.get(i)[1], nextToCase);
				if (delNextToCase.size() > 0) {
					for (int elt = 0; elt < delNextToCase.size(); elt++) {
						if (this.playable(tile, frameList.get(j)[0], frameList.get(j)[1], delNextToCase.get(elt)[0], delNextToCase.get(elt)[1])) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private boolean playable(Tile tile, int x1, int y1, int x2, int y2) {
		if ((x1 < 0 || x1 > size - 1) || (y1 < 0 || y1 > size - 1) || (x2 < 0 || x2 > size - 1) || (y2 < 0 || y2 > size
				- 1)) {
			return false;
		}
		if (!placed(x1, y1, x2, y2)) {
			return false;
		}
		if (properties[x1][y1].getTerrain() != '#' || properties[x2][y2].getTerrain() != '#') {
			return false;
		}
//		if(isOutOf5X5Field(tile, x1, y1, x2, y2)) {
//			return false;
//		}
//		if(isAdjacentHaveNoSameTerrain(tile, x1, y1, x2, y2)) {
//			return false;
//		}
		if (!possible(tile, x1, y1, x2, y2)) {
			return false;
		}
		return true;
	}

	public boolean graphicPlayable(Tile tile, int x1, int y1, int x2, int y2) {
		if ((x1 < 0 || x1 > size - 1) || (y1 < 0 || y1 > size - 1) || (x2 < 0 || x2 > size - 1) || (y2 < 0 || y2 > size
				- 1)) {
			System.out.println(String.format("size=%d, (%d, %d) (%d, %d)", size, x1, y1, x2, y2));
			JOptionPane.showMessageDialog(null, "The input coordinates go beyond the playing field!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (x1 == x2 && y1 == y2) {
			JOptionPane.showMessageDialog(null, "You cannot play on a single square!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (!placed(x1, y1, x2, y2)) {
			JOptionPane.showMessageDialog(null, "The entered coordinates correspond to boxes not pasted!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (isOccupied(properties[x1][y1]) || isOccupied(properties[x2][y2])) {
			JOptionPane.showMessageDialog(null, "The entered coordinate has already taken!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (isOutOf5X5Field(tile, x1, y1, x2, y2)) {
			JOptionPane.showMessageDialog(null, "The input coordinates go beyond the  framework!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if(isAdjacentHaveNoSameTerrain(tile, x1, y1, x2, y2)) {
			JOptionPane.showMessageDialog(null, "Adjacent squares do not have  the same type!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean possible(Tile tile, int x1, int y1, int x2, int y2) {
		insertTile(tile, x1, y1, x2, y2);
		Tile tileEmpty = new Tile(0, 0, 0, '#', '#');
		ArrayList<Integer[]> fieldList = getFieldList();
		if (fieldList.size() == 0) {
			insertTile(tileEmpty, x1, y1, x2, y2);
			return false;
		}
		ArrayList<Integer[]> nextToCase1 = deleteNextTo(nextToCastle(x1, y1), x2, y2);
		ArrayList<Integer[]> nextToCase2 = deleteNextTo(nextToCastle(x2, y2), x1, y1);
		if (nextToCase1.size() + nextToCase2.size() <= 0) {
			insertTile(tileEmpty, x1, y1, x2, y2);
			return false;
		}
		insertTile(tileEmpty, x1, y1, x2, y2);
		return true;
	}


	private boolean isOutOf5X5Field(Tile tile, int x1, int y1, int x2, int y2) {
		insertTile(tile, x1, y1, x2, y2); // try put the tile in the location first
		Tile tileEmpty = new Tile(0, 0, 0, '#', '#');
		ArrayList<Integer[]> fieldList = getFieldList();
		if (fieldList.size() == 0) {
			insertTile(tileEmpty, x1, y1, x2, y2);
			return true;
		}
		return false;
	}

	private boolean isAdjacentHaveNoSameTerrain(Tile tile, int x1, int y1, int x2, int y2) {
		insertTile(tile, x1, y1, x2, y2); // try put the tile in the location first
		Tile tileEmpty = new Tile(0, 0, 0, '#', '#');
		ArrayList<Integer[]> nextToCase1 = deleteNextTo(nextToCastle(x1, y1), x2, y2);
		ArrayList<Integer[]> nextToCase2 = deleteNextTo(nextToCastle(x2, y2), x1, y1);
		if (nextToCase1.size() + nextToCase2.size() <= 0) {
			insertTile(tileEmpty, x1, y1, x2, y2);
			return true;
		}
		return false;
	}

	public ArrayList<Integer[]> delNextToCase(Integer x, Integer y, ArrayList<Integer[]> nextToCase) {
		ArrayList<Integer[]> frame = frame(x, y);
		for (int i = 0; i < nextToCase.size(); i++) {
			Integer[] pos = { nextToCase.get(i)[0], nextToCase.get(i)[1] };
			if (!In(frame, pos)) {
				nextToCase.remove(i);
			}
		}
		return nextToCase;
	}

	public ArrayList<Integer[]> deleteNextTo(ArrayList<Integer[]> nextTo, int x, int y) {
		for (int i = 0; i < nextTo.size(); i++) {
			if (x == nextTo.get(i)[0] && y == nextTo.get(i)[1]) {
				nextTo.remove(i);
			}
		}
		return nextTo;
	}

	public boolean placed(int x1, int y1, int x2, int y2) {
		if (x1 == x2) {
			if (y1 == y2 - 1 || y1 == y2 + 1) {
				return true;
			}
		} else if (y1 == y2) {
			if (x1 == x2 - 1 || x1 == x2 + 1) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Integer[]> nextToCase(int line, int column) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		properties = this.getProperties();
		size = this.getsize();
		if (line - 1 >= 0) {
			Integer[] pos = { line - 1, column };
			list.add(pos);
		}
		if (column + 1 <= size - 1) {
			Integer[] pos = { line, column + 1 };
			list.add(pos);
		}
		if (line + 1 <= size - 1) {
			Integer[] pos = { line + 1, column };
			list.add(pos);
		}
		if (column - 1 >= 0) {
			Integer[] pos = { line, column - 1 };
			list.add(pos);
		}
		return list;
	}

//	/**
//	 * look for 5X5 field border (occupiedLeft, occupiedRight, occupiedTop, occupiedBottom)
//	 * 
//	 * @return
//	 */
//	private void findOccupiedBounds() {
//		occupiedLeft = size / 2;
//		occupiedRight = size / 2;
//		occupiedTop = size / 2;
//		occupiedBottom = size / 2;
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < size; j++) {
//				if (isOccupied(properties[i][j])) {
//					if (occupiedLeft >= i) {
//						occupiedLeft = i;
//					}
//					if (occupiedRight <= i) {
//						occupiedRight = i;
//					}
//					if (occupiedTop >= j) {
//						occupiedTop = j;
//					}
//					if (occupiedBottom <= j) {
//						occupiedBottom = j;
//					}
//				}
//			}
//		}
//		System.out.println(String.format("rowMin:%d, rowMax:%d; columnMin:%d, columnMax:%d", occupiedLeft, occupiedRight, occupiedTop, occupiedBottom));
//	}

	private boolean isOccupied(Property property) {
		return property.terrain != '#';
	}

	public int score() {
		Board board = this;
		properties = board.getProperties();
		int length = board.getsize();
		int score = 0;
		for (int line = 0; line < length; line++) {
			for (int column = 0; column < length; column++) {
				if (properties[line][column].getTerrain() != '#') {
					int numCrowns = 0;
					int nbCases = 0;
					ArrayList<Integer[]> pack = board.paquet(line, column);
					for (int compteur = 0; compteur < pack.size(); compteur++) {
						nbCases += 1;
						numCrowns += properties[pack.get(compteur)[0]][pack.get(compteur)[1]].getCrown();
						Property tile = new Property(pack.get(compteur)[0], pack.get(compteur)[1], properties[pack.get(compteur)[0]][pack.get(compteur)[1]].getCrown(), '#');
						board.setcase(tile);
					}
					score += nbCases * numCrowns;
				}
			}
		}
		return score;
	}

	
	// Why doing this?!
	public Board copy() {
//		properties = getProperties(); //junk code
//		size = getsize();
		Board terrain = new Board(size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				terrain.setcase(properties[i][j]);
			}
		}
		return terrain;
	}

	private ArrayList<Integer[]> nextToCastle(int line, int column) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		properties = this.getProperties();
		size = this.getsize();
		if ((line - 1 >= 0) && (properties[line][column].getTerrain() == properties[line - 1][column].getTerrain()
				|| properties[line - 1][column].getTerrain() == 'C')) {
			Integer[] pos = { line - 1, column };
			list.add(pos);
		}
		if ((column + 1 <= size - 1) && (properties[line][column].getTerrain() == properties[line][column + 1].getTerrain()
				|| properties[line][column + 1].getTerrain() == 'C')) {
			Integer[] pos = { line, column + 1 };
			list.add(pos);
		}
		if ((line + 1 <= size - 1) && (properties[line][column].getTerrain() == properties[line + 1][column].getTerrain()
				|| properties[line + 1][column].getTerrain() == 'C')) {
			Integer[] pos = { line + 1, column };
			list.add(pos);
		}
		if ((column - 1 >= 0) && (properties[line][column].getTerrain() == properties[line][column - 1].getTerrain()
				|| properties[line][column - 1].getTerrain() == 'C')) {
			Integer[] pos = { line, column - 1 };
			list.add(pos);
		}
		return list;
	}

	private ArrayList<Integer[]> nextTo(int line, int column) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		properties = this.getProperties();
		size = this.getsize();
		if ((line - 1 >= 0) && (properties[line][column].getTerrain() == properties[line - 1][column].getTerrain())) {
			Integer[] pos = { line - 1, column };
			list.add(pos);
		}
		if ((column + 1 <= size - 1) && (properties[line][column].getTerrain() == properties[line][column
				+ 1].getTerrain())) {
			Integer[] pos = { line, column + 1 };
			list.add(pos);
		}
		if ((line + 1 <= size - 1) && (properties[line][column].getTerrain() == properties[line + 1][column].getTerrain())) {
			Integer[] pos = { line + 1, column };
			list.add(pos);
		}
		if ((column - 1 >= 0) && (properties[line][column].getTerrain() == properties[line][column - 1].getTerrain())) {
			Integer[] pos = { line, column - 1 };
			list.add(pos);
		}
		return list;
	}

	private ArrayList<Integer[]> paquet(int line, int column) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		Integer[] pos = { line, column };
		list.add(pos);
		int nbCases = 0;
		while (nbCases != list.size()) {
			ArrayList<Integer[]> next = this.nextTo(list.get(nbCases)[0], list.get(nbCases)[1]);
			for (int compteur = 0; compteur < next.size(); compteur++) {
				if (!(In(list, next.get(compteur)))) {
					list.add(next.get(compteur));
				}
			}
			nbCases += 1;
		}
		return list;
	}

	private boolean In(ArrayList<Integer[]> list, Integer[] pos) {
		for (int compteur = 0; compteur < list.size(); compteur++) {
			if ((list.get(compteur)[0] == pos[0]) && (list.get(compteur)[1] == pos[1])) {
				return true;
			}
		}
		return false;
	}

	public int maxField() {
		properties = this.getProperties();
		size = this.getsize();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				if (isOccupied(properties[line][column])) {
					ArrayList<Integer[]> listPaquet = paquet(line, column);
					list.add(listPaquet.size());
					for (int compteur = 0; compteur < listPaquet.size(); compteur++) {
						properties[listPaquet.get(compteur)[0]][listPaquet.get(compteur)[1]].setTerrain('#');
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
		properties = this.getProperties();
		size = this.getsize();
		int numCrowns = 0;
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				numCrowns += properties[line][column].getCrown();
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
	private ArrayList<Integer[]> getFieldList() {
		ArrayList<Integer[]> fieldList = new ArrayList<Integer[]>();
		ArrayList<Integer[]> listPos = this.getOccupaidPositionList();
		for (int line = 0; line < (size / 2 + 1); line++) {
			for (int column = 0; column < (size / 2 + 1); column++) {
				if (allIn(line, column, listPos)) {
					Integer[] pos = { line, column };
					fieldList.add(pos);
				}
			}
		}
		return fieldList;
	}

	private ArrayList<Integer[]> getOccupaidPositionList() {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				if (properties[line][column].getTerrain() != '#') {
					Integer[] pos = { line, column };
					list.add(pos);
				}
			}
		}
		return list;
	}

	private boolean allIn(int line, int column, ArrayList<Integer[]> listPos) {
		ArrayList<Integer[]> frameList = this.frame(line, column);
		for (int compteur = 0; compteur < listPos.size(); compteur++) {
			if (!(In(frameList, listPos.get(compteur)))) {
				return false;
			}
		}
		return true;
	}

	private ArrayList<Integer[]> frame(Integer borderline, Integer borderColonne) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		for (int line = borderline; line < borderline + (size + 1) / 2; line++) {
			for (int column = borderColonne; column < borderColonne + (size + 1) / 2; column++) {
				Integer[] pos = { line, column };
				list.add(pos);
			}
		}
		return list;
	}

	public void insertTile(Tile tile, int x1, int y1, int x2, int y2) {
		Property case1 = new Property(x1, y1, tile.crown1, tile.terrain1);
		Property case2 = new Property(x2, y2, tile.crown2, tile.terrain2);
		setcase(case1);
		setcase(case2);
	}
}