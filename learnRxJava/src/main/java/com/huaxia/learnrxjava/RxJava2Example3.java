package com.huaxia.learnrxjava;

import io.reactivex.Observable;

public class RxJava2Example3 {
	static String result = "";
	public static void main(String[] args) {
		Observable<String> observable = Observable.just("Hello");
		observable.subscribe(s -> result = s);
		 
		System.out.println(result);
	}

}
