package com.huaxia.kingdomino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {

	Deck deck = new Deck();

	@BeforeEach
	void setUp() throws Exception {
		deck.loadTilePairFromFile("dominos.csv");
	}

	@Test
	void testLoad() {
		Tile expected = new Tile(1, 0, 0, 'P', 'P');
		Tile result = deck.getDeck().get(0);
		assertEquals(expected, result);
	}

	@Test
	void testShuffle() {
		Tile tile = new Tile(1, 0, 0, 'P', 'P');
		deck.shuffle();
		Tile result = deck.getDeck().get(0);
		assertNotEquals(tile, result);
		
	}
	
	@Test
	void testGetTileList4Selection() {
		ArrayList<Tile> list = deck.getTileList4Selection();
		assertTrue(list.size()==4);
		assertTrue(list.get(0) instanceof Tile);
	}
}
