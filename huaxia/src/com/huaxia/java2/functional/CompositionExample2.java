package com.huaxia.java2.functional;

import java.util.function.Function;

public class CompositionExample2 {

	public static void main(String[] args) {
		Function<Integer, Integer> multiply = (value) -> value * 2;
		Function<Integer, Integer> add = (value) -> value + 3;

		Function<Integer, Integer> addThenMultiply = multiply.compose(add);

		Integer result1 = addThenMultiply.apply(3);
		System.out.println(result1);
		
		Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);

		Integer result2 = multiplyThenAdd.apply(3);
		System.out.println(result2);
	}
}
