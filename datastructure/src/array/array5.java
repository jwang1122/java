package array;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class array5 {
	public static void main(String[] args) {
		List<Integer> marks = Arrays.asList(56, 78, 88, 76, 56, 89);
		OptionalDouble avg = marks.stream().mapToDouble(a -> ((double) a)).average();
		System.out.println(avg.getAsDouble());
	}
}
