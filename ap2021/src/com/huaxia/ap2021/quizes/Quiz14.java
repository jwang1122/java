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
		// TODO Auto-generated method stub

	}

	private static void question2() {
		// TODO Auto-generated method stub

	}

	private static void question3() {
		Sample s = new Sample();
		String tmp = new String("hi");
		s.writeMe(tmp);
	}

	private static void question4() {
		Sample s = new Sample();
		Object tmp = new Object() ; 
		s.writeMe(tmp) ;
	}

	private static void question5() {
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
