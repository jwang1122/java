package com.huaxia.apcomputer.exam1;

/**
 * Question 1.
 * 
 * @author John
 *
 */
public class TextBook extends Book {
	private String textBookTitle;
	
	public int computeShelfLife() {
		int life = 0;
		System.out.println("computerShelfLife()...");
		System.out.println("Different implementation from Super class Book.");
		textBookTitle = "";
//		textBookTitle = myTitle; // cannot access private attributes from super class
//		readFile(); // cannot access private method from super class
		System.out.println(textBookTitle);
		return life;
	}
	
	public static void main(String[] args) {
		TextBook book = new TextBook();
		Book book1 = (Book)book;
		System.out.println(book1);
	}

}
