package com.huaxia.kingdomino;

public class Domino implements Comparable<Domino>{
	static Domino emptyDomino = new Domino(0, Terrain.emptyTerrain, Terrain.emptyTerrain);
	int number;
	Terrain terrain1, terrain2;

	public Domino(int number, Terrain terrain1, Terrain terrain2) {
		super();
		this.number = number;
		this.terrain1 = terrain1;
		this.terrain2 = terrain2;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Terrain getTerrain1() {
		return terrain1;
	}

	public void setTerrain1(Terrain terrain1) {
		this.terrain1 = terrain1;
	}

	public Terrain getTerrain2() {
		return terrain2;
	}

	public void setTerrain2(Terrain terrain2) {
		this.terrain2 = terrain2;
	}

	@Override
	public String toString() {
		return "Domino [" + number + "]";
	}

	@Override
	public int compareTo(Domino other) {
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
		result = prime * result + number;
		result = prime * result + ((terrain1 == null) ? 0 : terrain1.hashCode());
		result = prime * result + ((terrain2 == null) ? 0 : terrain2.hashCode());
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
		Domino other = (Domino) obj;
		if (number != other.number)
			return false;
		if (terrain1 != other.terrain1)
			return false;
		if (terrain2 != other.terrain2)
			return false;
		return true;
	}


}