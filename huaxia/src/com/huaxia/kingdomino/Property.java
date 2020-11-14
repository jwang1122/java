package com.huaxia.kingdomino;

public class Property {
	int crown, row, column;
	char terrain;

	public Property(int row, int column, int crown, char terrain) {
		this.crown = crown;
		this.terrain = terrain;
		this.row = row;
		this.column = column;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + crown;
		result = prime * result + row;
		result = prime * result + terrain;
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
		if (column != other.column)
			return false;
		if (crown != other.crown)
			return false;
		if (row != other.row)
			return false;
		if (terrain != other.terrain)
			return false;
		return true;
	}


}