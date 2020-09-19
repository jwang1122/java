package com.huaxia.john;

public class Print {

	public static void main(String[] args) {
		int a = 2020;
		int b = 40;
		int c = a - b;
		
		System.out.println("2020 - 20 = " + c);
		
		String s = String.format("%d - %d = %d", a, b, c);
		System.out.println(s);

		System.out.println(String.format("%d - %d = %d", a, b, c));
		
		System.out.printf("%d - %d = %d\n", a, b, c);
		System.out.printf("%d + %d = %d\n", a, b, (a+b));
		System.out.printf("%d * %d = %d\n", a, b, (a*b));
		System.out.printf("%d / %d = %5.2f\n", a, b, ((float)a/b));
		
		System.out.printf("PI=%5.3f\n", Math.PI);
		
		String name = "John";
		System.out.println(String.format("Hello, %s!", name));
		System.out.printf("Hello, %s!", name);
	}
}
