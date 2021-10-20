package com.john.reactivex;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableObserver;

public class UseObservable {
	static void observableInt() {
		Disposable d = Observable.range(1, 5).subscribeWith(new DisposableObserver<Integer>() {
			@Override
			public void onStart() {
				System.out.println("Start!");
			}

			@Override
			public void onNext(Integer t) {
//				if (t == 3) {
//					dispose();
//				}
				System.out.println(t);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Done!");
			}
		});
		// ...
		d.dispose();
	}

	public static void main(String[] args) {
//		observableInt();

//		Disposable d = Observable.just("Hello world!").subscribeWith(new DisposableObserver<String>() {
		Disposable d = Observable.just("Hello world!").delay(1, TimeUnit.SECONDS).subscribeWith(new DisposableObserver<String>() {
			@Override
			public void onStart() {
				System.out.println("Start!");
			}

			@Override
			public void onNext(String t) {
				System.out.println(t);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Done!");
			}
		});

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// the sequence can now be disposed via dispose()
		d.dispose();
	}

}
