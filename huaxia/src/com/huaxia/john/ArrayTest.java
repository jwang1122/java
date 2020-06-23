package com.huaxia.john;

public class ArrayTest {
	int[] integerArray = {1,3,65,32,12};
	
	public static void main(String[] args) {
		ArrayTest test = new ArrayTest();
		test.printTest();
	}
	
	void printTest() {
		for(int i : integerArray) {
			System.out.println(i);
		}
	}
}
