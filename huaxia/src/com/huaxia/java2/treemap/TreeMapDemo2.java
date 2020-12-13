package com.huaxia.java2.treemap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

class TreeMapDemo2 {
	TreeMap<String, Part> treemap;
	HashMap<String, Part> map = new HashMap<String, Part>();

	TreeMapDemo2() {
		treemap = new TreeMap<String, Part>(new MyComparator());

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
		treemap.putAll(map); 
	}

	public static void main(String args[]) {
		TreeMapDemo2 tmd = new TreeMapDemo2();

		// Calling the method sortByvalues
		for (String key : tmd.treemap.keySet()) {
			System.out.println(tmd.treemap.get(key));
		}
	}

	class MyComparator implements Comparator<String> {

		@Override
		public int compare(String k1, String k2) {
			Part p1 = (Part) map.get(k1);
			Part p2 = (Part) map.get(k2);
			int i = p1.getMake().compareTo(p2.getMake());
			if (i != 0) {
				return i;
			}
			i = p1.getModel().compareTo(p2.getModel());
			if (i != 0) {
				return i;
			}
			int year1 = p1.getYear();
			int year2 = p2.getYear();
			if (year1 == year2)
				return 0;
			if (year1 < year2)
				return -1;
			return 1;
		}

	}
}
