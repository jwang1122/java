package com.huaxia.java1.homework;

public class ClassHW1 {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		System.out.printf("The circle area with radius=%.2f is %.2f.\n",c1.getRadius(),c1.getArea());
		c1 = new Circle(2.0);
		System.out.printf("The circle area with radius=%.2f is %.2f.\n",c1.getRadius(),c1.getArea());
	}

}

/**
 * The Circle class models a circle with a radius and color.
 */
class Circle {  // Save as "Circle.java"
   // private instance variable, not accessible from outside this class
   private double radius;
   private String color;
   
   // Constructors (overloaded)
   /** Constructs a Circle instance with default value for radius and color */
   public Circle() {  // 1st (default) constructor
      radius = 1.0;
      color = "red";
   }
   
   /** Constructs a Circle instance with the given radius and default color */
   public Circle(double r) {  // 2nd constructor
      radius = r;
      color = "red";
   }
   
   /** Returns the radius */
   public double getRadius() {
     return radius; 
   }
   
   /** Returns the area of this Circle instance */
   public double getArea() {
      return radius*radius*Math.PI;
   }

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public void setRadius(double radius) {
	this.radius = radius;
}
   
}