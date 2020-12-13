package com.huaxia.java2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
/*
 * map() > distinct > collect
 * mapToInt() > summaryStatistics()
 */
//https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html
public class Stream3 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream()
				.map(i -> i * i)
				.distinct()
				.collect(Collectors.toList());
		System.out.println(distinct);
		
		distinct = numbers.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println(distinct);

		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29); 
		IntSummaryStatistics stats = primes.stream() 
				.mapToInt((x) -> x) 
				.summaryStatistics();
		System.out.println(stats);
		System.out.println("Highest prime number in List : " + stats.getMax()); 
		System.out.println("Lowest prime number in List : " + stats.getMin()); 
		System.out.println("Sum of all prime numbers : " + stats.getSum()); 
		System.out.println("Average of all prime numbers : " + stats.getAverage());

		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada"); 
		String G7Countries = G7.stream() 
				.map(x -> x.toUpperCase()) 
				.collect(Collectors.joining(", ")); 
		System.out.println(G7Countries);
	}

}
