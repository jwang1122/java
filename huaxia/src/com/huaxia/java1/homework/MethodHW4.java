package com.huaxia.java1.homework;

import java.util.Arrays;
import java.util.List;

public class MethodHW4 {
	public static int count_Vowels(String str) {
		int count = 0;

		int[] vowels = { 'a', 'e', 'i', 'o', 'u' };
//		List list = Arrays.asList(vowels);

		for (int i = 0; i < str.length(); i++) {
			int c = str.charAt(i);
			if (contains(vowels, c))
				count++;
//			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
//					|| str.charAt(i) == 'u') {
//				count++;
//			}
		}
		return count;
	}

	static boolean contains(int[] arr, int value) {
		for (int v : arr) {
			if (v == value)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(count_Vowels("w3resource"));
		Integer[] arr = { 1, 2, 3, 4, 5 };
		List<Integer> list = Arrays.asList(arr);
		System.out.println(list.contains(3));
	}

}
