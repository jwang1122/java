package com.huaxia.test;

public class Tester {

	public static void main(String[] args) {
		Math1 math = new Math1();
		int z = math.add(10, 30);
		System.out.println("10+30=" + z);
		z = math.mul(10, 30);
		System.out.println("10*30=" + z);
	}

}
