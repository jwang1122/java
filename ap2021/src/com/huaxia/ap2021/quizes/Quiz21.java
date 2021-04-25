package com.huaxia.ap2021.quizes;

public class Quiz21 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("Question1... (B) I only");
		double x = 14.7;
//		int y = x; // I
		
		int y = (int)x; // II
		
		int x1 = 14;
		double y1 = x1; // III
		System.out.printf("x=%.1f, y=%d\n", x, y);
	}

	private static void question2() {
		System.out.println("Question2... (E)");
		System.out.print("\\*This is not\na comment*\\") ; 
		
	}

	private static void question3() {
		System.out.println("Question3... (E)");
		double answerA = (double) 13 / 5;
		System.out.println(answerA);
		double answerB = 13 / (double) 5;
		System.out.println(answerB);
		double answerC = 13.0/ 5;
		System.out.println(answerC);
		double answerD = 13 / 5.0;
		System.out.println(answerD);
		double answer = (double)(13/ 5); 
		System.out.println(" 13 / 5= " + answer); 
	}

	private static void question4() {
		System.out.println("Question4... (E)");
		int result = 13 - 3 * 6 / 4 % 3; 
		System.out.println(result);
	}

	private static void question5() {
		System.out.println("Question5... (C)");
		int x = (2 + 3) * 12 / (7 - 4 + 8);
		System.out.println(x);
	}

}
