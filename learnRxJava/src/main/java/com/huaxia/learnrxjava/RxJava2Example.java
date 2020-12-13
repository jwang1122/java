package com.huaxia.learnrxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class RxJava2Example {
	public static void main(String[] args) {
		// producer
		Observable<String> observable = Observable.just("Huaxia", " Java", " Level", "-", "I\n");

		// consumer
		Consumer<? super String> consumer = System.out::print;

		// Attaching producer to consumer
		observable.subscribe(consumer);
		
	}
}