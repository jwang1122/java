package com.huaxia.java2;

import java.util.Map.Entry;

/**
 * This version of sort, return back with sorted LinkedHashMap.
 * 
 * @author john
 *
 */
public class PartsRunner4 {
	public static void main(String[] args) {
		PartList parts = new PartList();
		parts.buildMapFromDataFile();
		parts.sortTreeMap();
		System.out.println("\nSorted Auto-Parts");
		for (Entry<String, Part> e : parts.treemap.entrySet()) {
			System.out.println(e.getValue());
		}
	}
}
