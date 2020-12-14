package com.huaxia.java2.lambda;

import java.util.Arrays;
import java.util.List;
/*
 	map() - forEach()
 */
public class Lambda4 {
	public static void main(String[] args) {
		// applying 12% VAT on each purchase 
		// Without lambda expressions: 
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500); 
		for (Integer cost : costBeforeTax) { 
			double price = cost + .12*cost; 
			System.out.println(price); 
		} 
		System.out.println();
		
		// With Lambda expression: 
		costBeforeTax = Arrays.asList(100, 200, 300, 400, 500); 
		costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);

	}
}
