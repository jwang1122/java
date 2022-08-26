package lambda;

import java.util.ArrayList;

public class Lambda2 {
	static double sum = 0;
	public static void main(String[] args) {
	    ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(5);
	    numbers.add(9);
	    numbers.add(8);
	    numbers.add(1);
	    numbers.forEach( (n) -> { System.out.println(n); } );
	    numbers.forEach(n->add(n)); // lambda expression
	    System.out.printf("the average is %.2f.",sum/4.0);
	}

	static void add(Integer i) {
		sum += i;
	}
}
