package com.huaxia.java1.homework;

public class ClassHW2 {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		System.out.println(r1);
		r1 = new Rectangle(2,3);
		System.out.println(r1);
		System.out.printf("The perimeter of %s is %.3f.\n",r1, r1.getPerimeter());
		System.out.printf("The area of %s is %.3f.\n",r1,r1.getArea());

	}

}

class Rectangle{
	private double length = 1.0;
	private double width = 1.0;
	
	public Rectangle()
	{
		
	}
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double getPerimeter() {
		return 2*(length + width);
	}
	
	public double getArea() {
		return length * width;
	}
	
	public String toString() {
		return String.format("Rectangle[%.3f, %.3f]", width, length);
	}
}