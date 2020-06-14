package com.huaxia.test;

public class IfElseTest {
	static String[] weekdays = {"No such day","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

	public static void main(String[] args) {
		IfElseTest test = new IfElseTest();
//		test.ifElse();
//		test.ifElseIf();
//		test.ternary();
		System.out.println(test.number2Week(0));
	}

	void ifElse() {
		int time = 20;
		if (time < 18) {
		  System.out.println("Good day.");
		} else {
		  System.out.println("Good evening.");
		}	
	}
	
	void ifElseIf() {
		int time = 22;
		if (time < 10) {
		  System.out.println("Good morning.");
		} else if (time < 20) {
		  System.out.println("Good day.");
		} else {
		  System.out.println("Good evening.");
		}		
	}
	
	void ternary() {
		int time = 20;
		String result = (time < 18) ? "Good day." : "Good evening.";
		System.out.println(result);		
	}
	
	// make code change, allow invalid numbers (day < 1 or day >7)
	String number2Week(int day) {
		return weekdays[day];
	}

}
