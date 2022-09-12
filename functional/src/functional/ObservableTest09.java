package functional;

import io.reactivex.rxjava3.core.Observable;

public class ObservableTest09 {
	public static void main(String[] args) throws InterruptedException {
		Integer[] numbers = { 1, 2, 3, 4, 5, 6 };
		String[] letters = { "a", "b", "c", "d", "e", "f", "g" };
		final StringBuilder result = new StringBuilder();
		Observable<String> observable1 = Observable.fromArray(letters);
		Observable<Integer> observable2 = Observable.fromArray(numbers);
		Observable.concat(observable1, observable2).subscribe(letter -> result.append(letter));
		System.out.println(result);
		observable2.map(x -> x*x).forEach(System.out::println);
		System.out.println("number of items: " +observable2.count().blockingGet());
		System.out.println("sum of items: " +observable2.reduce((x,y) -> (x+y)).blockingGet());

	}
}
