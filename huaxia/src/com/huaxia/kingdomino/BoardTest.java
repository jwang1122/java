package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.kingdomino.Terrain.TerrainImage;

class BoardTest {
	Position position = new Position(1,1);
	Property property1 = new Property(position, Terrain.emptyTerrain);
	Property property2 = new Property(position, new Terrain(TerrainImage.FOREST, 3));
	
	Board board = new Board(9);
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testIsOccupied() {
		board.properties[1][1] = property1;
		assertFalse(board.properties[1][1].isOccupied());
		board.properties[1][1] = property2;
		assertTrue(board.properties[1][1].isOccupied());
		
	}

}
