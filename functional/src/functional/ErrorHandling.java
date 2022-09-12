package functional;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.DisposableObserver;

public class ErrorHandling {

	public static void main(String[] args) {
		Observable.just("Hello", "1", "2")
		.map(x -> x.toUpperCase())
		.forEach(System.out::println);

	}

}
