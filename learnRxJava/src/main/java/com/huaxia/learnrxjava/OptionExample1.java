package com.huaxia.learnrxjava;

import fj.data.Option;

public class OptionExample1 {
	public static Option<Object> divide(double x, double y) {
		if (y == 0)
			return Option.none();
		return Option.some(x / y);
	}

	static Option<Object> toUpperCase(String s) {
		if(s==null)
			return Option.none();
		return Option.some(s.toUpperCase());
	}
	
	
	public static void main(String[] args) {
		printResult(divide(10.0, 2.0));
		printResult(divide(10.0, 0.0));
		
		printResult(toUpperCase("this is a test."));
		printResult(toUpperCase(null));
		
		System.out.println("Done.");
	}

	static void printResult(Option<Object> result) {
		if (result.isSome()) {
			System.out.println(result.some());
			return;
		}
		System.out.println(result);
	}

}
