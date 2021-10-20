package com.john.reactivex;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableMaybeObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UseMaybe {

	public static void main(String[] args) {
		Disposable d = Maybe.just("Hello World").subscribeWith(new DisposableMaybeObserver<String>() {
//		Disposable d = Maybe.just("Hello World").delay(10, TimeUnit.SECONDS, Schedulers.io()).subscribeWith(new DisposableMaybeObserver<String>() {
			@Override
			public void onStart() {
				System.out.println("Started...");
			}

			@Override
			public void onSuccess(String value) {
				System.out.println("Success: " + value);
			}

			@Override
			public void onError(Throwable error) {
				error.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Done!");
			}
		});

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		d.dispose();
	}

}
