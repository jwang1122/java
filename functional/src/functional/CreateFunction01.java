package functional;

import java.util.function.Function;

public class CreateFunction01 {
	public static void main(String[] args) {
		double x = 1;
		Function<Double, Double> f = new Quadratic(2,-3,4);
		System.out.printf("f(%s) = %s\n",x,f.apply(x));
	}

}

class Quadratic implements Function<Double, Double>{
	double a, b, c;
	public Quadratic(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public Double apply(Double x) {
		return a * x * x + b * x + c;
	}
}