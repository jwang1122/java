package com.john.reactivex;

import io.reactivex.rxjava3.core.Observable;

public class UseJust {

	static void display(Observable<Integer> x1) {
		x1.subscribe(System.out::println);
	}
	public static void main(String[] args) {
		display(Observable.just(1,2,3,4,5));
	}

}
