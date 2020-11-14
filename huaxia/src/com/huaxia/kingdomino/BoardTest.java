package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

	Board board = new Board(9);
	Property property = new Property(1, 1, 1, 'M');
	
	@BeforeEach
	void setUp() throws Exception {
		board.properties[1][1] = property;
	}

	@Test
	void testDeepCLone() {
		Property[][] properties = board.deepClone();
		properties[0][0] = new Property(0,0,2,'M');
		assertNotEquals(board.properties[0][0], properties[0][0]);
		assertEquals(board.properties[1][1], properties[1][1]);
	}
	
}
