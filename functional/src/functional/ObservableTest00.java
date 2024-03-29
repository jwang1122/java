package functional;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObservableTest00 {

	public static void main(String[] args) throws InterruptedException {
	      //Create the observable
	      Single<String> testSingle = Single.just("Hello World");

	      //Create an observer
	      Disposable disposable = testSingle
	         .delay(2, TimeUnit.SECONDS, Schedulers.io())
	         .subscribeWith(
	         new DisposableSingleObserver<String>() {

	         @Override
	         public void onError(Throwable e) {
//	            e.printStackTrace();
	            System.out.println(e.getMessage());
	         }

	         @Override
	         public void onSuccess(String value) {
	            System.out.println(value);
	         }
	      });
	      Thread.sleep(3000);
	      //start observing
	      disposable.dispose();	}

}
