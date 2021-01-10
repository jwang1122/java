package com.huaxia.ap2021.section1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1. if-else, one condition meet, others will not be executed.
 * 
 * 2. String.compareTo(Object) returns integer, neigative, 0, positive
 * 3. This code is not good implementation for the purpose.
 *  
 * @author John
 *
 */
public class Question08 {

	public static void main(String[] args) {
		String word1 = "frog";
		String word2 = "dog";
		String word3 = "cat";

		if (word1.compareTo(word2) < 0)
			if (word2.compareTo(word3) < 0)
				System.out.println(word1 + " " + word2 + " " + word3);
			else
				System.out.println(word1 + " " + word3 + " " + word2);
		else if (word1.compareTo(word2) > 0)
			if (word2.compareTo(word3) < 0)
				System.out.println(word1 + " " + word2 + " " + word3);
			else
				System.out.println(word1 + " " + word3 + " " + word2);
		else if (word2.equals(word3))
			System.out.println("All the words are the same.");
		else
			System.out.println("Word1 and word2 are duplicated.");

//Additional code for sorting correctly.
		List<String> list = Arrays.asList("frog","dog","cat");
		Collections.sort(list);
		for(String s:list) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		Collections.reverse(list);
		for(String s:list) {
			System.out.print(s + " ");
		}
		System.out.println("\nDone.");
	}

}
