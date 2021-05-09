package com.huaxia.ap2021.section2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @see WordSet
 * 
 * @author John
 *
 */
class WordSetTest {

	WordSet wordset;
	@BeforeEach
	void setUp() throws Exception {
		String[] words = { "GRAPE", "PEAR", "FIG", "APPLE" };
		wordset = new WordSet(words);
	}

	@Test
	void testFindkth() {
		String word = wordset.findkth(3);
		assertEquals(word, "GRAPE");
	}

	@Test
	void testCountA() {
		int c = WordSet.countA(wordset);
		assertTrue(c==1);
	}
	
	@Test
	void testRemoveA() {
		WordSet.removeA(wordset);
		int c = WordSet.countA(wordset);
		assertTrue(c==0);
	}
	
	@Test
	void testCommonElements() {
		String[] s1Array = {"BE","NOT","AFRAID"};
		WordSet s1 = new WordSet(s1Array);
		String[] s2Array = {"TO","BE","OR","NOT"};
		WordSet s2 = new WordSet(s2Array);
		WordSet ws = WordSet.commonElements(s1, s2);
		assertTrue(ws.contains("BE"));
		assertTrue(ws.contains("NOT"));
		assertTrue(ws.size()==2);
		
	}
}
