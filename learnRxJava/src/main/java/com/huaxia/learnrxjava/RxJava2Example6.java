package com.huaxia.learnrxjava;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RxJava2Example6 {

	public static void main(String[] args) {
		List<String> myList = Stream.of("a", "b").map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(myList);
		List<List<String>> list = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
		System.out.println(list);
		System.out.println(list
				  .stream()
				  .flatMap(Collection::stream)
				  .collect(Collectors.toList()));
	}

}
