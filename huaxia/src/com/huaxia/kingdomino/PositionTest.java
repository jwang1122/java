package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositionTest {
	ArrayList<Position> positionList = new ArrayList<>();
	Position castlePosition = new Position(4,4);
	
	@BeforeEach
	void setUp() throws Exception {
		for(int i=3; i<7; i++) {
			for(int j=2; j<6; j++) {
				Position pos = new Position(i,j);
				positionList.add(pos);
			}
		}
	}

	@Test
	void testSize() {
		assertTrue(positionList.size()==16);
	}
	
	@Test
	void testRemoveCastlePosition() {
		assertTrue(positionList.contains(castlePosition));
		positionList.remove(castlePosition);
		assertFalse(positionList.contains(castlePosition));
		positionList.remove(castlePosition); // remove not exist object 
		assertFalse(positionList.contains(castlePosition));
	}

}
