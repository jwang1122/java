package com.huaxia.java2.functional;
/*
 * Create Stream from Array
 * http://tutorials.jenkov.com/java-functional-programming/streams.html
 */
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream15 {
	public static void main(String[] args) {
		Stream<String> streamOf = Stream.of("one", "two", "three");
		List<String> list = streamOf.collect(Collectors.toList());
		System.out.println(list);
	}

}
