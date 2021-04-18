package com.huaxia.java1.homework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListHW5 {

	public static void main(String[] args) {
		List<String> list_Strings = new ArrayList<>();
		list_Strings.add("Red");
		list_Strings.add("Green");
		list_Strings.add("Orange");
		list_Strings.add("White");
		list_Strings.add("Black");
		// Print the list
		System.out.println(list_Strings);
		// Update the third element with "Yellow"
		list_Strings.set(2, "Yellow");
		// Print the list again
		System.out.println(list_Strings);
	}

}
