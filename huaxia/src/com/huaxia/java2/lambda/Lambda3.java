package com.huaxia.java2.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
/*
 * filter() - forEach()
 */
public class Lambda3 {

	public static void main(String[] args) {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		Predicate<String> startsWithJ = (n) -> n.startsWith("J"); 
		Predicate<String> fourLetterLong = (n) -> n.length() == 4; 
		languages.stream() 
		.filter(startsWithJ.and(fourLetterLong)) 
		.forEach((n) -> System.out.print("\nName, which starts with 'J' and four letter long is : " + n));
		System.out.println();
	}
}
