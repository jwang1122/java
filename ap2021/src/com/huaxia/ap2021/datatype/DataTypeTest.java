package com.huaxia.ap2021.datatype;

public class DataTypeTest {

	public static void main(String[] args) {
//		math();
//		area();
		stringIndex();
	}

	private static void stringIndex() {
		String s = "This is the beginning";
		String t = s.substring(5);
		int n = t.indexOf("the");
		System.out.println(n);
	}

	static void math() {
		int a = 11;
		int b = 4;
		double x = 11;
		double y = 4;
		System.out.print(a / b);
		System.out.print(", ");
		System.out.print(x / y);
		System.out.print(", ");
		System.out.print(a / y);
	}

	static void area() {
		int r = 22;
		double a = r * r * Math.PI; // r is the int 22
		System.out.println(a);
		double rd = 22.0;
		a = rd * rd * Math.PI; // r is the double 22.0
		System.out.println(a);
		a = (double) r * r * Math.PI; // r is the int 22 the int 22
		System.out.println(a);
		a = (double) (r * r) * Math.PI; // r is the int 22
		System.out.println(a);

	}
}
