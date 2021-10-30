package com.huaxia.john;

import java.util.Arrays;

/**
 * this sample code show you the Parameter and Argument.
 * 
 * @author John
 *
 */
public class Example1 {

	public static int multiplay(int a, int b) { // a and b are parameters
		return a * b;
	}
	
	public static int multiplay(double a, int b) { // method overloading:
		return (int)(a * b);
	}
	
	public static void sayHello(String name) {
		System.out.println("Hello, " + name);
	}
	
	public static void main(String[] params) { // method or function definition
		if(params.length>0) {
			System.out.println(Arrays.toString(params));
		}
		int x = Integer.valueOf(params[0]);
		int y = Integer.valueOf(params[1]);
		double z = multiplay(x, y); // x and y are arguments
		System.out.printf("%s x %s = %f\n",x,y,z);
		
		double d = 1.23;
		z = multiplay(d,y);
		sayHello("John");
	}

}
