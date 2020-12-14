package com.huaxia.java2.functional;

/**
 * forEach(), min(), max(), reduce()
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream12 {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();

		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		stringList.add("four");
		stringList.add("one");

		Stream<String> stream = stringList.stream();

		stream.forEach(element -> {
			System.out.println(element);
		});

		stream = stringList.stream();
		Optional<String> min = stream.min((val1, val2) -> {
			return val1.compareTo(val2);
		});

		String minString = min.get();

		System.out.println(minString);
		
		stream = stringList.stream();

		Optional<String> max = stream.max((val1, val2) -> {
		    return val1.compareTo(val2);
		});

		String maxString = max.get();

		System.out.println(maxString);
		
		stream = stringList.stream();

		Optional<String> reduced = stream.reduce((value, combinedValue) -> {
		    return combinedValue + " + " + value;
		});

		System.out.println(reduced.get());	}

}
