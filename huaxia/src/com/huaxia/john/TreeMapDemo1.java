package com.huaxia.john;

import java.util.Comparator;
import java.util.TreeMap;

class TreeMapDemo1 {
	TreeMap<Part,String> treemap;
	
	TreeMapDemo1(){
		treemap = new TreeMap<Part, String>(new MyComparator());
		
		Part part1 = new Part("1","1a",2001);
		Part part2 = new Part("2","1a",2003);
		Part part3 = new Part("91","01a",2003);
		Part part4 = new Part("4","24a",2004);
		Part part5 = new Part("5","16a",2005);
		// Put elements to the map
		treemap.put(part1,"Key1");
		treemap.put(part2, "Key2");
		treemap.put(part3,"Key3");
		treemap.put(part4,"Key4");
		treemap.put(part5,"Key5");
		
	}
	public static void main(String args[]) {
		TreeMapDemo1 tmd = new TreeMapDemo1();

		// Calling the method sortByvalues
		for (Part key : tmd.treemap.keySet()) {
			System.out.printf("%s: %s\n",key, key.getUuid());
		}
	}
	class MyComparator implements Comparator<Part>{

		@Override
		public int compare(Part p1, Part p2) {
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


