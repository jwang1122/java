package com.john.reactivex;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Observer1 implements Observer<String> {
	List<String> list = new ArrayList<>();
	
	@Override
	public void onComplete() {
		System.out.println(list);
		
	}

	@Override
	public void onError(@NonNull Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNext(@NonNull String arg0) {
		list.add(arg0);
		
	}

	@Override
	public void onSubscribe(@NonNull Disposable arg0) {
		// TODO Auto-generated method stub
		
	}

}
