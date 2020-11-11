package com.huaxia.kingdomino;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Board {
	int size;
	Property[][] properties;
	int borders[];

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
//		property = this.getProperty(); // junk code
		int x = tile.getx();
		int y = tile.gety();
		properties[x][y] = tile;
//		this.setProperty(property); // junk code
		this.borders = this.contours();
	}

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
		this.setcase(castle);
		this.borders = this.contours();
	}

	/**
	 * Used by Player
	 * 
	 * @param tile
	 * @param pos
	 * @return
	 */
	public char[][] playable(Tile tile, int pos) {
		size = this.getsize();
		char play[][] = new char[size][size];
		char ident = 'e';
		int[] borders = this.borders;
		if (pos == 1) {
			ident = tile.getTile1();
		}
		if (pos == 2) {
			ident = tile.getTile2();
		}
		int line = 0;
		System.out.println(' ');
		for (int column = 0; column < size; column++) {
			boolean notread = true;
			if (properties[column][line].getTile() == '#') {
				notread = true;
				while (notread) {
					if (line - (size / 2 + 1) >= borders[0] || line + (size / 2 + 1) <= borders[1] || column - (size / 2
							+ 1) >= borders[2] || column + (size / 2 + 1) <= borders[3]) {
						play[line][column] = 'X';
						break;
					}
					if (column > 0 && (properties[line][column - 1].getTile() == ident || properties[line][column
							- 1].getTile() == 'C')) {
						play[line][column] = 'O';
						break;
					}
					if (column < size - 1 && (properties[line][column + 1].getTile() == ident || properties[line][column
							+ 1].getTile() == 'C')) {
						play[line][column] = 'O';
						break;
					}
					if (line < size - 1 && (properties[line + 1][column].getTile() == ident || properties[line
							+ 1][column].getTile() == 'C')) {
						play[line][column] = 'O';
						break;
					}
					if (line > 0 && ((properties[line - 1][column].getTile() == ident) || properties[line
							- 1][column].getTile() == 'C')) {
						play[line][column] = 'O';
						break;
					} else {
						play[line][column] = 'X';
						break;
					}
				}
			} else {
				play[line][column] = 'X';
			}
			if (column == size - 1 && line < size) {
				line = line + 1;
				column = -1;
				if (line == size) {
					break;
				}
			}
		}
		return play;
	}

	/**
	 * used by MainGraphics class.
	 * 
	 * @param tile
	 * @return
	 */
	public boolean canPlay(Tile tile) {
		properties = this.getProperties();
		ArrayList<Integer[]> fieldList = this.fieldList();
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

	/**
	 * used by Player
	 * 
	 * @param tile
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public boolean playable(Tile tile, int x1, int y1, int x2, int y2) {
		properties = this.getProperties();
		size = this.getsize();
		if ((x1 < 0 || x1 > size - 1) || (y1 < 0 || y1 > size - 1) || (x2 < 0 || x2 > size - 1) || (y2 < 0 || y2 > size
				- 1)) {
			return false;
		}
		if (!placed(x1, y1, x2, y2)) {
			return false;
		}
		if (properties[x1][y1].getTile() != '#' || properties[x2][y2].getTile() != '#') {
			return false;
		}
		if (!possible(tile, x1, y1, x2, y2)) {
			return false;
		}
		return true;
	}

	public boolean printPlayable(Tile tile, int x1, int y1, int x2, int y2) {
		properties = this.getProperties();
		size = this.getsize();
		if ((x1 < 0 || x1 > size - 1) || (y1 < 0 || y1 > size - 1) || (x2 < 0 || x2 > size - 1) || (y2 < 0 || y2 > size
				- 1)) {
			System.out.println(String.format("size=%d, (%d, %d) (%d, %d)", size, x1, y1, x2, y2));
			System.out.println("The input coordinates go beyond the  playing field!");
			return false;
		}
		if (x1 == x2 && y1 == y2) {
			System.out.println("You cannot play on a single square!!");
			return false;
		}
		if (!placed(x1, y1, x2, y2)) {
			System.out.println("The entered coordinates correspond to boxes not pasted!");
			return false;
		}
		if (properties[x1][y1].getTile() != '#' || properties[x2][y2].getTile() != '#') {
			System.out.println("The entered coordinates has already taken!");
			return false;
		}
		if (!printPossible(tile, x1, y1, x2, y2)) {
			return false;
		}
		return true;
	}

	public boolean graphicPlayable(Tile tile, int x1, int y1, int x2, int y2) {
		properties = this.getProperties();
		size = this.getsize();
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
		if (properties[x1][y1].getTile() != '#' || properties[x2][y2].getTile() != '#') {
			JOptionPane.showMessageDialog(null, "The entered coordinate has already taken!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (!graphicPossible(tile, x1, y1, x2, y2)) {
			return false;
		}
		return true;
	}

	public boolean possible(Tile tile, int x1, int y1, int x2, int y2) {
		tile.insertTile(this, x1, y1, x2, y2);
		ArrayList<Integer[]> fieldList = this.fieldList();
		if (fieldList.size() == 0) {
			Tile tileEmpty = new Tile(tile.getNumber(), 0, 0, '#', '#');
			tileEmpty.insertTile(this, x1, y1, x2, y2);
			return false;
		}
		ArrayList<Integer[]> nextToCase1 = deleteNextTo(nextToCastle(x1, y1), x2, y2);
		ArrayList<Integer[]> nextToCase2 = deleteNextTo(nextToCastle(x2, y2), x1, y1);
		if (nextToCase1.size() + nextToCase2.size() <= 0) {
			Tile tileEmpty = new Tile(tile.getNumber(), 0, 0, '#', '#');
			tileEmpty.insertTile(this, x1, y1, x2, y2);
			return false;
		}
		Tile tileEmpty = new Tile(tile.getNumber(), 0, 0, '#', '#');
		tileEmpty.insertTile(this, x1, y1, x2, y2);
		return true;
	}

	public boolean printPossible(Tile tile, int x1, int y1, int x2, int y2) {
		tile.insertTile(this, x1, y1, x2, y2);
		ArrayList<Integer[]> fieldList = this.fieldList();
		if (fieldList.size() == 0) {
			Tile tileEmpty = new Tile(tile.getNumber(), 0, 0, '#', '#');
			tileEmpty.insertTile(this, x1, y1, x2, y2);
			System.out.println("The input coordinates go beyond the framework!");
			return false;
		}
		ArrayList<Integer[]> nextToCase1 = deleteNextTo(nextToCastle(x1, y1), x2, y2);
		ArrayList<Integer[]> nextToCase2 = deleteNextTo(nextToCastle(x2, y2), x1, y1);
		if (nextToCase1.size() + nextToCase2.size() <= 0) {
			Tile tileEmpty = new Tile(tile.getNumber(), 0, 0, '#', '#');
			tileEmpty.insertTile(this, x1, y1, x2, y2);
			System.out.println("Adjacent squares do not have  the same type!");
			return false;
		}
		Tile tileEmpty = new Tile(tile.getNumber(), 0, 0, '#', '#');
		tileEmpty.insertTile(this, x1, y1, x2, y2);
		return true;
	}

	public boolean graphicPossible(Tile tile, int x1, int y1, int x2, int y2) {
		tile.insertTile(this, x1, y1, x2, y2);
		ArrayList<Integer[]> fieldList = this.fieldList();
		if (fieldList.size() == 0) {
			Tile tileEmpty = new Tile(tile.getNumber(), 0, 0, '#', '#');
			tileEmpty.insertTile(this, x1, y1, x2, y2);
			System.out.println(String.format("size=%d, (%d, %d) (%d, %d)", size, x1, y1, x2, y2));
			JOptionPane.showMessageDialog(null, "The input coordinates go beyond the  framework!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		ArrayList<Integer[]> nextToCase1 = deleteNextTo(nextToCastle(x1, y1), x2, y2);
		ArrayList<Integer[]> nextToCase2 = deleteNextTo(nextToCastle(x2, y2), x1, y1);
		if (nextToCase1.size() + nextToCase2.size() <= 0) {
			Tile tileEmpty = new Tile(tile.getNumber(), 0, 0, '#', '#');
			tileEmpty.insertTile(this, x1, y1, x2, y2);
			JOptionPane.showMessageDialog(null, "Adjacent squares do not have  the same type!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		Tile tileEmpty = new Tile(tile.getNumber(), 0, 0, '#', '#');
		tileEmpty.insertTile(this, x1, y1, x2, y2);
		return true;
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

	public int[] contours() {
		int[] extreme = new int[4];
		properties = this.getProperties();
		size = this.getsize();
		int linemax = size / 2;
		int columnmax = size / 2;
		int linemin = size / 2;
		int columnmin = size / 2;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if ((properties[i][j].getTile() != '#') && (linemin >= i)) {
					linemin = i;
				}
			}
		}
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				if (properties[i][j].getTile() != '#' && columnmin >= j) {
					columnmin = j;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (properties[i][j].getTile() != '#' && linemax <= i) {
					linemax = i;
				}
			}
		}
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				if (properties[i][j].getTile() != '#' && columnmax <= j) {
					columnmax = j;
				}
			}
		}
		extreme[0] = linemin;
		extreme[1] = linemax;
		extreme[2] = columnmin;
		extreme[3] = columnmax;
		return extreme;
	}

	public int score() {
		Board board = this;
		properties = board.getProperties();
		int length = board.getsize();
		int score = 0;
		for (int line = 0; line < length; line++) {
			for (int column = 0; column < length; column++) {
				if (properties[line][column].getTile() != '#') {
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

	public Board copy() {
		properties = this.getProperties();
		size = this.getsize();
		Board terrain = new Board(size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				terrain.setcase(properties[i][j]);
			}
		}
		return terrain;
	}

	public ArrayList<Integer[]> nextToCastle(int line, int column) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		properties = this.getProperties();
		size = this.getsize();
		if ((line - 1 >= 0) && (properties[line][column].getTile() == properties[line - 1][column].getTile()
				|| properties[line - 1][column].getTile() == 'C')) {
			Integer[] pos = { line - 1, column };
			list.add(pos);
		}
		if ((column + 1 <= size - 1) && (properties[line][column].getTile() == properties[line][column + 1].getTile()
				|| properties[line][column + 1].getTile() == 'C')) {
			Integer[] pos = { line, column + 1 };
			list.add(pos);
		}
		if ((line + 1 <= size - 1) && (properties[line][column].getTile() == properties[line + 1][column].getTile()
				|| properties[line + 1][column].getTile() == 'C')) {
			Integer[] pos = { line + 1, column };
			list.add(pos);
		}
		if ((column - 1 >= 0) && (properties[line][column].getTile() == properties[line][column - 1].getTile()
				|| properties[line][column - 1].getTile() == 'C')) {
			Integer[] pos = { line, column - 1 };
			list.add(pos);
		}
		return list;
	}

	public ArrayList<Integer[]> nextTo(int line, int column) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		properties = this.getProperties();
		size = this.getsize();
		if ((line - 1 >= 0) && (properties[line][column].getTile() == properties[line - 1][column].getTile())) {
			Integer[] pos = { line - 1, column };
			list.add(pos);
		}
		if ((column + 1 <= size - 1) && (properties[line][column].getTile() == properties[line][column + 1].getTile())) {
			Integer[] pos = { line, column + 1 };
			list.add(pos);
		}
		if ((line + 1 <= size - 1) && (properties[line][column].getTile() == properties[line + 1][column].getTile())) {
			Integer[] pos = { line + 1, column };
			list.add(pos);
		}
		if ((column - 1 >= 0) && (properties[line][column].getTile() == properties[line][column - 1].getTile())) {
			Integer[] pos = { line, column - 1 };
			list.add(pos);
		}
		return list;
	}

	public ArrayList<Integer[]> paquet(int line, int column) {
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

	public boolean In(ArrayList<Integer[]> list, Integer[] pos) {
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
				if (properties[line][column].getTile() != '#') {
					ArrayList<Integer[]> listPaquet = paquet(line, column);
					list.add(listPaquet.size());
					for (int compteur = 0; compteur < listPaquet.size(); compteur++) {
						properties[listPaquet.get(compteur)[0]][listPaquet.get(compteur)[1]].setTile('#');
					}
				}
			}
		}
		return max(list);
	}

	public int max(ArrayList<Integer> list) {
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

	/*
		public int scoreHarmonie() {
			int harmonie = 0;
			if (this.complet()) {
				harmonie = 5;
			}
			return this.copy().score() + harmonie;
		}
	*/
	public boolean complet() {
		properties = this.getProperties();
		size = this.getsize();
		this.borders = this.contours();
		int linemin = this.borders[0];
		int linemax = this.borders[1];
		int columnmin = this.borders[2];
		int columnmax = this.borders[3];
		if (linemax - linemin < (size - 1) / 2) {
			return false;
		}
		if (columnmax - columnmin < (size - 1) / 2) {
			return false;
		} else {
			for (int pointerX = linemin; pointerX <= linemax; pointerX++) {
				for (int pointerY = columnmin; pointerY <= columnmax; pointerY++) {
					if (properties[pointerX][pointerY].getTile() == '#') {
						return false;

					}
				}
			}
		}
		return true;
	}

	public int scoreMilieu() {
		int milieu = 0;
		if (this.estAuMilieu()) {
			milieu = 10;
		}
		return this.copy().score() + milieu;
	}

	public boolean estAuMilieu() {
		properties = this.getProperties();
		size = this.getsize();
		ArrayList<Integer[]> fieldList = this.fieldList();
		for (int compteur = 0; compteur < fieldList.size(); compteur++) {
			if (properties[fieldList.get(compteur)[0] + (size - 1) / 4][fieldList.get(compteur)[1] + (size - 1)
					/ 4].getTile() == 'C') {
				return true;
			}
		}
		return false;
	}

	/**
	 * FieldList is 5X5 terrain location which cannot exceed, 
	 * the terrain can only be placed within this area. 
	 * 
	 * @return
	 */
	public ArrayList<Integer[]> fieldList() {
		properties = this.getProperties();
		size = this.getsize();
		ArrayList<Integer[]> fieldList = new ArrayList<Integer[]>();
		ArrayList<Integer[]> listPos = this.listPosition();
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

	public ArrayList<Integer[]> listPosition() {
		properties = this.getProperties();
		size = this.getsize();
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				if (properties[line][column].getTile() != '#') {
					Integer[] pos = { line, column };
					list.add(pos);
				}
			}
		}
		return list;
	}

	public boolean allIn(int line, int column, ArrayList<Integer[]> listPos) {
		properties = this.getProperties();
		size = this.getsize();
		ArrayList<Integer[]> frameList = this.frame(line, column);
		for (int compteur = 0; compteur < listPos.size(); compteur++) {
			if (!(In(frameList, listPos.get(compteur)))) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Integer[]> frame(Integer borderline, Integer borderColonne) {
		properties = this.getProperties();
		size = this.getsize();
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
		Property case1 = new Property(x1, y1, tile.crown1, tile.tile1);
		Property case2 = new Property(x2, y2, tile.crown2, tile.tile2);
		setcase(case1);
		setcase(case2);
	}

}