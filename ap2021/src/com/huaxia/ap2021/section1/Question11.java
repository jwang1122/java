package com.huaxia.ap2021.section1;

import java.util.ArrayList;
import java.util.List;

/*
 * 1. familiar with index start from 0 end at length()-1
 * 2. String.length() is method call not constant like array. 
 */
public class Question11 {

	public static void main(String[] args) {
		String str1 = "banana";
		String str2 = "";
		int i = str1.length() - 1; // method call for String.
		while (i >= 0) {
			str2 += str1.substring(i, i + 1);
			i--;
		}
		System.out.println(str2);
		
		String[] arr = {"banana","apple","pear","orange"};
		System.out.println(arr.length); // constant for array.
		
		List<String> list = new ArrayList<>();
		list.add("banana");
		list.add("apple");
		list.add("pear");
		list.add("orange");
		System.out.println(list.size()); // method call for List.
	}

}
