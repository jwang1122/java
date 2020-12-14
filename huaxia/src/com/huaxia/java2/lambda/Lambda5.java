package com.huaxia.java2.lambda;

import java.util.Arrays;
import java.util.List;
/*
map() - reduce()
 */
public class Lambda5 {

	public static void main(String[] args) {
		// Applying 12% VAT on each purchase
		// Old way: for-loop
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			total = total + price;
		}
		System.out.println("Total : " + total);
		
		// New way: map-reduce
		costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();

		System.out.println("Total : " + bill);
	}

}
