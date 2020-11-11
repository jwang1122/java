package com.huaxia.kingdomino;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile implements Comparable<Tile>{
	static Image imageF, imageL, imageM, imageP, imageQ, imageW; // tile images
	static {
		try {
			imageF = ImageIO.read(new File("Forest.jpg"));
			imageL = ImageIO.read(new File("Field.jpg"));
			imageM = ImageIO.read(new File("Mine.jpg"));
			imageP = ImageIO.read(new File("Swamp.jpg"));
			imageQ = ImageIO.read(new File("Mountain.jpg"));
			imageW = ImageIO.read(new File("Water.jpg"));
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	enum Terrain {Forest,Field,Mine,Swamp,Mountain,Water};
	int number, crown1, crown2;
	char tile1, tile2;

	public Tile(int number, int crown1, int crown2, char tile1, char tile2) {
		this.number = number;
		this.crown1 = crown1;
		this.crown2 = crown2;
		this.tile1 = tile1;
		this.tile2 = tile2;
	}

	public int getNumber() {
		return this.number;
	}

	public char getTile1() {
		return this.tile1;
	}

	public char getTile2() {
		return this.tile2;
	}

	public int getCrown1() {
		return this.crown1;
	}

	public int getCrown2() {
		return this.crown2;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setTile1(char tile1) {
		this.tile1 = tile1;
	}

	public void setTile2(char tile2) {
		this.tile2 = tile2;
	}

	public void setCrown1(int crown1) {
		this.crown1 = crown1;
	}

	public void setCrown2(int crown2) {
		this.crown2 = crown2;
	}

	public void insertTile(Board board, int x1, int y1, int x2, int y2) {
		Property case1 = new Property(x1, y1, crown1, tile1);
		Property case2 = new Property(x2, y2, crown2, tile2);
		board.setcase(case1);
		board.setcase(case2);
	}

	public int evaluate(int[] crowns) {

		int Value = 0;
		if (this.tile1 == 'P') {
			Value = crowns[0];
		}
		if (this.tile1 == 'W') {
			Value = +crowns[1];
		}
		if (this.tile1 == 'F') {
			Value = crowns[2];
		}
		if (this.tile1 == 'L') {
			Value = crowns[3];
		}
		if (this.tile1 == 'Q') {
			Value = crowns[4];
		}
		if (this.tile1 == 'M') {
			Value = crowns[5];
		}
		if (this.tile1 == '#') {
			Value = 0;
		}
		if (this.tile2 == 'P') {
			Value = Value + crowns[0];
		}
		if (this.tile2 == 'W') {
			Value = Value + crowns[1];
		}
		if (this.tile2 == 'F') {
			Value = Value + crowns[2];
		}
		if (this.tile2 == 'L') {
			Value = Value + crowns[3];
		}
		if (this.tile2 == 'Q') {
			Value = Value + crowns[4];
		}
		if (this.tile2 == 'M') {
			Value = Value + crowns[5];
		}
		if (this.tile1 == '#') {
			Value = Value + 0;
		}
		return Value;
	}
	
	static public Image getImage(char value) {
		switch (value) {
		case 'P':
			return imageP;
		case 'Q':
			return imageQ;
		case 'F':
			return imageF;
		case 'L':
			return imageL;
		case 'W':
			return imageW;
		case 'M':
			return imageM;
		}
		return null;
	}


	@Override
	public String toString() {
		return "Tile [number=" + number + "]";
	}

	@Override
	public int compareTo(Tile other) {
		if(other==null) return -1;
		if (number==other.number)
			return 0;
		if (number > other.number)
			return 1;
		return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + crown1;
		result = prime * result + crown2;
		result = prime * result + number;
		result = prime * result + tile1;
		result = prime * result + tile2;
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
		Tile other = (Tile) obj;
		if (crown1 != other.crown1)
			return false;
		if (crown2 != other.crown2)
			return false;
		if (number != other.number)
			return false;
		if (tile1 != other.tile1)
			return false;
		if (tile2 != other.tile2)
			return false;
		return true;
	}
	

}