package functional;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

public class ObservableTest12 {
	private static CompositeDisposable mRxEvent = new CompositeDisposable();

	public static void main(String[] args) {
		Disposable subscribe = Observable.create(new ObservableOnSubscribe<String>() {
			@Override
			public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
				e.onNext("俊俊俊很帅");
				e.onNext("你值得拥有");
				e.onNext("取消关注");
				e.onNext("但还是要保持微笑");
				e.onComplete();
			}
		}).subscribe(new Consumer<String>() {
			@Override
			public void accept(@NonNull String t) throws Throwable {
				// 对应onNext()
				System.out.println("accept=" + t);
			}
		}, new Consumer<Throwable>() {
			@Override
			public void accept(@NonNull Throwable throwable) throws Exception {
				// 对应onError()
			}
		}, new Action() {
			@Override
			public void run() throws Exception {
				// 对应onComplete()
			}
		}
//		, (@NonNull DisposableContainer) new Consumer<Disposable>() {
//			@Override
//			public void accept(@NonNull Disposable disposable) throws Exception {
//				// 对应onSubscribe()
//			}
//		}
	);

		mRxEvent.add(subscribe);
		mRxEvent.clear();
	}
}
