package com.huaxia.java1;

public class DataTypeTester {

	public static void main(String[] args) {
		DataTypeTester test = new DataTypeTester();
//		test.primitiveDataType();
		test.dataTypeCast();
	}

	/**
	 * Widening Casting:
	 * byte > short > char > int > long > float > double 
	 * (automatically from less accurate to most accurate)
	 * 
	 * Narrowing Casting:
	 * double > float > long > int > char > short > byte
	 * (convert from large type to a smaller size type)
	 */
	void dataTypeCast() {
		int myInt = 9;
		// Widening casting
		double d = myInt;
		System.out.println(d);

		double pi = 3.1415926535;
		myInt = (int) pi;
		System.out.println(pi);
		System.out.println(myInt);
	}

	void primitiveDataType() {
		// Primitive Data Type
		byte myByte = 127; //bit byte
		short myShort = 256;
		int myNum = 5; // integer (whole number)
		long myLong = 123456789;
		float myFloatNum = 5.99f; // floating point number
		float f1 = 35e13f;
		double myDouble = 5.321;
		double d1 = 35e29d;
		char myLetter = 'D'; // character
		char letterA = 65;
		boolean myBool = true; // boolean
		boolean myBool2 = false;
		boolean myBool3 = myByte > myShort;
		boolean myBool4 = myNum == 5;

		String myText = "Hello"; // String

		System.out.println(myByte);
		System.out.println(myShort);
		System.out.println(myNum);
		System.out.println(myLong);
		System.out.println(myFloatNum);
		System.out.println(f1);
		System.out.println(d1);
		System.out.println(myDouble);
		System.out.println(myLetter);
		System.out.println(letterA);
		System.out.println(myBool);
		System.out.println(myBool2);
		System.out.println(myBool3);
		System.out.println(myBool4);
		System.out.println(myText);

	}

}
