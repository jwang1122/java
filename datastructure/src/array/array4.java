package array;

import java.util.Arrays;
import java.util.List;

public class array4 {

	public static void main(String[] args) {
		List<Integer> marks = Arrays.asList( 56, 78, 88, 76, 56, 89);
		int sum = marks.stream().reduce(0, Integer::sum);
		System.out.println(((double)sum) / marks.size());
	}

}
