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
	char terrain1, terrain2;

	public Tile(int number, int crown1, int crown2, char tile1, char tile2) {
		this.number = number;
		this.crown1 = crown1;
		this.crown2 = crown2;
		this.terrain1 = tile1;
		this.terrain2 = tile2;
	}

	public int getNumber() {
		return this.number;
	}

	public char getTerrain1() {
		return this.terrain1;
	}

	public char getTerrain2() {
		return this.terrain2;
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
		result = prime * result + terrain1;
		result = prime * result + terrain2;
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
		if (terrain1 != other.terrain1)
			return false;
		if (terrain2 != other.terrain2)
			return false;
		return true;
	}
}