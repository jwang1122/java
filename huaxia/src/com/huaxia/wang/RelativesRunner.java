package com.huaxia.wang;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

public class RelativesRunner {

	public static void main(String[] args) {
		Relatives relatives = new Relatives();
		relatives.loadData();
		for(Entry<String, List<String>> e : relatives.getRelativeMap().entrySet()) {
			System.out.printf("%s is related to ", e.getKey());
			List<String> list = e.getValue();
			Collections.sort(list);
			System.out.println(list);
		}
	}
}
