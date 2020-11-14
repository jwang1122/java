package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

	Board board = new Board(9);
	
	@BeforeEach
	void setUp() throws Exception {
	
	}

	@Test
	void testDeepCLone() {
		Property[][] properties = board.deepClone();
		properties[0][0] = new Property(0,0,2,'M');
		assertNotEquals(board.properties[0][0], properties[0][0]);
	}

}
