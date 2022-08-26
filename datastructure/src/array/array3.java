package array;

import java.util.Arrays;
import java.util.List;

public class array3 {

	public static void main(String[] args) {
// build new data set as List
//		List<Integer> marks = Arrays.asList(56, 78, 88, 76, 56, 89);
// for existing array1
		Integer array1[] = {56, 78, 88, 76, 56, 89}; 
// use asList()
		List<Integer> marks = Arrays.asList(array1);
// use addAll()
//		ArrayList<Integer> marks = new ArrayList<>();
//		Collections.addAll(marks, array1);
		int sum = marks.stream().reduce(0, (subtotal, element) -> subtotal + element);
		System.out.println(((double)sum) / marks.size());
	}

}
