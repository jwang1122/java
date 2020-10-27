package com.huaxia.homeworks;

import java.util.Map.Entry;
import java.util.TreeMap;


public class PartList {
	private TreeMap<Part, Integer> sortedPartMap = new TreeMap<>();

	public void addPart(String line) {
		Part part = new Part(line);
		if (sortedPartMap.containsKey(part)) {
			int count = sortedPartMap.get(part);
			sortedPartMap.put(part, ++count);
		} else {
			sortedPartMap.put(part, 1);
		}
	}

	public String orderSheet(int size) {
		String result = "";
		for(Entry<Part, Integer> e : sortedPartMap.entrySet()) {
			if(e.getValue()<size) {
				result = result.concat(e.getValue()+" ").concat(e.getKey().toString()).concat("\n");
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "PartList [sortedPartMap=" + sortedPartMap + "]";
	}
	
	
}
