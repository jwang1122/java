package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.kingdomino.Terrain.TerrainImage;

class BoardTest {
	Board board = new Board(9);
	Terrain terrain1 = new Terrain(TerrainImage.FOREST, 2);
	Terrain terrain2 = new Terrain(TerrainImage.FIELD, 0);
	Tile tile = new Tile(1, terrain1, terrain2);

	@BeforeEach
	void setUp() throws Exception {

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
	}
	
	@Test
	void testIsOccupied() {
		Position pos1 = new Position(3, 5); 
		Position pos2 = new Position(3, 6);
		board.insertDomino(tile, pos1, pos2); // insert the domino
		assertTrue(board.isOccupied(pos1, pos2));
		
		pos2 = new Position(3,4); //one position empty
		assertTrue(board.isOccupied(pos1, pos2));

		pos1 = new Position(3,3); // both position available
		assertFalse(board.isOccupied(pos1, pos2));
		
	}

//
//	@Test
//	void testInserTile() {
//		board.leftColumn = 2;
//		board.rightColumn = 5;
//		board.topRow = 3;
//		board.bottomRow = 7;
//		board.insertTile(tile, new Position(4,5), new Position(4,6));
//		assertTrue(board.leftColumn == 2);
//		assertTrue(board.rightColumn==6); // adjust the rightColumn
//		assertTrue(board.topRow == 3);
//		assertTrue(	board.bottomRow == 7);
//		assertTrue(board.properties[4][5].terrain.equals(terrain1));
//		assertTrue(board.properties[4][6].terrain.equals(terrain2));
//	}
//	
//	@Test
//	void testRemoveTile() {
//		board.leftColumn = 2;
//		board.rightColumn = 6;//rightColumn out of bound
//		board.topRow = 3;
//		board.bottomRow = 7;
//		board.insertTile(tile, new Position(4,6), new Position(4,7));
//		assertTrue(board.rightColumn==7);
//		assertTrue(board.properties[4][7].terrain.equals(terrain2));
//		
//		board.removeTile(new Position(4,6), new Position(4,7));
//		assertTrue(board.rightColumn==6); // bring rightColumn back to 6 due to remove
//		assertTrue(board.properties[4][7].terrain.equals(Terrain.emptyTerrain));
//		
//		board.leftColumn = 2;
//		board.rightColumn = 7;//rightColumn out of bound
//		board.topRow = 2; // out of bound
//		board.bottomRow = 7;
//		board.removeTile(new Position(2,6), new Position(2,7));
//		assertTrue(board.rightColumn==6); // bring rightColumn back to 6 due to remove
//		assertTrue(board.topRow==3); // bring topRow back to 3
//
//		board.leftColumn = 2;
//		board.rightColumn = 7;//rightColumn out of bound
//		board.topRow = 2; // out of bound
//		board.bottomRow = 7;
//		board.removeTile(new Position(7,6), new Position(7,7));
//		assertTrue(board.rightColumn==6); // bring rightColumn back to 6 due to remove
//		assertTrue(board.bottomRow==6); // bring topRow back to 6
//
//		board.leftColumn = 2;
//		board.rightColumn = 8; // out of bound by 2
//		board.topRow = 2; 
//		board.bottomRow = 6;
//		board.removeTile(new Position(3,7), new Position(3,8)); // both position out bound
//		assertTrue(board.leftColumn == 2);
//		assertTrue(board.rightColumn==6); // adjust the rightColumn
//		assertTrue(board.topRow == 2);
//		assertTrue(	board.bottomRow == 6);
//		
//	}
}
