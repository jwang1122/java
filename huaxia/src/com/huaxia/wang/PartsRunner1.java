package com.huaxia.wang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class PartsRunner1 {
	private List<Entry<String, Part>> entries;
	
	public PartsRunner1() {
		PartList1 parts = new PartList1();
		HashMap<String, Part> map = parts.loadParts();
		System.out.println("Total number of parts is " + map.size());
		for (String key : map.keySet()) {
			Part p = map.get(key);
			System.out.println(p);
		}

		entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new MyComparator());		
	}
	
	public static void main(String[] args) {
		PartsRunner1 runner = new PartsRunner1();
		System.out.println("\nSorted Auto-Parts");
		for (Entry<String, Part> e : runner.entries) {
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
