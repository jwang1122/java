package functional;

import java.util.function.Function;

public class Lambda02 {

	public static void main(String[] args) {
		Function<Double, Double> f = (x) -> Math.pow(x, 3);
		System.out.println(f.apply(3.0));
	}

}
