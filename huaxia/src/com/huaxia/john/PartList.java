package com.huaxia.john;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PartList {
	public static final String filename = "\\Users\\12818\\workspace\\java\\huaxia\\docs\\autoparts.csv";
	private HashMap<String, Part> map = new HashMap<>();
	private List<Part> autoPartList = new ArrayList<Part>();

	public HashMap<String, Part> loadParts() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			autoPartList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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

	public HashMap getMap() {
		return map;
	}

	private Function<String, Part> mapToItem = (line) -> {
		String[] parts = line.split(",");
		int year = Integer.parseInt(parts[2].trim());
		Part item = new Part(parts[0], parts[1], year);
		return item;
	};
}
