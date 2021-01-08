package com.huaxia.ap2021.section1;
/*
 * no effect on original arr3
 */
public class Question23 {

	public static void main(String[] args) {
		int[] arr3 = {1, 2, 3, 4, 5, 6};
		
		for (int element : arr3) {
			element *=2;
			System.out.print(element + " ");
		}
		System.out.println("");
		
		for(int element: arr3)
			System.out.print(element + " ");
	}

}
