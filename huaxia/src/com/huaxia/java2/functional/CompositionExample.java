package com.huaxia.java2.functional;
/*
 * http://tutorials.jenkov.com/java-functional-programming/functional-composition.html
 */
import java.util.function.Predicate;

public class CompositionExample {

	public static void main(String[] args) {
		Predicate<String> startsWithA = (text) -> text.startsWith("A");
		Predicate<String> endsWithX = (text) -> text.endsWith("x");

		Predicate<String> startsWithAAndEndsWithX = (text) -> startsWithA.test(text) && endsWithX.test(text);

		String input = "A hardworking person must relax";
		boolean result = startsWithAAndEndsWithX.test(input);
		System.out.println(result);
		
		input = "This is a test.";
		result = startsWithAAndEndsWithX.test(input);
		System.out.println(result);
		
		Predicate<String> composed = startsWithA.and(endsWithX);
		input = "A hardworking person must relax";
		result = composed.test(input);
		System.out.println(result);
		
		input = "This is a test.";
		result = composed.test(input);
		System.out.println(result);
		
		composed = startsWithA.or(endsWithX);

		input = "A hardworking person must relax sometimes";
		result = composed.test(input);
		System.out.println(result);
	}

}
