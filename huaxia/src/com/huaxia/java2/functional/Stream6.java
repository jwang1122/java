package com.huaxia.java2.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
 * peek()
 */
public class Stream6 {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();

		stringList.add("abc");
		stringList.add("def");

		Stream<String> stream = stringList.stream();

		Stream<String> streamPeeked = stream.peek((value) -> {
			value += "-Modified";
			System.out.println("peek: " + value);
		});
		streamPeeked.collect(Collectors.toList()).forEach(System.out::println);
	}
}
