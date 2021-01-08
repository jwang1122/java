package com.huaxia.apcomputer.exam1;

/**
 * Question 1.
 * 
 * @author John
 *
 */
public class Novel extends Book {
	String novelTitle;
	
	public int computeShelfLife() {
		int life = 0;
		System.out.println("computerShelfLife()...");
		return life;
//		readFile(); cannot access private method from super class
	}

}
