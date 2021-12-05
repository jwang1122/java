package com.huaxia.java2.treemap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Better way to load data from auto parts data file. (Functional programing)
 * 
 * @author John
 *
 */
public class PartList1 {
	public static final String filename = "/Users/12818/workspace/java/huaxia/docs/autoparts.dat";
	private HashMap<String, Part> map = new HashMap<>();
	private List<Part> autoPartList = new ArrayList<Part>();
	private Map<String, Part> sortedParts;
	TreeMap<String, Part> treemap;
	
	public HashMap<String, Part> loadParts() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			autoPartList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Part part : autoPartList) {
			UUID uuid = UUID.randomUUID();
			String id = uuid.toString();
			part.setUuid(id);
			if (map.containsValue(part)) {
				for(Part p: map.values()) {
					if(p.equals(part)) {
						p.addCount();
						break;
					}
				}
			}else {
				part.addCount();
				map.put(part.getUuid(), part);
				
			}
		}

		return map;
	}

	public HashMap<String, Part> getMap() {
		return map;
	}

	private Function<String, Part> mapToItem = (line) -> {
		String[] parts = line.split(",");
		int year = Integer.parseInt(parts[2].trim());
		Part item = new Part(parts[0], parts[1], year);
		return item;
	};
	
	public void sortMap() {
		sortedParts = map.entrySet()
				.stream()
				.sorted(new MyComparator())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, 
						(e1, e2) -> e2, LinkedHashMap::new));
		
	}
	

	public Map<String, Part> getSortedParts() {
		return sortedParts;
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