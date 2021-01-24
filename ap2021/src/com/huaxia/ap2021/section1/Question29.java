package com.huaxia.ap2021.section1;

import java.util.ArrayList;

public class Question29 {

	public static void main(String[] args) {
		ArrayList<Integer> alist5 = new ArrayList<Integer>();
		int[] a1 = { 21, 6, 2, 8, 1 };
		for (int a : a1) {
			alist5.add(a);
		}
		for (int k = 0; k < alist5.size() - 1; k++) {
			for (int i = 0; i < alist5.size() - 2; i++) {
				if (alist5.get(i) > alist5.get(i + 1)) {
					int hold = alist5.remove(i); // remove method will return removed value
					alist5.add(i + 1, hold); // add item by given position
				}
			}
		}
		System.out.println(alist5);
	}

}
