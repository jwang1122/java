package com.huaxia.test;

public class StringTest {
	static String s1 = "1234567890";
	static String s2 = "Hello the world!";
	
	public static void main(String[] args) {
		StringTest test = new StringTest();
//		test.stringLength();
		test.letterAtIndex("This is a test.");
//		test.upperLowerCase();
//		test.findIndex();
//		test.concatenation();
//		test.escapeSquence();
//		test.stringBuilder();
//		test.stringBuilder2stringBuffer();
	}
	
	void stringLength() {
		System.out.println(String.format("the length of the text %s is %d.", s1, s1.length()));
	}
	
	void letterAtIndex(String s) {
		System.out.println(s);
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
		System.out.println(x+y);
	}
	
	void escapeSquence() {
		/*
		 * \n; New Line
		 * \r; Carriage Return
		 * \t; tab
		 * \b; Backspace
		 * \f; form feed
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
	 * Objects of String are immutable, 
	 * and objects of StringBuffer and StringBuilder are mutable. 
	 * StringBuffer and StringBuilder are similar, 
	 * but StringBuilder is faster and preferred over StringBuffer for single threaded program. 
	 * If thread safety is needed, then StringBuffer is used.
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
