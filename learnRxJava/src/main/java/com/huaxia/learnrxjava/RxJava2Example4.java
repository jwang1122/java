package com.huaxia.learnrxjava;

import io.reactivex.Observable;

public class RxJava2Example4 {
	static String result = "";

	public static void main(String[] args) {
		String[] letters = { "a", "b", "c", "d", "e", "f", "g" };
		Observable<String> observable = Observable.fromArray(letters);
		observable.subscribe(i -> result += i, // OnNext
				Throwable::printStackTrace, // OnError
				() -> result += "_Completed" // OnCompleted
		);
		System.out.println(result);
	}

}
