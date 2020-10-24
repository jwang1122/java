package com.huaxia.homeworks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class PartList {
 
	private HashMap<Part, Integer> randomPartMap = new HashMap<>();
	private List<Part> autoPartList = new ArrayList<Part>();
	private TreeMap<Part,Integer> sortedPartMap;
	
	public void addPart(String line) {
		/*
	//	try {
			//Scanner input = new Scanner(System.in);
			//String line = input.nextLine();
		//	while(input.hasNext()) {
			//	 String line = input.nextLine();
				String[] items = line.split(" ");
				int length=items.length;
				 
				 String make=items[length-3];
				  String model=items[length-2];
				 int year= Integer.parseInt(items[length-1]);
				 String id=items[length-4];
			//	if(length%2==0) {
	//		 String partDes=items[0]+" "+items[1]+" "+items[2];
				// }
			//	 else
				String	 partDes=items[0]+" "+items[1];
				 
			*/	 
				Part part = new Part(line);
				autoPartList.add(part);
			
			
	 
		
			for (Part part1 : autoPartList) {
				 
				if (randomPartMap.containsValue(part1)) 
				 randomPartMap.put(part1,randomPartMap.get(part1)+1);
				  else
		            	randomPartMap.put(part1,1);
						
					}
				 
			}			
			
		
//	}


/*
				public void sortTreeMap() {
					sortedPartMap = new TreeMap<Part,Integer>(new AutoPartComparator());
					sortedPartMap.putAll(randomPartMap);
				}
*/
		 
			 
		

	
	public void orderSheet(int size) {
		
	}
	public HashMap<Part, Integer> getRandomPartMap() {
		return randomPartMap;
	}

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

	public void sortTreeMap() {
		sortedPartMap = (TreeMap<Part, Integer>) sortByValues(randomPartMap);
	}
	
	public Map<Part, Integer> getSortedPartMap() {
		return sortedPartMap;
	}
}
	  
	 
