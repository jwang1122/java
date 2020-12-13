package com.huaxia.learnrxjava;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.reactivex.Observable;

class ObservableTest {

	String result="";
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testObservable() {
		Observable<String> observable = Observable.just("Hello");
		observable.subscribe(s -> result = s);
		 
		assertTrue(result.equals("Hello"));
	}
	
	@Test
	void testCompleted() {
		String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
		Observable<String> observable = Observable.fromArray(letters);
		observable.subscribe(
		  i -> result += i,  //OnNext
		  Throwable::printStackTrace, //OnError
		  () -> result += "_Completed" //OnCompleted
		);
		assertTrue(result.equals("abcdefg_Completed"));		
	}

}
