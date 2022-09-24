package functional;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class RxTest01 {

	public static void main(String[] args) {
	      Flowable.just("世界您好!", "1", "2").subscribe(System.out::println);
	      Observable.just(1,2,3,4)
	      	.subscribe();
	}

}
