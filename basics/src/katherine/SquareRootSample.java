package katherine;

public class SquareRootSample {

	public static double part(double a, double b) {
		return a * Math.sqrt(b);
	}
	
	/**
	 * rotate p by angle around origin (0,0)
	 * 
	 * 
	 * x = ˆx cos θ − yˆsin θ and y = ˆx sin θ + ˆy cos θ
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
	 * x' = x + dx
	 * y' = y + dx
	 * 
	 * @param p
	 * @param angle
	 * @param turningPoint
	 * @return
	 */
	public static Point rotate(Point p, double angle, Point turningPoint) {
		Point o = new Point(p.x - turningPoint.x, p.y - turningPoint.y, p.label); // move the turning point to origin
		o= rotate(o, angle); // rotate about the origin
		o = new Point(o.x + turningPoint.x, o.y + turningPoint.y, o.label); // transfer back
		return o;
	}
	
	public static void math01() {
		double x = -9*Math.sqrt(27.0) + 6*Math.sqrt(45);
		System.out.printf("-9*Math.sqrt(27.0)+6*Math.sqrt(45)=%s.\n",x); // where \n means new line
		x = part(-9, 27) + part(6, 45);
		System.out.println(x);
		x = part(9, 217) * part(16, 445) / part(4,23);
		System.out.println(x);		
	}
	
	public static void main(String[] args) {
//		math01();
//		double theta = Math.PI/6;
//		System.out.println(Math.sin(theta));
//		System.out.println(Math.cos(theta));
		Point p = new Point(0, 1, "A");
		double angleInDegree = 45; 
		Point p1 = rotate(p, angleInDegree);
		System.out.printf("%s point rotate %s degree to %s.\n",p, angleInDegree, p1);
		Point a = new Point(-1, 1, "A");
		Point o = new Point(1, -1, "O_");
		angleInDegree = 90;
		o = rotate(a, angleInDegree, o);
		System.out.println(o);
	}

}

class Point{
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
	
	
}
