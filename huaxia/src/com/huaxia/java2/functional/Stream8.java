package com.huaxia.java2.functional;
/*
 * anyMatch() allMatch() noneMatch()
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream8 {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();

		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");

		Stream<String> stream = stringList.stream();

		boolean anyMatch = stream.anyMatch((value) -> {
			return value.endsWith("muckingbird");
		});
		System.out.println("anyMatch: "+anyMatch);
		
		stream = stringList.stream();

		boolean allMatch = stream.allMatch((value) -> { return value.startsWith("One"); });
		System.out.println("allMatch: " + allMatch);	
		
		stream = stringList.stream();

		boolean noneMatch = stream.noneMatch((element) -> {
		    return "xyz".equals(element);
		});

		System.out.println("noneMatch = " + noneMatch);
	}

}
