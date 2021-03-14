package com.huaxia.java1.homework;

import java.util.Arrays;
import java.util.List;

public class MethodHW4 {
	public static int count_Vowels(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count_Vowels("w3resource"));
		int[] arr = {1,2,3,4,5};
		List list = Arrays.asList(arr);
		System.out.println(list.contains(3));
	}

}
