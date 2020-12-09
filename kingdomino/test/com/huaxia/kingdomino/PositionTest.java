package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositionTest {
	Position pos1, pos2, pos3;
	ArrayList<Position> list = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		pos1 = new Position(4, 4);
		pos2 = new Position(4, 4);
		pos3 = new Position(3, 4);
		list.add(pos1);
		list.add(pos3);
	}

	@Test
	void testEquals() {
		assertEquals(pos1, pos2);
		assertNotEquals(pos1, pos3);
		
	}

	@Test
	void testContains() {
		Position pos4 = new Position(5,5);
		assertTrue(list.contains(pos2));
		assertFalse(list.contains(pos4));
	}
}
