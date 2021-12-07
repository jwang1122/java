package com.huaxia.java1;

import java.util.Arrays;

public class DataType {

	static void primitiveDataType() {
		// primitive data type
		boolean b = true;         // 1 bit
		byte myByte = -128;       // 1 byte(8 bits) -128~127: 0111 1111 , bit7 is a sign bit
		short myShort = 256;      // 2 bytes -32,768~32,767
		char div = 247;           // 2 bytes \u0000 ~ \uffff; '' for char, "" for String, ASCII
		int myInt = 65;           // 4 bytes
		long myLong = 123456789l; // 8 bytes -9,223,372,036,854,775,808~9,223,372,036,854,775,807
		float f1 = 1.234567f;     // 4 bytes cannot assign large value to a smaller container
		double d1 = 123456.78912; // 8 bytes 
		div = (char)myInt; // cast: force to asign a different different data type 
//		d1 = f1; // allow assign small value to large container
//		d1 = myLong; // that will not lose any accuracy
//		f1 = d1; // not allowed assign large value to small container
		f1 = (float)d1; // lose accuracy
		
		// different way to assign integer
		myInt = 0x1a; // base 16 number (hex)1,2,3,4,5,6,7,8,9,a,b,c,d,e,f
		myInt = 0x41; // base 2 number (binary) 0,1, computer only know switch on/off
		myLong = 12_345_678; // _ only for easy reading
		
		// _ for floating number
		f1 = 3.141_5f;
		
		System.out.println(b);
		System.out.println(myByte);
		System.out.println(myShort);
		System.out.println(myInt);
		System.out.println(myLong);
		System.out.println(f1);
		System.out.println(d1);
		System.out.println(div);		
	}
	
	static void javaDefinedDataType() {
		// Java built in data type
		String s = "Hello, the world. 1 2 3 4"; // String is a java built in data type
		System.out.println(s);
		System.out.println(s.charAt(5));
		System.out.println(s.concat(" How are you doing?"));
		String[] sa = s.split(" ");
		System.out.println(Arrays.toString(sa));
		for (int i=0; i<sa.length; i++) {
			System.out.println(sa[i]);
		}
		StringBuffer sb = new StringBuffer(s); // StringBuffer is also a java built in data type
		sb.append(" I'm John.");
		sb.append(3.1456);
		System.out.println(sb);
		
		String s1 = new String("1234");
		String s2 = new String("1234"); // different drawer with same content 
		System.out.println(s1==s2);     // False
		System.out.println(s1.equals(s2)); // True
		s1 = "1234";  // defined a constant value and assign to s1
		s2 = "1234";
		System.out.println(s1==s2); // compare the memory location
		System.out.println(s1.equals(s2)); // compare the content on the location		
	}
	
	static void developerDefinedDataType() {
		Hello h1 = new Hello("John"); // define h as Hello type, treat Hello as a data type
//		Hello.main(null); // static way to call static method
		Hello h2 = new Hello("Owen");
		System.out.println(h1==h2);
		System.out.println(h1);
		System.out.println(h2);
		
	}
	public static void main(String[] args) {
//		primitiveDataType();
//		javaDefinedDataType();
		developerDefinedDataType();
	}

}
