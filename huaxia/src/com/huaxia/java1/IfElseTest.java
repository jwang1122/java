package com.huaxia.java1;

public class IfElseTest {
	static String[] weekdays = {"No such day","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

	public static void main(String[] args) {
		IfElseTest test = new IfElseTest();
//		test.ifElse(20);
//		test.ifElseIf();
		// write simple loop print out odd number between 0-20
//		test.ternary();
		String weekday = test.number2Week(7);
		System.out.println(weekday);
		System.out.println(isPerfactNumber(6));
		System.out.println(isPerfactNumber(12));
	}

	
	void ifElse(int time) {
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
		int time = 16;
		String result = (time < 18) ? "Good day." : "Good evening.";
		System.out.println(result);		
	}
	
	// make code change, only allow valid numbers (day >= 1 and day <=7)
	String number2Week(int day) {
		return weekdays[day];
	}
	
	static boolean isPerfactNumber(int x) {
		int sum = 0;
		for (int i = 1; i<x; i++) {
			if ( x % i == 0)
				sum += i;
		}
		return sum==x;
	}
	

}
