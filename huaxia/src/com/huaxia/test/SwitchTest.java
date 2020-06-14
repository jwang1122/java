package com.huaxia.test;

/**
 * switch(expression) { 
 * 		case x: 
 * 		// code block 
 * 			break; 
 * 		case y: 
 * 		// code block
 * 			break; 
 * 		default: 
 * 			// code block 
 * }
 */
public class SwitchTest {
	static String[] weekdays = { "No such day", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
			"Sunday" };

	public static void main(String[] args) {
		SwitchTest test = new SwitchTest();
		int day = 3;
		// test.weekdayConverter(day);
		// System.out.println(test.day2Word(day));
		System.out.println(test.number2Week(day));
	}

	void weekdayConverter(int day) {
		switch (day) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		default:
			System.out.println("No such day.");
		}
	}

	String day2Word(int day) {
		String result = "No Such Day";
		switch (day) {
		case 1:
			result = "Monday";
			break;
		case 2:
			result = "Tuesday";
			break;
		case 3:
			result = "Wednesday";
			break;
		case 4:
			result = "Thursday";
			break;
		case 5:
			result = "Friday";
			break;
		case 6:
			result = "Saturday";
			break;
		case 7:
			result = "Sunday";
			break;
		}
		return result;

	}

	// make code change, allow invalid numbers (day < 1 or day >7)
	String number2Week(int day) {
		return weekdays[day];
	}
}
