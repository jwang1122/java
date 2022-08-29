package builtins;

import java.util.Collections;
import java.util.Vector;

public class MyVector {

	public static void main(String[] args) {
		Vector<String> v1 = new Vector<>();
		v1.add("John");
		v1.add("Charles");
		v1.add("David");
		v1.add("Bob");
		System.out.println(v1);
		Collections.sort(v1);
		System.out.println(v1);
		
		Vector<Double> v2 = new Vector<>();
		v2.add(3.44);
		v2.add(13.84);
		v2.add(34.23);
		v2.add(56.74);
		v2.add(123.9);
		System.out.println(v2);
		double avg = v2.stream().mapToDouble(d->d).average().getAsDouble();
		System.out.println(avg);
	}

}
