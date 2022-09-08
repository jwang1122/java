package oop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Point {
	String label;
	double x;
	double y;

	public Point(double x, double y, String label) {
		this.x = x;
		this.y = y;
		this.label = label;
	}

	@Override
	public String toString() {
		return String.format("%s(%.2f, %.2f)", label, x, y);
	}
	
	/**
	 * Translate this point by useing p as new origin
	 * @param p: new origin.
	 */
	public void translate(Point p) {
		x -= p.x;
		y -= p.y;
	}
	
	public static Point negate(Point p) {
		return new Point(-p.x, -p.y, p.label);
	}
	
	public void rotate(double degree) {
		double radian = degreeToRadian(degree);
		double sinTheta =Math.sin(radian);
		double cosTheta = Math.cos(radian);
		double xTmp = x*cosTheta - y*sinTheta;
		y = x*sinTheta + y*cosTheta;
		x = xTmp;
		if(!label.endsWith("'"))
			label = label+"'";		
	}

	public void rotate(double angle, Point turningPoint) {
		translate(turningPoint);
		rotate(angle); // rotate about the origin
		translate(negate(turningPoint));
	}


	public static double degreeToRadian(double degree) {
		return Math.PI / 180 * degree;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Point)) {
			return false;
		}
		Point other = (Point)obj;
		BigDecimal bdx = new BigDecimal(x).setScale(3, RoundingMode.HALF_UP);
		BigDecimal bdy = new BigDecimal(y).setScale(3, RoundingMode.HALF_UP);
		BigDecimal otherX = new BigDecimal(other.x).setScale(3, RoundingMode.HALF_UP);
		BigDecimal otherY = new BigDecimal(other.y).setScale(3, RoundingMode.HALF_UP);
		return bdx.equals(otherX) && bdy.equals(otherY);
	}
}