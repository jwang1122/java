package com.huaxia.apcomputer.exam1;

public class Question5 {

	public static int findMin(int[] arr) {
//	    int min = arr[0] /* some value */; // if the first one is the smallest in the arr[], it will be returned.
//	    int min = Integer.MAX_VALUE /* some value */;
		int min = Integer.MIN_VALUE /* some value */; // no integer can be small than MIN_VALUE
		int index = 0;
		while (index < arr.length) {
			if (arr[index] < min)
				min = arr[index];
			index++;
		}
		return min;
	}

	public static void main(String[] args) {
		int[] arr = { 23, 5, 78, 43, 56, 112 };
		int min = findMin(arr);
		System.out.println(min);
	}

}
