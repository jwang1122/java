package com.huaxia.java1.homework;

public class ArrayHW2 {

	public static void main(String[] args) {
		int my_array[] = { 12, 21, 43, 84, 35, 67, 27, 18, 92, 10 };
		int sum = 0;

		for (int i : my_array)
			sum += i;
		System.out.println("The sum is " + sum);
	}

}
