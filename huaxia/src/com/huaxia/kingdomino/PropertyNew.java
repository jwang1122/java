package com.huaxia.kingdomino;

import java.awt.Graphics;

public class PropertyNew {
	Terrain terrain; 
	Position position;

	public PropertyNew(Terrain terrain, Position position) {
		this.terrain = terrain;
		this.position = position;
	}
	
	public void draw(Graphics g) {
		terrain.draw(g, position);
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}