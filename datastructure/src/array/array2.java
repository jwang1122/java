package com.huaxia.datastructures;

public class array2 {

	public static void main(String[] args) {
		int marks[] = { 56, 78, 88, 76, 56, 89 };
		float sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += marks[i];
		}
		double avg = (double)sum / marks.length;
		System.out.println(avg);
	}
}
