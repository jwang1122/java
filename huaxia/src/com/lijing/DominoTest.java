package com.lijing;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DominoTest {
	Domino d00 = new Domino(0,0); 
	Domino d10 = new Domino(1,0); 
	Domino d01 = new Domino(0,1); 
	Domino d11 = new Domino(1,1); 
	Domino d20 = new Domino(2,0); 
	Domino d22 = new Domino(2,2); 
	Domino d23 = new Domino(2,3); 
	List<Domino> list = new ArrayList<Domino>();
	
	@BeforeEach
	void setUp() throws Exception {
		list.add(d00);
		list.add(d10);
		list.add(d20);
		list.add(d22);
		list.add(d11);
	}

	@Test
	void testEquals() {
		assertEquals(d10, d01);
		assertFalse(d00.equals(d23));
	}

	@Test
	void testCompareTo() {
		assertTrue(d22.compareTo(d20)>0);		
		assertTrue(d00.compareTo(d20)<0);		
		assertTrue(d11.compareTo(d22)<0);		
		assertTrue(d10.compareTo(d01)==0);		
	}
	
	@Test
	void testContains() {
		assertTrue(list.contains(d22));
		assertTrue(list.contains(d01));
		assertFalse(list.contains(d23));
	}
}
