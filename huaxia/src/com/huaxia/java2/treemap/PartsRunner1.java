package com.huaxia.java2.treemap;

import java.util.Map;
import java.util.Map.Entry;

public class PartsRunner1 {
	public static void main(String[] args) {
		PartList1 parts = new PartList1();
		
		parts.loadParts();
		System.out.println("Random Auto-Parts");
		displayMap(parts.getMap());

		System.out.println("\nSorted Auto-Parts");
		parts.sortMap();
		displayMap(parts.getSortedParts());
	}
	
	private static void displayMap(Map<String, Part> map) {
		for (Entry<String, Part> e : map.entrySet()) {
			System.out.println(e.getValue());
		}		
	}

}
