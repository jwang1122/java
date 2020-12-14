package com.huaxia.java2.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream1 {

	public static void main(String[] args) {
		List<String> items = new ArrayList<String>();

		items.add("one");
		items.add("two");
		items.add("three");

		Stream<String> stream = items.stream();
		stream.forEach(System.out::println);
	}

}
