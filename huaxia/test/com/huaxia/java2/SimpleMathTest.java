package com.huaxia.java2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleMathTest {
	SimpleMath math = new SimpleMath();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAdd() {
		assertTrue(math.add(3, 5)==8);
	}

}
