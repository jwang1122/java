package com.huaxia.java2;

import java.util.Map;
import java.util.Map.Entry;

/**
 * This version of sort, return back with sorted LinkedHashMap.
 * 
 * @author john
 *
 */
public class PartsRunner {
	public static void main(String[] args) {
		PartList parts = new PartList();
		
		parts.buildMapFromDataFile();
		System.out.println("Random Auto-Parts");
		displayMap(parts.getRandomPartMap());

		System.out.println("\nSorted Auto-Parts");
		parts.sortTreeMap();
		displayMap(parts.getSortedPartMap());
	}
	
	private static void displayMap(Map<String, Part> map) {
		for (Entry<String, Part> e : map.entrySet()) {
			System.out.println(e.getValue());
		}		
	}
}
