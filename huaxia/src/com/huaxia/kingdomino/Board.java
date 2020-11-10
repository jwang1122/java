package com.huaxia.kingdomino;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Board {
	int size;
	Property[][] property;
	int borders[];
	 

	public int getsize() {
		return this.size;
	}

	public void setSize(int size) {
		size = this.getsize();
		property = this.getProperty();
		Property property[][] = new Property[size][size];
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				Property tile = new Property(line, column, 0, '#');
				property[line][column] = tile;
			}
		}
		Property castle = new Property(size / 2, size / 2, 0, 'C');
		this.setcase(castle);
	}

	public Property[][] getProperty() {
		return this.property;
	}

	public void setProperty(Property[][] propertyArray) {
		this.property = propertyArray;
	}

	public void setcase(Property tile) {
		property = this.getProperty();
		int x = tile.getx();
		int y = tile.gety();
		property[x][y] = tile;
		this.setProperty(property);
		this.borders = this.contours();
	}

	public Board(int size) {
		this.size = size;
		this.property = new Property[size][size];
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				Property tile = new Property(line, column, 0, '#');
				property[line][column] = tile;
			}
		}
		Property castle = new Property(size / 2, size / 2, 0, 'C');
		this.setcase(castle);
		this.borders = this.contours();
	}

	public void print() {
		size = this.getsize();
		property = this.getProperty();
		for (int line = 0; line < size + 1; line++) {
			for (int column = 0; column < size + 1; column++) {
				if (line == 0 && column == 0) {
					System.out.print("  ");
				} else if (line == 0 && column < size) {
					if (column - 1 >= 10) {
						System.out.print((column - 1) + "  ");
					} else {
						System.out.print((column - 1) + "   ");
					}
				} else if (line == 0 && column == size) {
					System.out.print((column - 1) + "\n");
				} else if (column == 0) {
					if (line - 1 >= 10) {
						System.out.print(line - 1);
					} else {
						System.out.print(line - 1 + " ");
					}
				} else {
					Property tile = property[line - 1][column - 1];
					if (column == size) {
						if (tile.getCrown() > 0) {
							System.out.print(tile.getCrown());
						}
						System.out.print(tile.getTile() + "\n");
					} else {
						if (tile.getCrown() > 0) {
							System.out.print(tile.getCrown());
							System.out.print(tile.getTile() + "  ");
						} else {
							System.out.print(tile.getTile() + "   ");
						}
					}
				}
			}
		}
	}

	public void viewplayable(Tile tile, int pos) {
		size = this.getsize();
		char play[][] = new char[size][size];
		char ident = 'e';
		int[] borders = this.borders;
		if (pos == 1) {
			ident =tile.getTile1();
		}
		if (pos == 2) {
			ident =tile.getTile2();
		}
		int line = 0;
		System.out.println(' ');
		for (int column = 0; column < size; column++) {
			boolean notprint = true;
			if (property[line][column].getTile() == '#') {
				notprint = true;
				while (notprint) {
					if (line - (size / 2 + 1) >= borders[0] || line + (size / 2 + 1) <= borders[1]
							|| column - (size / 2 + 1) >= borders[2] || column + (size / 2 + 1) <= borders[3]) {
						System.out.print(this.property[0][0].getTile());
						System.out.print(' ');
						break;
					}
					if (column > 0 && (property[line][column - 1].getTile() == ident
							|| (property[line][column - 1].getTile() == 'C'))) {
						System.out.print('O');
						System.out.print(' ');
						break;
					}
					if (column < size - 1 && (property[line][column + 1].getTile() == ident
							|| (property[line][column + 1].getTile() == 'C'))) {
						System.out.print('O');
						System.out.print(' ');
						break;
					}
					if (line < size - 1 && (property[line + 1][column].getTile() == ident
							|| (property[line + 1][column].getTile() == 'C'))) {
						System.out.print('O');
						System.out.print(' ');
						break;
					}
					if (line > 0 && ((property[line - 1][column].getTile() == ident)
							|| (property[line - 1][column].getTile() == 'C'))) {
						System.out.print('O');
						System.out.print(' ');
						break;
					} else {
						System.out.print('X');
						System.out.print(' ');
						break;
					}
				}
			} else {
				System.out.print('X');
				System.out.print(' ');
			}
			if (column == size - 1 && line < size) {
				line = line + 1;
				column = -1;
				if (line == size) {
					break;
				}
				System.out.println(' ');
			}
		}
	}

	public char[][] playable(Tile tile, int pos) {
		size = this.getsize();
		char play[][] = new char[size][size];
		char ident = 'e';
		int[] borders = this.borders;
		if (pos == 1) {
			ident =tile.getTile1();
		}
		if (pos == 2) {
			ident =tile.getTile2();
		}
		int line = 0;
		System.out.println(' ');
		for (int column = 0; column < size; column++) {
			boolean notread = true;
			if (property[column][line].getTile() == '#') {
				notread = true;
				while (notread) {
					if (line - (size / 2 + 1) >= borders[0] || line + (size / 2 + 1) <= borders[1]
							|| column - (size / 2 + 1) >= borders[2] || column + (size / 2 + 1) <= borders[3]) {
						play[line][column] = 'X';
						break;
					}
					if (column > 0 && (property[line][column - 1].getTile() == ident
							|| property[line][column - 1].getTile() == 'C')) {
						play[line][column] = 'O';
						break;
					}
					if (column < size - 1 && (property[line][column + 1].getTile() == ident
							|| property[line][column + 1].getTile() == 'C')) {
						play[line][column] = 'O';
						break;
					}
					if (line < size - 1 && (property[line + 1][column].getTile() == ident
							|| property[line + 1][column].getTile() == 'C')) {
						play[line][column] = 'O';
						break;
					}
					if (line > 0 && ((property[line - 1][column].getTile() == ident)
							|| property[line - 1][column].getTile() == 'C')) {
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

	public boolean canPlay(Tile tile) {
		property = this.getProperty();
		ArrayList<Integer[]> fieldList = this.fieldList();
		for (int i = 0; i < fieldList.size(); i++) {
			ArrayList<Integer[]> frameList = frame(fieldList.get(i)[0], fieldList.get(i)[1]);
			for (int j = 0; j < frameList.size(); j++) {
				ArrayList<Integer[]> nextToCase = nextToCase(frameList.get(j)[0], frameList.get(j)[1]);
				ArrayList<Integer[]> delNextToCase = delNextToCase(fieldList.get(i)[0], fieldList.get(i)[1],
						nextToCase);
				if (delNextToCase.size() > 0) {
					for (int elt = 0; elt < delNextToCase.size(); elt++) {
						if (this.playable(tile, frameList.get(j)[0], frameList.get(j)[1], delNextToCase.get(elt)[0],
								delNextToCase.get(elt)[1])) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public boolean playable(Tile tile, int x1, int y1, int x2, int y2) {
		property = this.getProperty();
		size = this.getsize();
		if ((x1 < 0 || x1 > size - 1) || (y1 < 0 || y1 > size - 1) || (x2 < 0 || x2 > size - 1)
				|| (y2 < 0 || y2 > size - 1)) {
			return false;
		}
		if (!placed(x1, y1, x2, y2)) {
			return false;
		}
		if (property[x1][y1].getTile() != '#' || property[x2][y2].getTile() != '#') {
			return false;
		}
		if (!possible(tile, x1, y1, x2, y2)) {
			return false;
		}
		return true;
	}

	public boolean printPlayable(Tile tile, int x1, int y1, int x2, int y2) {
		property = this.getProperty();
		size = this.getsize();
		if ((x1 < 0 || x1 > size - 1) || (y1 < 0 || y1 > size - 1) || (x2 < 0 || x2 > size - 1)
				|| (y2 < 0 || y2 > size - 1)) {
			System.out.println(String.format("size=%d, (%d, %d) (%d, %d)",size, x1,y1,x2,y2));
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
		if (property[x1][y1].getTile() != '#' || property[x2][y2].getTile() != '#') {
			System.out.println("The entered coordinates has already taken!");
			return false;
		}
		if (!printPossible(tile, x1, y1, x2, y2)) {
			return false;
		}
		return true;
	}

	public boolean graphicPlayable(Tile tile, int x1, int y1, int x2, int y2) {
		property = this.getProperty();
		size = this.getsize();
		if ((x1 < 0 || x1 > size - 1) || (y1 < 0 || y1 > size - 1) || (x2 < 0 || x2 > size - 1)
				|| (y2 < 0 || y2 > size - 1)) {
			System.out.println(String.format("size=%d, (%d, %d) (%d, %d)",size, x1,y1,x2,y2));
			JOptionPane.showMessageDialog(null, "The input coordinates go beyond the playing field!",
					"Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (x1 == x2 && y1 == y2) {
			JOptionPane.showMessageDialog(null, "You cannot play on a single square!", "Error",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (!placed(x1, y1, x2, y2)) {
			JOptionPane.showMessageDialog(null, "The entered coordinates correspond to boxes not pasted!",
					"Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (property[x1][y1].getTile() != '#' || property[x2][y2].getTile() != '#') {
			JOptionPane.showMessageDialog(null, "The entered coordinate has already taken!",
					"Error", JOptionPane.INFORMATION_MESSAGE);
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
			System.out.println(String.format("size=%d, (%d, %d) (%d, %d)",size, x1,y1,x2,y2));
			JOptionPane.showMessageDialog(null, "The input coordinates go beyond the  framework!", "Error",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		ArrayList<Integer[]> nextToCase1 = deleteNextTo(nextToCastle(x1, y1), x2, y2);
		ArrayList<Integer[]> nextToCase2 = deleteNextTo(nextToCastle(x2, y2), x1, y1);
		if (nextToCase1.size() + nextToCase2.size() <= 0) {
			Tile tileEmpty = new Tile(tile.getNumber(), 0, 0, '#', '#');
			tileEmpty.insertTile(this, x1, y1, x2, y2);
			JOptionPane.showMessageDialog(null, "Adjacent squares do not have  the same type!", "Error",
					JOptionPane.INFORMATION_MESSAGE);
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
		property = this.getProperty();
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
		property = this.getProperty();
		size = this.getsize();
		int linemax = size / 2;
		int columnmax = size / 2;
		int linemin = size / 2;
		int columnmin = size / 2;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if ((property[i][j].getTile() != '#') && (linemin >= i)) {
					linemin = i;
				}
			}
		}
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				if (property[i][j].getTile() != '#' && columnmin >= j) {
					columnmin = j;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (property[i][j].getTile() != '#' && linemax <= i) {
					linemax = i;
				}
			}
		}
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				if (property[i][j].getTile() != '#' && columnmax <= j) {
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
		property = board.getProperty();
		int length = board.getsize();
		int score = 0;
		for (int line = 0; line < length; line++) {
			for (int column = 0; column < length; column++) {
				if (property[line][column].getTile() != '#') {
					int numCrowns = 0;
					int nbCases = 0;
					ArrayList<Integer[]> pack = board.paquet(line, column);
					for (int compteur = 0; compteur < pack.size(); compteur++) {
						nbCases += 1;
						numCrowns += property[pack.get(compteur)[0]][pack.get(compteur)[1]].getCrown();
						Property tile = new Property(pack.get(compteur)[0], pack.get(compteur)[1],
								property[pack.get(compteur)[0]][pack.get(compteur)[1]].getCrown(), '#');
						board.setcase(tile);
					}
					score += nbCases * numCrowns;
				}
			}
		}
		return score;
	}

	public Board copy() {
		property = this.getProperty();
		size = this.getsize();
		Board terrain = new Board(size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				terrain.setcase(property[i][j]);
			}
		}
		return terrain;
	}

	public ArrayList<Integer[]> nextToCastle(int line, int column) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		property = this.getProperty();
		size = this.getsize();
		if ((line - 1 >= 0) && (property[line][column].getTile() == property[line - 1][column].getTile()
				|| property[line - 1][column].getTile() == 'C')) {
			Integer[] pos = { line - 1, column };
			list.add(pos);
		}
		if ((column + 1 <= size - 1) && (property[line][column].getTile() == property[line][column + 1].getTile()
				|| property[line][column + 1].getTile() == 'C')) {
			Integer[] pos = { line, column + 1 };
			list.add(pos);
		}
		if ((line + 1 <= size - 1) && (property[line][column].getTile() == property[line + 1][column].getTile()
				|| property[line + 1][column].getTile() == 'C')) {
			Integer[] pos = { line + 1, column };
			list.add(pos);
		}
		if ((column - 1 >= 0) && (property[line][column].getTile() == property[line][column - 1].getTile()
				|| property[line][column - 1].getTile() == 'C')) {
			Integer[] pos = { line, column - 1 };
			list.add(pos);
		}
		return list;
	}

	public ArrayList<Integer[]> nextTo(int line, int column) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		property = this.getProperty();
		size = this.getsize();
		if ((line - 1 >= 0) && (property[line][column].getTile() == property[line - 1][column].getTile())) {
			Integer[] pos = { line - 1, column };
			list.add(pos);
		}
		if ((column + 1 <= size - 1) && (property[line][column].getTile() == property[line][column + 1].getTile())) {
			Integer[] pos = { line, column + 1 };
			list.add(pos);
		}
		if ((line + 1 <= size - 1) && (property[line][column].getTile() == property[line + 1][column].getTile())) {
			Integer[] pos = { line + 1, column };
			list.add(pos);
		}
		if ((column - 1 >= 0) && (property[line][column].getTile() == property[line][column - 1].getTile())) {
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
		property = this.getProperty();
		size = this.getsize();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				if (property[line][column].getTile() != '#') {
					ArrayList<Integer[]> listPaquet = paquet(line, column);
					list.add(listPaquet.size());
					for (int compteur = 0; compteur < listPaquet.size(); compteur++) {
						property[listPaquet.get(compteur)[0]][listPaquet.get(compteur)[1]].setTile('#');
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
		property = this.getProperty();
		size = this.getsize();
		int numCrowns = 0;
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				numCrowns += property[line][column].getCrown();
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
		property = this.getProperty();
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
					if (property[pointerX][pointerY].getTile() == '#') {
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
		property = this.getProperty();
		size = this.getsize();
		ArrayList<Integer[]> fieldList = this.fieldList();
		for (int compteur = 0; compteur < fieldList.size(); compteur++) {
			if (property[fieldList.get(compteur)[0] + (size - 1) / 4][fieldList.get(compteur)[1] + (size - 1) / 4]
					.getTile() == 'C') {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Integer[]> fieldList() {
		property = this.getProperty();
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
		property = this.getProperty();
		size = this.getsize();
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		for (int line = 0; line < size; line++) {
			for (int column = 0; column < size; column++) {
				if (property[line][column].getTile() != '#') {
					Integer[] pos = { line, column };
					list.add(pos);
				}
			}
		}
		return list;
	}

	public boolean allIn(int line, int column, ArrayList<Integer[]> listPos) {
		property = this.getProperty();
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
		property = this.getProperty();
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
	
}