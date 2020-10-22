package com.huaxia.java2;

import java.util.*;

public class PartList {
	ArrayList<Part> partList = new ArrayList<Part>();

	public void sortMap() {
		TreeMap<Part, Integer> myMap = new TreeMap<>();
		for (Part p : partList) {
			if (myMap.containsKey(p))

				myMap.put(p, myMap.get(p) + 1);
			else
				myMap.put(p, 1);
		}
		// return myMap;
		for (Map.Entry<Part, Integer> val : myMap.entrySet()) {
			System.out.println(val.getKey() + " " + val.getValue());

		}

	}
}
