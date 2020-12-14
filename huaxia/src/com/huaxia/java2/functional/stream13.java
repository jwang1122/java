package com.huaxia.java2.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class stream13 {

	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();

		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");

		Stream<String> stream = stringList.stream();

		Object[] objects = stream.toArray();
		for(Object obj: objects) {
			System.out.println(obj);
		}
	}

}
