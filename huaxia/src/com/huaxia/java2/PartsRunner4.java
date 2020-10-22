package com.huaxia.java2;

import java.util.Map.Entry;

/**
 * This version of sort, return back with sorted TreeMap.
   * 使用TreeMap来对key-value中的value排序。好处是只需要为TreeMap提供Comparator，然后把数据放入TreeMap，排序就完成了。
 * 
 * @author john
 *
 */
public class PartsRunner4 {
	public static void main(String[] args) {
		PartList parts = new PartList();
		parts.buildMapFromDataFile();
		parts.sortTreeMap();
		System.out.println("\nSorted Auto-Parts");
		for (Entry<String, Part> e : parts.treemap.entrySet()) {
			System.out.println(e.getValue());
		}
	}
}
