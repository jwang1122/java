package com.john.reactivex;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UseSingle {

	public static void main(String[] args) {
		Disposable d = Single.just("Hello World")
				.delay(10, TimeUnit.SECONDS, Schedulers.io())
				.subscribeWith(new DisposableSingleObserver<String>() {
			@Override
			public void onStart() {
				System.out.println("Started... ");
			}

			@Override
			public void onSuccess(String value) {
				System.out.println("Success: " + value);
			}

			@Override
			public void onError(Throwable error) {
				error.printStackTrace();
			}
		});

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		d.dispose();
		System.out.println("Done.");
	}

}
