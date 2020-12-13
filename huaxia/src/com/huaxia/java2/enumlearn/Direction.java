package com.huaxia.java2.enumlearn;

public enum Direction {
	EAST, WEST, NORTH, SOUTH;

	public static void main(String[] args) {
		for(Direction d: Direction.values()) {
			System.out.println(d);
			System.out.println(d.ordinal());
		}
		System.out.println(Direction.valueOf("NORTH")); // NORTH is the name
	}
}
