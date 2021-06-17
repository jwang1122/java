package com.huaxia.java1;

public class DataType {

	public static void main(String[] args) {
		// Primitive Data Type
		boolean flag = false; // true, false
		byte myByte = 127; // 8 bits, -128~127
		char c = 65; // ASCII:American Standard Code for Information Interchange, 7 bits
		short myShort = 128;
		int a = 1234542345; // int is data type of integer
		long l = 123454234563242L; // put L, or l, on the end
		float x = 129.3F; // f or F on the end
		double y = 12.3;
//		x = (float)y; //cast: assign large value to smaller data type
		myByte = (byte) x;
		System.out.println(flag);
		System.out.println(c);
		System.out.println(myByte);
		System.out.println(a + x + y + myByte + myShort + c + l);// ?why output a double?
		
		// String is Java defined data type
		String name = "John"; // name is an instance of String
		System.out.println(name);
		System.out.println(name instanceof String);
		
		// User defined data type, Print is a user defined data type
		Print p = new Print();
//		Hello h = new Hello();
		System.out.println(p instanceof Print);
		System.out.println(p.add(4, a));
		String[] myStringArray = {"a", "b"};
		Hello.main(myStringArray);
		
	}

}
