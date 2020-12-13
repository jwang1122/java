package com.huaxia.learnrxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

//https://www.programcreek.com/java-api-examples/?api=io.reactivex.functions.Function
public class Functional1 {

	public static void main(String[] args) {
		Observable<Integer> values = Observable.just(1, 2, 3, 4, 5, 6);
		values.filter(n -> n % 2 == 0).forEach(System.out::println);
		System.out.println('\n');

		values = Observable.just(3, 13, 22);
		values.map((num) -> num * 3).forEach(System.out::println);

	}

	
	
}
