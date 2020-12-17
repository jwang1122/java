package com.huaxia.learnrxjava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
// http://tutorials.jenkov.com/java-functional-programming/index.html
// https://www.programcreek.com/java-api-examples/?api=io.reactivex.functions.Function
public class Stream4 {

	static Integer sum(List<Integer> numbers) {
	    return numbers.stream().collect(Collectors.summingInt(Integer::intValue));
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		int sum = sum(list);
		System.out.println(sum);
	}

	
	
}
