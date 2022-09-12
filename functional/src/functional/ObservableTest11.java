package functional;

import java.util.logging.Logger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.core.Flowable;

public class ObservableTest11 {
	static Logger logger = Logger.getLogger("RX");

	public static void main(String[] args) {
		Flowable.range(0,10)
        .subscribe(new Subscriber<Integer>() {
            Subscription sub;
            //当订阅后，会首先调用这个方法，其实就相当于onStart()，
            //传入的Subscription s参数可以用于请求数据或者取消订阅
            @Override
            public void onSubscribe(Subscription s) {
            	logger.info("TAG:onsubscribe start");
                sub=s;
                sub.request(1);
                logger.info("TAG:onsubscribe end");
            }

            @Override
            public void onNext(Integer o) {
            	logger.info("onNext--->"+o);
                sub.request(1);
            }
            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }
            @Override
            public void onComplete() {
            	logger.info("onComplete");
            }
        });	}

}
