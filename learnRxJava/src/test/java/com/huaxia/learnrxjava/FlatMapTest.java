package com.huaxia.learnrxjava;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlatMapTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMap() {
		Optional<String> s = Optional.of("test");
		assertEquals(Optional.of("TEST"), s.map(String::toUpperCase));
	}

	@Test
	void testNestedMap() {
		assertEquals(Optional.of(Optional.of("STRING")), 
				Optional.of("string").map(s -> Optional.of("STRING")));
	}

	@Test
	void testFlatMap() {
		assertEquals(Optional.of("STRING"), 
				Optional.of("string").flatMap(s -> Optional.of("STRING")));
	}
}
