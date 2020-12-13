package com.huaxia.learnrxjava;

import fj.data.Either;

public class EitherExample2 {
	public static Either<Exception, Integer> divide(int x, int y) {
	    try {
	        return Either.right(x / y);
	    } catch (Exception e) {
	        return Either.left(e);
	    }
	}
	 
	public static void main(String[] args) {
		printResult(divide(10, 5));
		printResult(divide(10, 0));
	}

	static void printResult(Either<Exception, Integer> result) {
		if(result.isRight()) {
			System.out.println(result.right().value());
			return;
		}
		System.out.println(result.left().value());		
	}
}
