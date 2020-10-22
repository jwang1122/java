package com.huaxia.java2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * This version of sort, return back with sorted LinkedHashMap.
 * 
 * @author john
 *
 */
public class PartsRunner3 {
	private Map<String, Part> sortedParts;

	public PartsRunner3() {
		PartList parts = new PartList();
		HashMap<String, Part> map = parts.loadParts();
		System.out.println("Total number of parts is " + map.size());
		for (String key : map.keySet()) {
			Part p = map.get(key);
			System.out.println(p);
		}
		
		sortedParts = map.entrySet()
						.stream()
						.sorted(new MyComparator())
						.collect(Collectors.toMap(Entry::getKey, Entry::getValue, 
								(e1, e2) -> e2, LinkedHashMap::new));
	}

	public static void main(String[] args) {
		PartsRunner3 runner = new PartsRunner3();
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
