package com.huaxia.kingdomino;

import java.awt.Graphics;
import java.awt.Image;

import com.huaxia.kingdomino.Terrain.TerrainImage;

public class Property {
	Position position;
	Terrain terrain;

	public Property(Position position, Terrain terrain) {
		this.terrain = terrain;
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public int getRow() {
		return position.row;
	}
	
	public int getColumn() {
		return position.column;
	}
	
	public int getNumOfCrowns() {
		return terrain.numberOfCrowns;
	}
	
	public Image getImage() {
		return Terrain.getImage(terrain.image);
	}
	
	public boolean isOccupied() {
		return !terrain.equals(Terrain.emptyTerrain);
	}
	
	public boolean isCastle() {
		return terrain.image == TerrainImage.CASTLE;
	}
	
	public boolean isSameTerrain(Property other) {
		return terrain.image == other.terrain.image;
	}

	public void draw(Graphics g, Image castleImage) {
		terrain.draw(g, position, castleImage);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((terrain == null) ? 0 : terrain.hashCode());
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
		Property other = (Property) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (terrain == null) {
			if (other.terrain != null)
				return false;
		} else if (!terrain.equals(other.terrain))
			return false;
		return true;
	}

}