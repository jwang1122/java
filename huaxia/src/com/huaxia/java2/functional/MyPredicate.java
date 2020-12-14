package com.huaxia.java2.functional;

import java.util.function.Predicate;

public class MyPredicate {

	public static void main(String[] args) {
		Predicate<String> predicate = (value) -> value !=null;
		String name = "John";
		System.out.println(predicate.test(name));
		name = null;
		System.out.println(predicate.test(name));
	}

}
