package functional;

import java.util.List;
import java.util.Set;

public class TackWhile {

	public static void main(String[] args) {
		List.of(1L, 5L, 7L, 10L, 11L, 12L)
	    .stream()
	    .takeWhile(value -> value % 2 != 0)
	    .forEach(System.out::println);
		System.out.println();
		
		List.of(1L, 5L, 7L, 10L, 11L, 12L)
	    .stream()
	    .dropWhile(value -> value % 2 != 0)
	    .forEach(System.out::println);
		System.out.println();
		
		Set.of(1L, 5L, 7L, 10L, 11L, 12L) // set makes the elements not ordered
	    .stream()
	    .dropWhile(value -> value % 2 != 0)
	    .forEach(System.out::println);
	}

}
