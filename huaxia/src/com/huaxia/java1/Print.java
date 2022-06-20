package com.huaxia.java1;

public class Print {

	public static void main(String[] args) {
		int x = 2020;
		int y = 20;
		int z = x - y;
		
		System.out.println("2020 - 20 = " + z);
		
		String s = String.format("%d - %d = %d", x, y, z);
		System.out.println(s);

		System.out.println(String.format("%d - %d = %d", x, y, z));
		
		System.out.printf("%d - %d = %d\n", x, y, z);
		
		String plus = "%d + %d = %d\n";
		String minus = "%d - %d = %d\n";
		System.out.printf(minus, x, y, z);
		
		z = x + y;
		System.out.printf(plus, x, y, z);
		
		System.out.printf("PI=%5.4f\n", Math.PI);
		
		String name = "John";
		System.out.println(String.format("Hello, %s!", name));
		
		int a = 0b0100_0001; // assign integer a with a binary number (letter A)
		System.out.println("line-32: " + a);
		System.out.println((char)a); // force integer a to be a character.
		
		a = 0x41; // assign integer a with a Hexadecimal number (letter A)
		System.out.println("line-36: " + a);
		System.out.println((char)a); // force integer a to be a character.
		
		char d = 65;
		System.out.println(d);
		System.out.printf("Binary of letter A is 0b%s\n",'0'+Integer.toBinaryString(d));
		System.out.printf("Hexadecimal of letter A is 0x%s\n",Integer.toHexString(d));
		
		char e = 'A';
		System.out.println(e);
		
		int f = 65;
		System.out.println((char)f);
		
	}

}
