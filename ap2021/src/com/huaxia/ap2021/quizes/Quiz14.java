package com.huaxia.ap2021.quizes;

public class Quiz14 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("question 1...");
		System.out.println("(D) Instance variable should be private.");

	}

	private static void question2() {
		System.out.println("question 2...");
		System.out.println("(C) II and III are correct design.");

	}

	private static void question3() {
		System.out.println("question 3...");
		Sample s = new Sample();
		String tmp = new String("hi");
		s.writeMe(tmp);
	}

	private static void question4() {
		System.out.println("question 4...");
		Sample s = new Sample();
		Object tmp = new Object() ; 
		s.writeMe(tmp) ;
	}

	private static void question5() {
		System.out.println("question 5...");
		Sample s = new Sample();
		Object tmp = new String("hi") ; 
		s.writeMe(tmp) ;
	}

}

class Sample {
	public void writeMe(Object obj) {
		System.out.println("object");
	}

	public void writeMe(String s) {
		System.out.println("string");
	}
}
