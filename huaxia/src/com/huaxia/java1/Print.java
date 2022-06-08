package com.huaxia.java1;

public class Print {

	public static void main(String[] args) {
		int a = 2020;
		int b = 20;
		int c = a - b;
		
		System.out.println("2020 - 20 = " + c);
		
		String s = String.format("%d - %d = %d", a, b, c);
		System.out.println(s);

		System.out.println(String.format("%d - %d = %d", a, b, c));
		
		System.out.printf("%d - %d = %d\n", a, b, c);
		
		System.out.printf("PI=%5.4f\n", Math.PI);
		
		String name = "John";
		System.out.println(String.format("Hello, %s!", name));
		
		char d = 65;
		System.out.println(d);
		System.out.printf("%s\n",'0'+Integer.toBinaryString(d));
		
		char e = 'A';
		System.out.println(e);
		
		int f = 65;
		System.out.println((char)f);
		
	}

}
