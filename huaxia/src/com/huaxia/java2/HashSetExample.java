package com.huaxia.java2;

import java.util.HashSet;

public class HashSetExample {
	public static void main(String[] args) {
//creating a HashSet  
		HashSet<String> hs = new HashSet<String>();
// add elements to HashSet   
		hs.add("New York City");
		hs.add("Houston");
		hs.add("Tucson");
		hs.add("Los Angeles");
		hs.add("Chicago");
		hs.add("Boston");
		hs.add("Denver");
//adding a duplicate element to the HashSet  
		hs.add("Chicago");
//prints the HashSet element on the console    
		System.out.println("HashSet elements are: ");
		for (String temp : hs) {
			System.out.println(temp);
		}
	}
}