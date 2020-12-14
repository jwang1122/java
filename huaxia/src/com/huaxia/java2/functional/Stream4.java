package com.huaxia.java2.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/*
 * distinct()
 */
public class Stream4 {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();

		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		stringList.add("one");

		Stream<String> stream = stringList.stream();

		List<String> distinctStrings = stream.distinct().collect(Collectors.toList());

		System.out.println(distinctStrings);
	}
}
