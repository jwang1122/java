package com.huaxia.java2.functional;
/*
 * Use lambda function define interface method.
 * the interface must have only one abstract method.
 */
public class UseMyInterface {

	public static void main(String[] args) {
		MyInterface mi = () -> {System.out.println("Executing...");};
		mi.run();
	}

}
