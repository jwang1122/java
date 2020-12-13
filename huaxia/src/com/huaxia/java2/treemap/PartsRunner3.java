package com.huaxia.java2.treemap;

import java.util.Map;
import java.util.Map.Entry;

/**
 * This version of sort, return back with sorted LinkedHashMap.
 * 
 * @author john
 *
 */
public class PartsRunner3 {
	public static void main(String[] args) {
		PartList3 parts = new PartList3();
		
		parts.buildMapFromDataFile();
		System.out.println("Random Auto-Parts");
		displayMap(parts.getMap());

		System.out.println("\nSorted Auto-Parts");
		parts.sortTreeMap();
		displayMap(parts.treemap);
	}
	
	private static void displayMap(Map<String, Part> map) {
		for (Entry<String, Part> e : map.entrySet()) {
			System.out.println(e.getValue());
		}			
	}

}
