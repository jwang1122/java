package com.huaxia.wang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.UUID;

public class PartList {
	public static final String filename = "/Users/12818/workspace/java/huaxia/docs/autoparts.dat";
	private HashMap<String, Part> map = new HashMap<>();
	private List<Part> autoPartList = new ArrayList<Part>();
	private TreeMap<String, Part> treemap;
	
	void buildMapFromDataFile() {
		try {
			Scanner input = new Scanner(new File(filename));
			String line = input.nextLine();
			while(input.hasNext()) {
				line = input.nextLine();
				String[] items = line.split(",");
				String model = items[0];
				String make = items[1];
				int year = Integer.parseInt(items[2].trim());
				Part part = new Part(model,make, year);
				autoPartList.add(part);
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
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void sortTreeMap() {
		treemap = new TreeMap<String, Part>(new TreeMapComparator());
		treemap.putAll(map);
	}
	
	public HashMap<String, Part> getMap() {
		return map;
	}

	public TreeMap<String, Part> getTreemap() {
		return treemap;
	}

	class TreeMapComparator implements Comparator<String>{

		@Override
		public int compare(String k1, String k2) {
			Part p1 = (Part)map.get(k1);
			Part p2 = (Part)map.get(k2);
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
