package com.huaxia.john;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class PartsRunner {

	public static void main(String[] args) {
		PartList parts = new PartList();
		HashMap<String, Part> map = parts.loadParts();
		System.out.println("Total number of parts is " + map.size());
		for(String key : map.keySet()) {
			Part p = map.get(key);
			System.out.println(p);
		}
		
		List<Entry<String, Part>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<String,Part>>() {

			@Override
			public int compare(Entry e1, Entry e2) {
				Part p1 = (Part)e1.getValue();
				Part p2 = (Part)e2.getValue();
				int i = p1.getMake().compareTo(p2.getMake());
				if (i!=0) {
					return i;
				}
				i = p1.getModel().compareTo(p2.getModel());
				if (i!=0) {
					return i;
				}
				int year1 = p1.getYear();
				int year2 = p2.getYear();
				if(year1==year2) return 0;
				if(year1<year2) return -1;
				return 1;				
			}
			
		});
		System.out.println("\nSorted Auto-Parts");
		for(Entry e : entries) {
			System.out.println(e.getValue());
		}
	}


}
