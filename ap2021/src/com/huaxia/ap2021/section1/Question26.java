package com.huaxia.ap2021.section1;
/**
 * Path by reference.
 * @author John
 *
 */
public class Question26 {
	
	public static void swap1(int[] a1, int[] a2) { // make change on contents
		for (int i=0; i< a1.length; i++) {
			int arrhold = a1[i];
			a1[i] = a2[i];
			a2[i] = arrhold;
		}
	}
	
	public static void swap2(int[] a1, int[] a2) { // swap local reference
		int[] arrhold = a1;
		a1 = a2;
		a2 = arrhold;
	}
	
	public static void main(String[] args) {
		int[] a1 = {1,2,3,4,5};
		int[] a2 = {6,7,8,9,10};
		swap2(a1, a2);
		for(int i : a1)
			System.out.print(i + " ");
		System.out.println();
		for(int i : a2)
			System.out.print(i + " ");
		System.out.println();

		swap1(a1, a2);
		for(int i : a1)
			System.out.print(i + " ");
		System.out.println();
		for(int i : a2)
			System.out.print(i + " ");
		System.out.println();
	}
}
