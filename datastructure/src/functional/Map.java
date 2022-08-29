package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Map {

	public static void main(String[] args) {
		List.of("John", "Charles","David","Bob")
		.stream()
		.map(String::toUpperCase)
		.forEach(System.out::println);
		
		var identifier = List.of(1L, 5L);
		ArrayList<String> list = new ArrayList<>();
		Function<Long, List<String>> mapper = (id) -> {
			String s = "" + id; 
			list.add(s);
			return list;
		};
		
		identifier
			.stream()
			.map(mapper)
//			.flatMap(Collection::stream)
			.forEach(System.out::println);
	}

}
