package com.huaxia.java1.homework;

public class MethodHW1 {
	static double smallest(double v1, double v2, double v3) {
		return Math.min(v1, Math.min(v2, v3));
	}
	public static void main(String[] args) {
		System.out.println(smallest(25,37,29));
		

	}

}
