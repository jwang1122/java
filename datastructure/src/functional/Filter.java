package functional;

import java.util.List;
import java.util.function.Predicate;

public class Filter {

	public static void main(String[] args) {
		Predicate<Long> isEven = (value) -> value % 2L == 0;
		
		List.of(1L, 2L, 3L, 5L, 8L, 13L)
		.stream()
		.filter(isEven)
		.forEach(System.out::println);
		
		List.of(1L, 2L, 3L, 5L, 8L, 13L)
	    .stream()
	    .filter(Predicate.not(value -> value % 2L == 0))
	    .forEach(System.out::println);
	}

}
