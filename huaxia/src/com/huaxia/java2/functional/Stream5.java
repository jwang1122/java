package com.huaxia.java2.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/*
 * limit()
 */
public class Stream5 {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();

		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		stringList.add("one");

		Stream<String> stream = stringList.stream();
		stream.limit(2).forEach(System.out::println);
	}

}
