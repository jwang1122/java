package com.huaxia.java1;

public class Variable {

	public static void main(String[] args) {
		double width = 14; // define once, use later.
		double length = 5;
		double area = width * length; // 4 is width, 5 is length
		System.out.printf("The rectangle area with width=%.2f and length=%.2f is %.2f\n", width, length, area);

		double abstract1 = 2.3;
		System.out.println(abstract1);
		
		double r = 2.0;
		double circleArea = Math.pow(r, 2) * Math.PI;
		System.out.printf("the circle area with radius=%.2f is %.2f.\n", r, circleArea);

		double r1 = 2.0;
		double circleArea1 = Math.pow(r1, 2) * Math.PI;
		System.out.printf("the circle area with radius=%.2f is %.2f.\n", r1, circleArea1);

		r = 3.5; // reuse your variable without declare it again
		circleArea = Math.pow(r, 2) * Math.PI;
		System.out.printf("the circle area with radius=%.2f is %.2f.\n", r, circleArea);

	}

}
