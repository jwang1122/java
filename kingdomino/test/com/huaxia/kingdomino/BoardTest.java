package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.kingdomino.Player.PlayerColor;
import com.huaxia.kingdomino.Terrain.TerrainImage;

class BoardTest {
	Player player = new Player(PlayerColor.BluePlayer);
	Board board = new Board(player, 9);
	Terrain terrain1 = new Terrain(TerrainImage.FOREST, 2);
	Terrain terrain2 = new Terrain(TerrainImage.FIELD, 0);
	Domino domino = new Domino(1, terrain1, terrain2);
	Terrain forest = new Terrain(TerrainImage.FOREST, 1);
	Terrain mine = new Terrain(TerrainImage.MINE,0);
	Terrain mountain = new Terrain(TerrainImage.MOUNTAIN,2);
	Terrain swamp = new Terrain(TerrainImage.SWAMP, 0);
	Terrain water = new Terrain(TerrainImage.WATER, 1);
	Terrain field = new Terrain(TerrainImage.FIELD, 1);
	Terrain castle = new Terrain(TerrainImage.CASTLE, 0);
	Position pos1, pos2;
	
	@BeforeEach
	void setUp() throws Exception {
		board.topRow = 2;
		board.bottomRow = 6;
		board.leftColumn = 3;
		board.rightColumn = 7;
		
		domino = new Domino(1, terrain1, terrain2);

		pos1 = new Position(3, 4);
		board.properties[2][4]=new Property(new Position(2,4), forest);
		board.properties[3][3]=new Property(new Position(2,4), mine);
		board.properties[4][4]=new Property(new Position(4,4), castle);
		pos2 = new Position(3, 5);
		board.properties[2][5]=new Property(new Position(2,4), forest);
		board.properties[3][6]=new Property(new Position(2,4), swamp);
		board.properties[4][5]=new Property(new Position(2,4), forest);
	}

	@Test
	void testIsDiagonal() {
		Position pos1 = new Position(3,3);
		Position pos2 = new Position(3,4); // one row
		assertFalse(board.isDiagonal(pos1, pos2));
		
		pos1 = new Position(2,4);
		pos2 = new Position(3,4); // one column
		assertFalse(board.isDiagonal(pos1, pos2));
		
		pos1 = new Position(2,4);
		pos2 = new Position(3,5); // diagonal
		assertTrue(board.isDiagonal(pos1, pos2));
		
		// how about if two positions not connected?
		pos2 = new Position(7,8);
		assertTrue(board.isDiagonal(pos1, pos2));
	}
	
	@Test
	void testIsOutOf5X5Frame() {
		board.leftColumn = 2;
		board.rightColumn = 6;
		board.topRow = 3;
		board.bottomRow = 7;
		Position pos1 = new Position(4, 6);
		Position pos2 = new Position(4, 7); // only one out
		assertTrue(board.isOutOf5X5Frame(pos1, pos2)); // it is out bound
		assertTrue(board.leftColumn == 2); // the frame bound no changes
		assertTrue(board.rightColumn == 6);
		assertTrue(board.topRow == 3);
		assertTrue(board.bottomRow == 7);

		pos1 = new Position(4, 7); // both out of frame
		pos2 = new Position(4, 8);
		assertTrue(board.isOutOf5X5Frame(pos1, pos2)); // it is out bound
		assertTrue(board.leftColumn == 2); // the frame bound no changes
		assertTrue(board.rightColumn == 6);
		assertTrue(board.topRow == 3);
		assertTrue(board.bottomRow == 7);

		pos1 = new Position(4, 5); // within frame
		pos2 = new Position(4, 6);
		assertFalse(board.isOutOf5X5Frame(pos1, pos2)); // it is out bound
		assertTrue(board.leftColumn == 2); // the frame bound no changes
		assertTrue(board.rightColumn == 6);
		assertTrue(board.topRow == 3);
		assertTrue(board.bottomRow == 7);

		pos1 = new Position(1, 5); // within frame
		pos2 = new Position(1, 6);
		assertTrue(board.isOutOf5X5Frame(pos1, pos2)); // it is out bound
		assertTrue(board.leftColumn == 2); // the frame bound no changes
		assertTrue(board.rightColumn == 6);
		assertTrue(board.topRow == 3);
		assertTrue(board.bottomRow == 7);
}
	
	@Test
	void testIsOccupied() {
		Position pos1 = new Position(2, 3); 
		Position pos2 = new Position(2, 4);
		board.insertDomino(player, domino, pos1, pos2); // insert the domino
		assertTrue(board.isOccupied(pos1, pos2));
		
		pos2 = new Position(2,5); //one position empty
		assertTrue(board.isOccupied(pos1, pos2));

		pos1 = new Position(1,4); // both position available
		pos2 = new Position(1,3);
		assertFalse(board.isOccupied(pos1, pos2));
	}

	@Test
	void testHasSameTerrainAround() {
		assertTrue(board.hasSameTerrainAround(domino, pos1, pos2));
		domino.terrain1 = water;
		domino.terrain2 = water;
		assertTrue(board.hasSameTerrainAround(domino, pos1, pos2)); // due to castle
		pos1 = new Position(4,6);
		pos2 = new Position(4,7);
		assertFalse(board.hasSameTerrainAround(domino, pos1, pos2)); 
	}
}
