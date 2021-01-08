package com.huaxia.ap2021.section1;

/**
 * I have different opinion, (C) should be better answer. (English issue)
 * 
 * @author John
 *
 */
public class Question24 {
	static int[] numbers = { -12, -23, -4, -56, -74, -256 }; // for all negative

	public static void main(String[] args) {
		int holdSmallest = Integer.MAX_VALUE;
		int holdLargest = 0; // all negative number will always give b=0
		int a = 0;
		int b = 0;
		for(int i=0; i<numbers.length; i++) {
			if (numbers[i] <= holdSmallest) {
				holdSmallest = numbers[i];
				a = i;
			}
			if(numbers[i] >= holdLargest) {
				holdLargest = numbers[i];
				b = i;
			}
		}
		System.out.println(a + " " + b);
	}
}
