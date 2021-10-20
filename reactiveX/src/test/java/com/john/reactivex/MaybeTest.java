package com.john.reactivex;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.rxjava3.core.Flowable;

public class MaybeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
    public void fromFlowableEmpty() {
        Flowable.empty()
        .singleElement()
        .test()
        .assertResult();
    }
    @Test
    public void fromFlowableJust() {

        Flowable.just(1)
        .singleElement()
        .test()
        .assertResult(1);
    }

}
