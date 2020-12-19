package com.huaxia.java1.math;
/*
 * ask students to make better print out on console window.
 */
public class MathTest {

	public static void main(String[] args) {
		double x = Math.max(3 / 4., 5. / 8); // find maximum
		System.out.println(x);
		x = Math.min(3 / 4., 5. / 8); // find minimum
		System.out.println(x);
		x = Math.sqrt(81); // square root
		System.out.println(x);
		x = Math.abs(-3.4); // absolute value
		System.out.println(x);
		for (int i = 0; i < 10; i++) {
			int y = (int) (Math.random() * 101); // find random number
			System.out.println(y);
		}
		System.out.println(Math.PI); // PI
		System.out.println(circleArea(2.0)); // circle area
		System.out.println(Math.sin(Math.PI/2.0)); // sine
		System.out.println(Math.cos(Math.PI)); // cosin
		System.out.println(Math.cbrt(27)); // cube root
		System.out.println(Math.ceil(Math.PI)); // ceiling
		System.out.println(Math.floor(Math.PI)); // floor
		
	}
	
	static double circleArea(double radius) {
		return Math.PI * radius * radius;
	}

}
