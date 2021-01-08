package com.huaxia.apcomputer;

public class Array1 {

	/**
	 *  What will be output from the following code segment, 
	 *  assuming it is in the same class as the doSomething method?
	 * 
	 * (A) 0 0 
	 * (B) 2 4 
	 * (C) 1 3 
	 * (D) 0 2 
	 * (E) 0 3

	 * purpose of this exam1 is test the concept of passing by value 
	 * or passing by reference. refer to PassByReference.java
	 */
	public void exam1() {
		int[] arr = { 1, 2, 3, 4 };
		doSomething(arr);
		System.out.print(arr[1] + " ");
		System.out.print(arr[3]);
	}

	public void doSomething(int[] list) {
//		int[] b = list.clone();
		int[] b = list;
		for (int i = 0; i < b.length; i++)
			b[i] = i;
	}

	public static void main(String[] args) throws Exception {
		Array1 test = new Array1();
		test.exam1();
		System.out.println();
	}

}
