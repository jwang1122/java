package com.huaxia.homeworks;

import static java.lang.System.*;
import java.util.*;
import java.util.Map.Entry;

public class PartsRunner {
	public static void main(String[] args) {
		String partString;
		PartList warehouse = new PartList();
		Scanner input = new Scanner(in);
		out.println("Enter in the number of parts:");
		int size = input.nextInt();
		input.nextLine();
		out.println("Enter in one part per line");
		while (size > 0) {
			size--;
			partString = input.nextLine();
			warehouse.addPart(partString);
		}
		out.println("Current Inventory");
		warehouse.sortTreeMap();
		displayMap(warehouse.getSortedPartMap());
//out.println(warehouse);
		out.println("Enter minumum stock:");
		size = input.nextInt();
		out.println("Order List");
//out.println(warehouse.orderSheet(size));
	}

	private static void displayMap(Map<Part, Integer> map) {
		for (Entry<Part, Integer> e : map.entrySet()) {
			System.out.println(e.getValue());
		}
	}

}
