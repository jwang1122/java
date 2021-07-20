package com.huaxia.java2;

import static org.junit.jupiter.api.Assertions.*;

import javax.sound.midi.InvalidMidiDataException;

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
	
	@Test
	void testException() {
		Exception exception = assertThrows(InvalidMidiDataException.class, ()->{
			math.circleArea(-2.3);
		});
		
		String expectedMessage = "Radius of circle cannot be negative.";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
