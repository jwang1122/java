package com.huaxia.java2.enumlearn;

import java.util.EnumMap;
import java.util.Map;

public class Direction3 {
	  public static void main(String[] args)
	  {
	    //Keys can be only of type Direction
	    Map<Direction1, Integer> enumMap = new EnumMap<>(Direction1.class);
	 
	    //Populate the Map
	    enumMap.put(Direction1.EAST, Direction1.EAST.getAngle());
	    enumMap.put(Direction1.WEST, Direction1.WEST.getAngle());
	    enumMap.put(Direction1.NORTH, Direction1.NORTH.getAngle());
	    enumMap.put(Direction1.SOUTH, Direction1.SOUTH.getAngle());
	    
	    System.out.println(enumMap.get(Direction1.WEST));
	  }
}
