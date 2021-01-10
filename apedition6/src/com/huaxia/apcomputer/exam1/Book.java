package com.huaxia.apcomputer.exam1;

/**
 * Question 1.
 * 
 * @author John
 *
 */
public class Book {
	private String myTitle;
	private String myAuthor;

	Book() { // default constructor

	}

//	Book(String title, String author){
//		this.myAuthor = author;
//		this.myTitle = title;
//	}

	public int computeShelfLife() {
		int life = 0;
		System.out.println("computerShelfLife()...");
		return life;
	}

	private void readFile() {
		System.out.println("Read file aloud..");
	}

	public static void main(String[] args) {
		Book test = new Book();
		test.readFile();
	}

	public String getMyTitle() {
		return myTitle;
	}

	public void setMyTitle(String myTitle) {
		this.myTitle = myTitle;
	}

	public String getMyAuthor() {
		return myAuthor;
	}

	public void setMyAuthor(String myAuthor) {
		this.myAuthor = myAuthor;
	}

}
