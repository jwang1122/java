package com.huaxia.java1;

public class ExecutionControl {

	static void ifelseTest() {
		int hour = 22;
		if(hour<12) {
			System.out.println("Good morning.");
		}else if(hour>=12 && hour<=18) {
			System.out.println("Good afternoon.");
		}else {
			System.out.println("Good evening.");
		}
		
	}
	
	static String getWeekDay(int day) {
		switch(day) {
		case 1: return "Monday";
		case 2: return "Tuseday";
		case 3: return "Wednesday";
		case 4: return "Thursday";
		case 5: return "Friday";
		case 6: return "Saturday";
		case 7: return "Sunday";
		default:
			return "No such day.";
		}
		
	}
	
	static int doMath(String op, int x, int y) {
		switch(op) {
		case "add": return x + y;
		case "sub": return x - y;
		case "mul": return x * y;
		case "div": return x/y;
		default: return 0;
		}
	}
	
	public static void main(String[] args) {
		// ifelseTest();
//		int day = 6;
//		System.out.println(getWeekDay(day));
		
		String op = "mul";
		System.out.println(doMath(op, 6, 7));
	}

}
