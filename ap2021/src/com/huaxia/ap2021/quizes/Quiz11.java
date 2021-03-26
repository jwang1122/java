package com.huaxia.ap2021.quizes;

public class Quiz11 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("question 1...");
		System.out.print("Ilove Java");
		System.out.print("Ilove" + "Java");
//		System.out.print(1 + "love" + Java"); // (C)
		System.out.print(1 + "love" + "Java");
		System.out.print("I love" + " " + "Java");
		System.out.println();
	}

	private static void question2() {
		System.out.println("question 2...");
	    int a =10 ;
	    double b = 10.7; 
	    double c = a + b;
//	    int d =a + c; // compiler error
	    double d =a + c;
	    System.out.println(c + " " + d);  
	}

	private static void question3() {
		System.out.println("question 3...");
	    int a = 3; 
	    int b = 6; 
	    int c = 8; 
	    int d = a/b; 
//	    c /= d; // divid by zero at runtime
	    System.out.print(c);	
	    System.out.println();
	}

	private static void question4() {
		System.out.println("question 4...");
		for (int i = 200 ; i > 0; i /= 3) {
			if (i % 2 == 0 ) 
				System.out.print(i +" ");
		}
	    System.out.println();		
	}

	private static void question5() {
		System.out.println("question 5...");
		int x = 10;
		int y = 5;

		if (x == 10)
			if (y <= 5)
				y++;
			else if (y < 4)
				x = 3;
			else
				y += 6;
		if (y > 5)
		{
			if (x != 10) {
				x = 0;
				y = 0;
			} else
				x = -5;
		}
		System.out.printf("x=%d, y=%d\n", x, y);
		
	}

}
