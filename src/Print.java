package com.huaxia.java1;

/**
 * This is my Print class to show all of the print functions
 * 
 * @author John
 *
 */
public class Print {

	/**
	 * 
	 * @param args is the argument come from the command line
	 */
	public static void main(String[] args) {
		System.out.println("Hello, the World!");
		//calculate area of a rectangle. %d is a placeholder, hold an integer
		int width=4;
		int length=6;
		int rectableArea = width * length;
		System.out.println("The area of rectangle is "+rectableArea);
		System.out.println("The area of rectangle " + "with width=14 and length=6 is " + rectableArea +".");
		// \n: new line, which is a escape sequence
		System.out.printf("The area of rectangle with width=%d and length=%d is %d.\n", width, length, rectableArea);
		String format = "The area of rectangle with width=%d and length=%d is %d.\n";
		System.out.printf(format, width, length, rectableArea);
		//calculate sum over two numbers x and y
		int x = 15;
		int y = 9;
		System.out.printf("%d + %d = %d\n",x,y,(x+y));
		int large = Math.max(x, y);
		System.out.println("Greater number: " + large);
		String sf1 = String.format("%d + %d = %d", x,y,(x+y));
		System.out.println(sf1);
		
		//calculate cirle area
		double radius = 3.1;
//		float pi = 3.1415926F;
		double circle_area = radius*radius*Math.PI;
		String sf2 = String.format("The circle area with radius=%.2f is %.3f.", radius,circle_area);
		System.out.println(sf2);
		
		String firstName = "John";
		String lastName = "Wang";
		String sf3 = "My name is %s %s.\n";
		System.out.printf(sf3, firstName, lastName);
//		variable name cannot start with number
//		int 1a = 4;
//		variable can only start with letter combined with letter and number a-z, A-Z, 0-9, no special characters
//		int _a = 5;
		//		int AaaBsw12GG223@#$%| = 5;
		// cannot use reserved java key words and existing class name for variable name.
//		int System = 9;
		int a=0, b=0, c = 0;
		System.out.println(a+b+c);
	}

}
