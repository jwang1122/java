package com.huaxia.java2.treemap;

import java.util.Map;
import java.util.Map.Entry;

/**
 * This version of sort, return back with sorted LinkedHashMap.
 * 
 * @author john
 *
 */
public class PartsRunner2 {
	public static void main(String[] args) {
		PartList2 parts = new PartList2();
		
		parts.loadParts();
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
