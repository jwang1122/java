package com.huaxia.ap2021.quizes;

public class Quiz23 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("Question 1...");
//		Date d = new (2, 13, 1947);     // (A) compiling error
		Date d = new Date(2,13, 1947);  // (B) correct
//		Date d;							// (C) compiling error
//	    d = new (2, 13, 1947);
//		Date d;							// (D) compiling error
//	    d = Date (2, 13, 1947); 
//		Date d = Date(2, 13, 1947);		// (E) compiling error
		System.out.println(d);
	}

	private static void question2() {
		System.out.println("Question 2...");
		Date d1 = new Date(2,13, 1947);
		Date d2 = d1;
		d1 = null;
		d2 = d1;
		Date d = null;
//		int x = d.year();    //(C) runtime error
	}

	private static void question3() {
		System.out.println("Question 3...");
		Date d = new Date(1, 13,2002);
		String s = d.toString();
		int x = d.day();
		Date e = d;
		Date c = new Date(1, 13, 2002);
//		int y = d.myYear;  //compiler error
		System.out.println("(E) will cause compiler error du to private variable.");
	}

	private static void question4() {
		System.out.println("Question 4...");
		Date d = new Date(1, 13,2002);
		d.write();
	}

	private static void question5() {
		System.out.println("Question 5...");
		int month = 1;
		int day = 2;
		int year = 2021;
		Date d1 = new Date (month, day, year);
		Date d2 = d1;
		Date d3 = new Date (month, day , year);
		Date d4 = new Date(d1.month() , d1.day(), d1.year());
	}

}

class Date 
{
	private int myDay;
	private int myMonth;
	private int myYear;

	public Date() // default constructor
	{

	}

	public Date(int mo, int day, int yr) // constructor
	{
		this.myMonth = mo;
		this.myDay = day;
		this.myYear = yr;
	}

	public int month() // returns month of Date
	{
		return myMonth;
	}

	public int day() // returns day of Date
	{
		return myDay;
	}

	public int year() // returns year of Date
	{
		return myYear;
	}

//Returns String representation of Date as "m/d/y" , e.g. 4/18/1985 
	public String toString() {
		return myMonth + "/" + myDay + "/" + myYear;
	}

	public void write () 
	{
		System.out .println(myMonth + "/" + myDay + "/"+ myYear);
		System.out.println (month () + "/"  + day()+ "/" + year());
		System.out.println(this);  
	}

}