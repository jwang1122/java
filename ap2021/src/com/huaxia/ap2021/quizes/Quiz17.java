package com.huaxia.ap2021.quizes;

import java.util.ArrayList;
import java.util.List;

public class Quiz17 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("question 1...");
		int max = 12;
		int[] a = { 12, 22, 4 };
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] == max || !(max != a[i]));
			System.out.print("\t");
			System.out.println(a[i] == max);
		}

	}

	private static void question2() {
		System.out.println("question 2...");
		ArrayList<Clown> list = new ArrayList<>();
//		for (int i = 0; i <= list.size(); i++) //(A)
//	        list.set(i, new Clown());
		list.add(list.size(), new Clown()); // (B)
//		Clown c = list.get (list.size());     //(C)
//		Clown c = list.remove(list.size());   //(D)
//		list.add(-1, new Clown());            //(E)
		System.out.println(list.size());
	}

	private static void question3() {
		System.out.println("question 3...");
		System.out.println("abstract class can have virtul methods which are not implemented.");

	}

	private static void question4() {
		System.out.println("question 4...");
		Point topLeft = new Point(0, 2);
		Point botRight = new Point(3, 0);
		Rectangle r = new Rectangle("my rectangle", topLeft, botRight);
		System.out.printf("area=%d.\n", r.area());
	}

	private static void question5() {
		System.out.println("question 5...");
		List<Quadrilateral> list = new ArrayList<Quadrilateral>();
		Point topLeft = new Point(0, 2);
		Point botRight = new Point(3, 0);
		Rectangle r = new Rectangle("my rectangle", topLeft, botRight);
		list.add(r);
		topLeft = new Point(4, 6);
		botRight = new Point(7, 9);
		r = new Rectangle("my rectangle", topLeft, botRight);
		list.add(r);
		writeAreas(list);
	}

	/* precondition: quadList contains Rectangle, Parallelogram, or
	 *Square objects in an unspecified order. 
	 */
	public static void writeAreas(List<Quadrilateral> quadList)  
	{
	    for (Quadrilateral quad : quadList) 
	        System.out.println ("Area of " + quad.getLabels() + " is "+ quad.area()); 
	}
}

class Point {
	private int xCoord;
	private int yCoord;

	// constructor
	public Point(int x, int y) {
		this.xCoord = x;
		this.yCoord = y;
	}

	// accessors
	public int get_x() {
		return xCoord;
	}

	public int get_y() {
		return yCoord;
	}

	// other methods not shown ...
}

abstract class Quadrilateral {
	private String myLabels; // e.g.> "ABCD"

	// constructor
	public Quadrilateral(String labels) {
		myLabels = labels;
	}

	public String getLabels() {
		return myLabels;
	}

	public abstract int perimeter();

	public abstract int area();
}

class Rectangle extends Quadrilateral {
	private Point myTopLeft; // coords of top left corner
	private Point myBotRight; // coords of bottom right corner

	// constructor
	public Rectangle(String labels, Point topLeft, Point botRight) {
		/* implementation code */
		super(labels);
		myTopLeft = topLeft;
		myBotRight = botRight;
	}

	public int perimeter() {
		/* implementation not shown */
		return 2 * (getWidth() + getHeight());
	}

	public int area() {
		/* implementation not shown */
		return getWidth() * getHeight();
	}

	// other methods not shown ...
	public int getWidth() {
		return Math.abs(myBotRight.get_x() - myTopLeft.get_x());
	}

	public int getHeight() {
		return Math.abs(myBotRight.get_y() - myTopLeft.get_y());
	}
}

class parallelogram extends Quadrilateral {
	// private instance variables and constructor not shown

	public parallelogram(String labels) {
		super(labels);
		// TODO Auto-generated constructor stub
	}

	public int perimeter() {
		/* implementation not shown*/ 
		return 0;
	}

	public int area() {
		/* implementation not shown */ 
		return 0;
	}
}

class Square extends Rectangle {
	public Square(String labels, Point topLeft, Point botRight) {
		super(labels, topLeft, botRight);
		// TODO Auto-generated constructor stub
	}

	// private instance variables and constructor not show

	public int perimeter() { /* implementation not shown*/
		return super.perimeter();
	}

	public int area() { /* implementation not shown */
		return super.area();
	}
}

class Clown {

}