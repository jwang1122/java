package com.huaxia.java2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class Relatives {
//	public static final String filename = "/Users/12818/workspace/java/huaxia/docs/relatives.dat";
	public static final String filename = "/com/huaxia/wang/relatives.dat";

	private Map<String, List<String>> relativeMap;

	public Map<String, List<String>> getRelativeMap() {
		return relativeMap;
	}

	public Relatives() {
		relativeMap = new TreeMap<String, List<String>>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
	}

	public void loadData() {
		Scanner input;
		try {
			URL url = this.getClass().getResource(filename);

			input = new Scanner(new File(url.getFile()));
			String line = input.nextLine(); // skeep first line 14
			while (input.hasNext()) {
				line = input.nextLine();
				String[] items = line.split(" ");
				String name = items[0];
				String relative = "";
				if(items.length>1) {
					relative = items[1].trim();
				}
				if(relative.length()==0) {
					continue;
				}
				if (relativeMap.containsKey(name)) {
					relativeMap.get(name).add(relative);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(relative);
					relativeMap.put(name, list);
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
