package com.huaxia.java1;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest {
	public static void main(String[] args) {
		SortTest test = new SortTest();
		test.sortArrayList();
	}

	private void sortArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("JavaFx");
		list.add("Java");
		list.add("WebGL");
		list.add("OpenCV");
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
	}
}
