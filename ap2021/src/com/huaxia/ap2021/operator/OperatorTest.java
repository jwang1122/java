package com.huaxia.ap2021.operator;

public class OperatorTest {
	public static void main(String[] args) {
//		reminderTest();
		logicTest();
	}
	
	static void logicTest() {
		getLogic(true, true);
		getLogic(true, false);
		getLogic(false, true);
		getLogic(false, false);
	}
	
	static void getLogic(boolean p, boolean q) {
		boolean flag = (!p && !q) || !(p || q);
		System.out.println(flag);
	}
	
	static void reminderTest() {
		getReminder(0, 50);
		getReminder(10, 50);
		getReminder(25, 50);
		getReminder(40, 50);
		getReminder(50, 50);		
	}
	static void getReminder(int i, int x) {
		System.out.println(i % x);		
	}
}
