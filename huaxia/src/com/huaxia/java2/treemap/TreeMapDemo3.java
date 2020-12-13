package com.huaxia.java2.treemap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TreeMapDemo3 {
	Map<String, Part> treemap;
	HashMap<String, Part> map = new HashMap<String, Part>();

	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				return map.get(k1).compareTo(map.get(k2));
			}
		};

		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	TreeMapDemo3() {
		Part part1 = new Part("1", "1a", 2001);
		Part part2 = new Part("2", "1a", 2003);
		Part part3 = new Part("91", "01a", 2003);
		Part part4 = new Part("4", "24a", 2004);
		Part part5 = new Part("5", "16a", 2005);
		// Put elements to the map
		map.put("Key1", part1);
		map.put("Key2", part2);
		map.put("Key3", part3);
		map.put("Key4", part4);
		map.put("Key5", part5);
//		treemap.putAll(map); 
		treemap = sortByValues(map);
	}

	public static void main(String args[]) {
		TreeMapDemo3 tmd = new TreeMapDemo3();

		// Calling the method sortByvalues
		for (String key : tmd.treemap.keySet()) {
			System.out.println(tmd.treemap.get(key));
		}
		
		
	}

}