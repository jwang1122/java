package com.huaxia.java2.enumlearn;

// Define attribute in each enum field.
public enum Direction1 {
	EAST(0), WEST(180), NORTH(90), SOUTH(270);

	private int angle;
	
	private Direction1(int angle) {
		this.angle = angle;
	}
	
	public int getAngle() {
		return this.angle;
	}
	
	public static void main(String[] args) {
		for(Direction d: Direction.values()) {
			System.out.println(d);
			System.out.println(d.ordinal());
		}
		System.out.println(Direction.valueOf("NORTH")); // NORTH is the name
		System.out.println(NORTH.getAngle());
		
		Direction west = Direction.WEST;
		Direction east = Direction.EAST;
		Direction eastNew = Direction.valueOf("EAST");
		System.out.println(east==eastNew);
		System.out.println(east.equals(eastNew));
		System.out.println(east.compareTo(west));
		
/*
public abstract class Enum<E extends Enum<E>> 
                    extends Object 
                    implements Comparable<E>, Serializable {
     
}	
 */
	}
}
