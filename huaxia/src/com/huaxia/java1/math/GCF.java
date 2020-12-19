package com.huaxia.java1.math;
/*
 * GCF: Greatest Common Factor
 */
public class GCF {
	public static int gcf(int a, int b) {
		if (b == 0) {
			return a;
		}
		return (gcf(b, a % b));
	}

	public static void main(String[] args) {
		System.out.println(gcf(45,36));

	}

}
