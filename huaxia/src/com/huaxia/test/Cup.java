package com.huaxia.test;

public class Cup {
	String type;
	String liquids;
	float filledUp;
	
	public Cup() {
		
	}
	
	public Cup(String type, String liquids) {
		this.type = type;
		this.liquids = liquids;
	}

	/**
	 * Filled up given liquids into the cup by certain percentage.
	 * 
	 * @return percentage of the liquids in the cup
	 * @param liquids: liquid type for instance, water, Coco.
	 * @param filled: filled percentage of the cup. 
	 */
	public float fillUpLiquids(String liquids, float filled) {
		filledUp = filled;
		this.liquids = liquids;
		return filledUp;
	}
	
	public String toString() {
		return String.format("(%s, %s)", this.type, this.liquids);
	}
	
	public static void main(String[] args) {
		Cup newCup = new Cup();
		String liquids = "water";
		float filled = (float)0.8;
		newCup.fillUpLiquids(liquids, filled);
		System.out.println("Liquids in the cup is " + newCup.liquids + "\nfilled up to " + newCup.filledUp);
		Cup cup2 = new Cup();
		cup2.fillUpLiquids("Coco", 0.7f);
		System.out.println(cup2);
	}

}
