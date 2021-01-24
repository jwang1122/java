package com.huaxia.ap2021.section1;

import java.util.ArrayList;

public class Question28 {

	public static void main(String[] args) {
		ArrayList<Integer> alist1 = new ArrayList<Integer>();
		int[] a1 = { 2, 4, 6, 7, 8, 10, 11 };
		for (int a : a1) {
			alist1.add(a);
		}
		for (int i = 0; i < alist1.size(); i++) {
			if (alist1.get(i) % 2 == 0) {
				alist1.remove(i); // be careful remove item by index
			}
		}
		System.out.println(alist1);
	}

}
