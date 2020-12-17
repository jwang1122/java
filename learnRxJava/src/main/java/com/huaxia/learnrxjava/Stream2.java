package com.huaxia.learnrxjava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream2 {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
		long count = strList.stream().filter(x -> x.isEmpty()).count();
		System.out.printf("There are %d empty strings.\n", count);

		List<String> noEmpty = strList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
		System.out.println(noEmpty);

		List<String> greaterThan2 = strList.stream().filter(x -> x.length()>2).collect(Collectors.toList());
		System.out.println(greaterThan2);

		List<String> containB = strList.stream().filter(x -> x.contains("b")).collect(Collectors.toList());
		System.out.println(containB);

		long num = strList.stream().filter(x -> x.length() > 3).count();
		System.out.printf("There are %d string greater than 3.\n", num);
	}
}
