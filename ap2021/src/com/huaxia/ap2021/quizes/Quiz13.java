package com.huaxia.ap2021.quizes;

public class Quiz13 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("question 1...");
		Number n1 = new Number(1);
		Number n2 = new Number(2);
		int oldValue = n1.changeValue(11);
		System.out.printf("Old value: %d.\n", oldValue);
		System.out.printf("New value: %d.\n",n1.getValue());
	}

	private static void question2() {
		System.out.println("question 2...");
		NumChanger nc = new NumChanger();
		nc.change();
		System.out.println();
	}

	private static void question3() {
		System.out.println("question 3...");
		match("Hello", "Hello");
		match("Hello", "world");
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		match(s1, s2);
	}

	private static void question4() {
		System.out.println("question 4...");
		System.out.println(ComputerMouse.getConnector());
		ComputerMouse.setConnector("new connector");
		System.out.println(ComputerMouse.getConnector());
		ComputerMouse cm = new ComputerMouse();
		cm.setConnector("my my my");
		System.out.println(cm.getConnector());
	}

	private static void question5() {
		System.out.println("question 5...");
		System.out.println("(E) I, II, and III all good design concern.");
	}

	public static void match (String s, String t) 
	{
	    if( s.compareTo(t) ==0)
	        System.out.println ("Strings match."); 
	    else
	        System.out.println("Strings do not match.");
	    if( s==t)
	        System.out.println ("Strings match."); 
	    else
	        System.out.println("Strings do not match.");
	}

}

class ComputerMouse{
	private static String connector = "mouse connector";
	
	public static String getConnector() {
		return connector;
	}
	
	public static void setConnector(String c) {
		connector = c;
	}
}
class Number {
	private int value;

	public Number(int someNum) {
		if (someNum >= 0)
			value = someNum;
	}

	public int changeValue(int newVal) {
		/* missine code */
		int oldValue = this.value;
		this.value = newVal;
		return oldValue;
	}

	public int getValue() {
		return value;
	}
	
}

class NumChanger {
	public void change() {
		Number n1 = new Number(5);
		Number n2 = new Number(5);
		int sum1 = n1.getValue() + n2.getValue();
		int oldn1Val = n1.changeValue(10);
		n2 = n1;
		int sum2 = n1.getValue() + n2.getValue();
		System.out.print(sum1 + " " + sum2);
	}
	// other methods not shown
}
