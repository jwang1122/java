package com.huaxia.java2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This version of sort, return back with sorted LinkedHashMap.
 * 
 * @author john
 *
 */
public class PartsRunner2 {
	private List<Entry<String, Part>> partList;
	private Map<String, Part> sortedParts;

	public PartsRunner2() {
		PartList parts = new PartList();
		HashMap<String, Part> map = parts.loadParts();
		System.out.println("Total number of parts is " + map.size());
		for (String key : map.keySet()) {
			Part p = map.get(key);
			System.out.println(p);
		}
		partList = new LinkedList<Map.Entry<String, Part>>(map.entrySet());
		Collections.sort(partList, new MyComparator());
		sortedParts = new LinkedHashMap<String, Part>();
		for (Map.Entry<String, Part> p1 : partList) {
			sortedParts.put(p1.getKey(), p1.getValue());
		}
	}

	public static void main(String[] args) {
		PartsRunner2 runner = new PartsRunner2();
		System.out.println("\nSorted Auto-Parts");
		for (Entry<String, Part> e : runner.sortedParts.entrySet()) {
			System.out.println(e.getValue());
		}
	}

	class MyComparator implements Comparator<Entry<String, Part>> {

		@Override
		public int compare(Entry<String, Part> o1, Entry<String, Part> o2) {

			Part p1 = (Part) o1.getValue();
			Part p2 = (Part) o2.getValue();
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
