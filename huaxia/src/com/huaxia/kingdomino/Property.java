package com.huaxia.kingdomino;

public class Property {
	int crown, row, column;
	char terrain;

	public int getCrown() {
		return this.crown;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	public char getTerrain() {
		return this.terrain;
	}

	public void setTerrain(char title) {
		this.terrain = getTerrain();
	}

	public Property(int row, int column, int crown, char terrain) {
		this.crown = crown;
		this.terrain = terrain;
		this.row = row;
		this.column = column;
	}

}