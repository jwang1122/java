package com.huaxia.java2.functional;

import java.util.ArrayList;
import java.util.List;

/*
 * Terminal Operations
 * The terminal operations of the Java Stream interface 
 * typicall return a single value.
 * http://tutorials.jenkov.com/java-functional-programming/streams.html
 */
public class Stream7 {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();

		stringList.add("ONE");
		stringList.add("TWO");
		stringList.add("THREE");
		stringList.add("FOUR");
		stringList.add("FIVE");
		stringList.add("SIX");

		long count = stringList.stream().map((value) -> {
			return value.toLowerCase();
		}).map((value) -> {
			return value.toUpperCase();
		}).map((value) -> {
			return value.substring(0, 3);
		}).count();
		
		System.out.println("count = " + count);
	}

}
