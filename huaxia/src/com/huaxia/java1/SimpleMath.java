package com.huaxia.java1;

public class SimpleMath {
	public static double circleArea(double radius) throws InvalidInputDataException{ // this method only depends on the argument radius
		if(radius<0) {
			throw new InvalidInputDataException("Radius of a circle cannot be negative.");
		}
		return Math.PI * Math.pow(radius, 2);
	}

	public static double add(double x, double y) {
		return x + y;
	}

	// overloading add method above with different method signature.
	public static int add(int x, int y) {
		return x+y;
	}

	public static double sub(double x, double y) {
		return x - y;
	}

	public static double mul(double x, double y) {
		return x * y;
	}

	public static double div(double x, double y) throws Exception{
		if(y==0) {
			throw new Exception("Cannot divided by 0.");
		}
		return x / y;
	}

	public static double abs(double x) {
		return Math.abs(x);
	}

}
