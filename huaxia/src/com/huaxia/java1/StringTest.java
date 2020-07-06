package com.huaxia.java1;

import java.util.Scanner;

public class StringTest {
	static String s1 = "1234567890";
	static String s2 = "Hello the world!";

	public static void main(String[] args) {
		StringTest test = new StringTest();
//		test.stringLength();
//		test.letterAtIndex("This is a test.", 3);
//		test.upperLowerCase();
//		test.findIndex();
//		test.concatenation();
//		test.stringEquals();
//		test.escapeSquence();
		test.convertStringToNumber();
//		test.stringBuilder();
//		test.stringBuilder2stringBuffer();
	}

	private void convertStringToNumber() {
		String s1 = "2";
		int i1 = Integer.parseInt(s1);
		String s2 = "11";
		int i2 = Integer.parseInt(s2);
		System.out.println(s1 + s2);
		System.out.println(i1 + i2);

		s1 = "2.1";
		s2 = "3.14";
		float f1 = Float.parseFloat(s1);
		float f2 = Float.parseFloat(s2);
		System.out.println(f1 + f2);

		double d1 = Double.parseDouble(s1);
		double d2 = Double.parseDouble(s2);
		System.out.println(d1 + d2);
	}

	/**
	 * String object is mutable, once defined cannot be changed.
	 * Same value of String object located at same memory location.
	 */
	void stringEquals() {
		String s1 = "John";
		String s2 = "John"; // point to same memory as s1
		String s3 = "Wang";
		String s4 = "WANG";

		String s6 = new String("John"); // point to different memory from s1

		System.out.printf("s1=%s; s2=%s; s3=%s; s4=%s; s6=new String(\"John\")\n", s1, s2, s3, s4);

		System.out.println("Call s1==s2: " + (s1 == s2)); // address comparison
		System.out.println("Call s1.equals(s2): " + s1.equals(s2));

		s2 = s6;
		System.out.println("assign s2=s6, Call s1==s2: " + (s1 == s2));
		System.out.println("Call s1.equals(s2): " + s1.equals(s2));

		System.out.println("Call s1==s3: " + (s1 == s3)); // address comparison
		System.out.println("Call s1.equals(s3): " + s1.equals(s3));

		System.out.println("Call s1==s6: " + (s1 == s6));
		System.out.println("Call s1.equals(s6): " + s1.equals(s6));

		System.out.println("Call s3.equalsIgnoreCase(s4): " + s3.equalsIgnoreCase(s4));

		System.out.println("Call s1.equals(s3): " + s1.equals(s3));

		Scanner console = new Scanner(System.in);
		System.out.print("inter your name: ");
		String s5 = console.next();
		System.out.println(s5 == s1); // address comparison
		System.out.println(s5.equals(s1)); // content comparison
		console.close();
	}

	void stringLength() {
		System.out.println(String.format("the length of the text %s is %d.", s1, s1.length()));
	}

	void letterAtIndex(String s, int index) {
		System.out.println(s);
		System.out.println(s.charAt(index));
		int i = 23421;
		String s1 = "" + i;
		System.out.println(s1.charAt(s1.length() - 2));
	}

	void upperLowerCase() {
		System.out.println(s2.toUpperCase());
		System.out.println(s2.toLowerCase());
	}

	void findIndex() {
		int i = s2.indexOf('t');
		System.out.println(i);
		i = s2.indexOf("world");
		System.out.println(i);
		i = s2.indexOf("hey");
		System.out.println(i);
	}

	void concatenation() {
		String s = s1 + s2;
		System.out.println(s);
		s = s2.concat(s1);
		System.out.println(s);
		String x = "10";
		int y = 20;
		System.out.println(x + y);
	}

	void escapeSquence() {
		/*
		 * \n; New Line \r; Carriage Return \t; tab \b; Backspace \f; form feed
		 */
		String txt = "We are the so-called \"Vikings\" from the north.";
		System.out.println(txt);
		txt = "We are the so-called \n\"Vikings\" from the north.";
		System.out.println(txt);
		txt = "We are the so-called \t\"Vikings\" \tfrom the north.";
		System.out.println(txt);
		txt = "The student\'s name is Bryan.";
		System.out.println(txt);
		txt = "The character \\ is called backslash.";
		System.out.println(txt);
	}

	/*
	 * Objects of String are immutable, and objects of StringBuffer and
	 * StringBuilder are mutable. StringBuffer and StringBuilder are similar, but
	 * StringBuilder is faster and preferred over StringBuffer for single threaded
	 * program. If thread safety is needed, then StringBuffer is used.
	 */
	void stringBuffer() {
		StringBuffer sb = new StringBuffer("Geeks");
		sb.append("forgeeks");
		System.out.println(sb);
	}

	void stringBuilder() {
		StringBuilder s = new StringBuilder("Geeks");
		s.append("forgeeks");
		System.out.println(s);
	}

	void stringBuilder2stringBuffer() {
		StringBuilder sb = new StringBuilder("Geeks");
		String str = sb.toString();
		StringBuffer sbr = new StringBuffer(str);
		System.out.println(sbr);
	}
}
