package com.huaxia.ap2021.section1;

/*
 * arr1 and arr2 are the same.
 */
public class Question22 {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5, 6};
		int[] arr2 = arr1;
		int last = arr1.length - 1;
		
		for(int i=0; i<arr1.length; i++)
			arr2[i] = arr1[last-i];
		
		for(int i=0; i<arr1.length; i++)
			System.out.print(arr1[i] + " ");
		
		System.out.println(" ");
		
		for (int i=0; i<arr2.length; i++)
			System.out.print(arr2[i] + " ");
		
		System.out.println("\nDone.");
	}

}
