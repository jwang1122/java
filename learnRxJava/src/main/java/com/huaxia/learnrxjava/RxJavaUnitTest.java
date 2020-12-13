package com.huaxia.learnrxjava;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.observers.DisposableObserver;
/*
 * https://www.vogella.com/tutorials/RxJava/article.html
 */
public class RxJavaUnitTest {

	public static void main(String[] args) {
		RxJavaUnitTest test = new RxJavaUnitTest();
		Observable<Todo> todoObservable = Observable.create(new ObservableOnSubscribe<Todo>() {
			@Override
			public void subscribe(ObservableEmitter<Todo> emitter) throws Exception {
				try {
					List<Todo> todos = test.getTodos();
					for (Todo todo : todos) {
						emitter.onNext(todo);
					}
					emitter.onComplete();
				} catch (Exception e) {
					emitter.onError(e);
				}
			}
		});
		todoObservable.subscribeWith(new  DisposableObserver<Todo>() {

		    @Override
		    public void onNext(Todo t) {
		    	System.out.println(t);
		    }

		    @Override
		    public void onError(Throwable e) {
		    	e.printStackTrace();
		    }

		    @Override
		    public void onComplete() {
		    	System.out.println("Finish shopping.");
		    }
		});

	}

	ArrayList<Todo> getTodos(){
		ArrayList<Todo> list = new ArrayList<>();
		Todo todo = new Todo("Make shooping list.");
		list.add(todo);
		todo = new Todo("Lock door.");
		list.add(todo);
		todo = new Todo("Drive car to store...");
		list.add(todo);
		todo = new Todo("Pick up items...");
		list.add(todo);
		todo = new Todo("Check out.");
		list.add(todo);
		todo = new Todo("Drive back home.");
		list.add(todo);
		return list;
	}
	
	class Todo{
		String thing;
		Todo(String thing){
			this.thing = thing;
		}
		@Override
		public String toString() {
			return "Todo [thing=" + thing + "]";
		}
		
	}

}
