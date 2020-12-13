package com.huaxia.java2;

import java.util.Arrays;
import java.util.List;

/*
(params) -> expression
(params) -> statement
(params) -> { statements }

 * forEach() with lambda
 */

public class Lambda1 {

	public static void main(String[] args) {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API"); 
		for(String feature:features) {
			System.out.println(feature);
		}
		System.out.println();
		
		features.forEach(n -> System.out.println(n));
		System.out.println();
		
		features.forEach(System.out::println);
		// method reference is denoted by :: (double colon) operator

	}

}
