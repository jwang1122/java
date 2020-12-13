package com.huaxia.learnrxjava;

import io.reactivex.Observable;

public class RxJava2Example5 {
	static String result = "Make it upper case: ";

	public static void main(String[] args) {
		String letters = "abcdefg";
		Observable.just(letters).map(String::toUpperCase).subscribe(letter -> result += letter);
		System.out.println(result);
	}

}
