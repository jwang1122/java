package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.huaxia.kingdomino.Terrain.TerrainImage;

class DeckTest {

	Deck deck;
	ArrayList<Domino> dominoList;
	Terrain terrain1 = new Terrain(TerrainImage.MINE, 1);
	Terrain terrain2 = new Terrain(TerrainImage.SWAMP,0);
	
	@BeforeEach
	void setUp() throws Exception {
		deck = new Deck();
		dominoList = deck.dominoList;
	}

	@Test
	void testSize() {
		assertTrue(deck.dominoList.size()==48);
		Domino domino = dominoList.get(39);
		assertEquals(domino.terrain1, terrain1);
		assertEquals(domino.terrain2, terrain2);
	}
	
	@Test
	void testGetDeckSize() {
		assertTrue(deck.getDeckSize()==48);
		assertTrue(deck.dominoList.get(0).number==1);
	}
	
	@Test
	void testShuffle() {
		deck.shuffle();
		assertFalse(deck.dominoList.get(0).number==1);
	}
	
	@Test
	void testGetNextDominoSet() {
		ArrayList<Domino> list = deck.getNextDominoSet();
		assertTrue(list.size() == 4);
		assertTrue(deck.getDeckSize() ==44);
	}

}
