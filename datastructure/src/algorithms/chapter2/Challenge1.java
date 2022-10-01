package algorithms.chapter2;

public class Challenge1 {

	public static void main(String[] args) {
		double start = 2;
		double step = 1;
		double accuracy = 0.05;
		double root = findRoot(start, step, accuracy);
		System.out.printf("root=%s, expected=%s, found=%s\n", root, 0, f(root));
	}

	private static double findRoot(double start, double step, double accuracy) {
		double f0 = f(start);
		double f1 = f(start + step);
		boolean direction = true;
		while(Math.abs(f1-0)>accuracy) {
//			System.out.printf("start=%s, f(start)=%s, accuracy=%s\n",start+step, f1, Math.abs(f1-0));
			if(f1>0 && direction) {
				step  = -step/10; // adjust step
				direction = !direction; // Opposite direction
			}else if(f1<0 && !direction) {
				step = -step/10;
				direction = !direction;
			}
			start += step; 
			f0 = f(start);
			f1 = f(start+step);
		}
			
		return start+step;
	}

	public static double f(double x) {
		return Math.tan(x);
	}
}
