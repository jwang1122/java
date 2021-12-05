package com.huaxia.java2.treemap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PartList2 {
	public static final String filename = "/Users/12818/workspace/java/huaxia/docs/autoparts.dat";
	private HashMap<String, Part> randomPartMap = new HashMap<>();
	private List<Part> autoPartList = new ArrayList<Part>();
	private Map<String, Part> sortedPartMap;
	
	public HashMap<String, Part> loadParts() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			autoPartList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add count to same part
		for (Part part : autoPartList) {
			UUID uuid = UUID.randomUUID();
			String id = uuid.toString();
			part.setUuid(id);
			if (randomPartMap.containsValue(part)) {
				for(Part p: randomPartMap.values()) {
					if(p.equals(part)) {
						p.addCount();
						break;
					}
				}
			}else {
				part.addCount();
				randomPartMap.put(part.getUuid(), part); // use generic UUID as key
			}
		}
		return randomPartMap;
	}

	// functional programing provide this function for map
	private Function<String, Part> mapToItem = (line) -> {
		String[] parts = line.split(",");
		int year = Integer.parseInt(parts[2].trim());
		Part item = new Part(parts[0], parts[1], year);
		return item;
	};
	
	public HashMap<String, Part> getRandomPartMap() {
		return randomPartMap;
	}

	// generic comparator that compare autoparts by value
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

	void sortTreeMap() {
		sortedPartMap = sortByValues(randomPartMap);
	}
	
	public Map<String, Part> getSortedPartMap() {
		return sortedPartMap;
	}
}