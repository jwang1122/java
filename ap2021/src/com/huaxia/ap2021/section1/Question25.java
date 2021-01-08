package com.huaxia.ap2021.section1;

public class Question25 {
	static int[] sales = { 23, 5, 4, 7, 4, 112, 45 };

	public static void main(String[] args) {
		double avg = 0;
		int i = 0;
		int sum = 0;
		for (int element: sales) {
			sum += element;
		}
		avg = (double)sum / sales.length;
		System.out.println(avg);
	}

}
