package com.huaxia.ap2021.section1;

public class Question31 {

	public static void main(String[] args) {
		int[][] arr2d = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		String s = "";
		for (int a = 0; a < arr2d[0].length; a++) {
			for (int b = 0; b < arr2d.length; b++) {
				s += arr2d[b][a] + " ";
			}
			s += "\n";
		}
		System.out.print(s);
	}

}
