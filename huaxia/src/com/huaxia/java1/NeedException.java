package com.huaxia.java1;

import java.util.Arrays;

public class NeedException {
	public double circleArea(double radius) {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public String[] splitString(String s) {
		return s.split(" ");
	}
	
	public static void main(String[] args) {
		NeedException c1 = new NeedException();
		double r = 1;
		double area = c1.circleArea(r);
		System.out.printf("The circle area with radius=%.2f is %.3f\n", r, area);
		r=-2;
		area = c1.circleArea(r);
		System.out.printf("The circle area with radius=%.2f is %.3f\n", r, area);

		String y = Arrays.toString(c1.splitString("Hello the world!"));
		System.out.println(y);
		
		c1.splitString(null);
		
		System.out.println("Done.");
	}

}
