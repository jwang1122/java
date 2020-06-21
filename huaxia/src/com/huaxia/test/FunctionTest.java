package com.huaxia.test;

public class FunctionTest {

	public static void main(String[] args) {
		FunctionTest test = new FunctionTest();
		int z = test.add(5,7);
		System.out.println(z);
		float x = test.add(1.2f, 4.5f);
		System.out.println(x);
	}

	/**
	 * overload method (Same name with different signature)
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	int add(int x, int y) {
		return x + y;
	}
	
	/**
	 * overload method (Same name with different signature)
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	float add(float x, float y) {
		return x + y;
	}
}
