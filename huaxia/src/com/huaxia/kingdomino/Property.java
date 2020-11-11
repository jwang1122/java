package com.huaxia.kingdomino;

public class Property {
	int crown, x, y;
	char tile;
	Tile.Terrain terrain;

	public int getCrown() {
		return this.crown;
	}

	public int getx() {
		return this.x;
	}

	public int gety() {
		return this.y;
	}

	public char getTile() {
		return this.tile;
	}

	public void setCrown(int crown) {
		this.crown = crown;
	}

	public void setx(int x) {
		this.x = x;
	}

	public void sety(int y) {
		this.y = y;
	}

	public void setTile(char title) {
		this.tile = getTile();
	}

	public Property(int x, int y, int crown, char tile) {
		this.crown = crown;
		this.tile = tile;
		this.x = x;
		this.y = y;
	}

}