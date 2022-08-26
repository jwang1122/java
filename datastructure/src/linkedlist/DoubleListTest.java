package com.huaxia.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoubleListTest {
	DoubleList dl = new DoubleList();
	String line = "A A A A B V S E A S A A";
	
	@BeforeEach
	void setUp() throws Exception {
		String[] words = line.split(" ");
		for(int i=0; i<words.length; i++) {
			dl.add(words[i]);
		}
	}

	@Test
	void testGetWord() {
		String actual = dl.getWord(2);
		assertEquals(actual, "V");
		
		actual = dl.getWord(-1);
		assertEquals(actual, "S");
	}

}
