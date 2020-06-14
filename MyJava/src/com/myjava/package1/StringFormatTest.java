package com.myjava.package1;

public class StringFormatTest {

	public static void main(String[] args) {
		String name = "John";
		String sf1 = String.format("name is %s.", name);
		String sf2 = String.format("value is %f.", 3.1415926);
		String sf3 = String.format("value is %5.3f.", 3.1415926);
		System.out.println(sf1);
		System.out.println(sf2);
		System.out.println(sf3);
	}

}
