package com.huaxia.learnrxjava;

import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;

/*
 * monad: https://github.com/Froussios/Intro-To-RxJava/blob/master/Part%203%20-%20Taming%20the%20sequence/2.%20Leaving%20the%20monad.md
 * Observable.forEach()
 */
public class RxJava2Example9 {

	public static void main(String[] args) {
		Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

		System.out.println("\nSample 1:");
		values.take(5).forEach(v -> System.out.println(v));
		System.out.println("Subscribed");
		sleep(1000);
		
		System.out.println("\nSample 2:");
		values.take(5).blockingIterable().forEach(v -> System.out.println(v));
		System.out.println("Subscribed");

		System.out.println("\nSample 3:");
		Iterable<Long> iterable = values.take(5).blockingIterable();
		for (long l : iterable)
			System.out.println(l);
		
		System.out.println("\nSample 4:");
		values.take(5).blockingIterable().forEach(System.out::println);;

		
		System.out.println("\nSample 5:");
		iterable = values.take(5).blockingLatest();
		for (long l : iterable)
			System.out.println(l);
		
		System.out.println("\nSample 6:");
		values.take(5).subscribe(v -> System.out.println("Emitted: " + v));
		sleep(1000);
	}

	static void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}
