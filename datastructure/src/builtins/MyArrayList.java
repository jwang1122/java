package builtins;

import java.util.ArrayList;

public class MyArrayList {

	public static void main(String[] args) {
	    ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(5);
	    numbers.add(9);
	    numbers.add(8);
	    numbers.add(1);
	    System.out.println(numbers);
	    System.out.println(numbers.stream().mapToDouble(a->(double)a).average());
	}

}
