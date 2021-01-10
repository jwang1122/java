package com.huaxia.ap2021.section1;

/**
 * pay attention on loop index
 * 
 * @author John
 *
 */
public class Question16 {

	public static void main(String[] args) {
		int j = 0;
		String s = "map";
		while (j < s.length()) {
			int k = s.length();
			while (k > j) {
				System.out.println(s.substring(j, k));
				k--;
			}
			j++;
		}
	}
}
