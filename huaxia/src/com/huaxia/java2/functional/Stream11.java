package com.huaxia.java2.functional;
/*
 * findAny(), findFirst()
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream11 {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();

		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		stringList.add("one");

		Stream<String> stream = stringList.stream();

		Optional<String> anyElement = stream.findAny();

		System.out.println(anyElement.get());
		
		stream = stringList.stream();
		Optional<String> result = stream.findFirst();

		System.out.println(result.get());
	}

}
