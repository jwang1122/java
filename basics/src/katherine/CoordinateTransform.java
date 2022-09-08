package katherine;

import java.util.Arrays;

public class CoordinateTransform {
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public static Point translate(Point p1, Point p2) {
		String label = p1.label;
		if(!label.endsWith("'")) {
			label += "'";
		}
		return new Point(p1.x - p2.x, p1.y - p2.y, label);
	}

	/**
	 * rotate p by angle around origin (0,0)
	 * 
	 * 
	 * x' = x cos θ − y sin θ and y' = x sin θ + y cos θ
	 * 
	 * 
	 * @param p is point to be rotated
	 * @param angle 
	 * @return a new point
	 */
	public static Point rotate(Point p, double angle) {
		double theta = Math.PI/180*angle;
		double sinTheta =Math.sin(theta);
		double cosTheta = Math.cos(theta);
		return new Point(p.x*cosTheta - p.y*sinTheta, p.x*sinTheta + p.y*cosTheta, p.label+"'");
	}
	
	/**
	 * x' = x - dx
	 * y' = y - dx
	 * 
	 * @param p
	 * @param angle
	 * @param turningPoint
	 * @return
	 */
	public static Point rotate(Point p, double angle, Point turningPoint) {
		Point o = translate(p, turningPoint);
		o= rotate(o, angle); // rotate about the origin
		return translate(o, negate(turningPoint));
	}

	public static Point negate(Point p) {
		return new Point(-p.x, -p.y, p.label);
	}
	
	public static void transformTest() {
		Point p1 = new Point(2,2,"p");
		Point newOrigin = new Point(1,1,"o");
		Point p = translate(p1, newOrigin);
		System.out.println(p);		
	}
	
	public static void rotateOriginTest() {
		Point p = new Point(0, 1, "A");
		double angleInDegree = 45; 
		Point p1 = rotate(p, angleInDegree);
		System.out.printf("%s point rotate %s degree to %s.\n",p, angleInDegree, p1);	
	}
	
	public static void rotateGeneralTest() {
		Point a = new Point(2, 2, "A");
		Point o = new Point(1, 1, "O'");
		double angleInDegree = 90;
		o = rotate(a, angleInDegree, o);
		System.out.println(o);
		
	}
	
	public static Point[] rotate3(Point[] points, double angle, Point origin) {
		Point[] newPoints = new Point[points.length];
		for(int i=0; i<points.length; i++) {
			newPoints[i] = rotate(points[i], angle, origin);
		}
		return newPoints;
	}
	
	public static void rotatePointArrayTest() {
		Point[] points = new Point[3];
		points[0] = new Point(-3,2,"A");
		points[1] = new Point(5,3,"B");
		points[2] = new Point(2, -5, "C");
		Point origin = new Point(2, -1, "O");
		Point[] newPoints = rotate3(points, 90, origin);
		System.out.println(Arrays.toString(newPoints));		
	}
	
	public static Point dilation(Point p, double scale) {
		return new Point(p.x * scale, p.y * scale, p.label+"'");
	}
	
	public static Point[] scalePointArray(Point[] points, double scale) {
		Point[] newPoints = new Point[points.length];
		for(int i=0; i<points.length; i++) {
			newPoints[i] = dilation(points[i], scale);
		}
		return newPoints;
	}
	
	public static void rotateAboutPointTest() {
		Point[] points = new Point[4];
		points[0] = new Point(-6,4,"A");
		points[1] = new Point(6,0,"B");
		points[2] = new Point(4, -4, "C");
		points[3] = new Point(-4, -2, "D");
		points = scalePointArray(points, 0.5);
		System.out.println(Arrays.toString(points));
	}
	
	public static void translateTest() {
		Point a = new Point(-5, 6, "A");
		Point delta = new Point(7, 0, "Delta");
		Point a_ = translate(a, negate(delta));
		System.out.println(a_);
	}
	
	public static void main(String[] args) {
//		transformTest();
//		rotateOriginTest();
//		rotateGeneralTest();
//		rotatePointArrayTest();
//		rotateAboutPointTest();
		translateTest();
	}
}
