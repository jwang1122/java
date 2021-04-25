package com.huaxia.ap2021.section2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TournamentTest {

	Tournament t;
	Player p1, p2, p3, p4;

	@BeforeEach
	void setUp() throws Exception {
		t = new Tournament();
		p1 = t.requestSlot("Angela");
		p2 = t.requestSlot("John");
		p3 = t.requestSlot("Nick");
		p4 = t.requestSlot("Charles");
	}

	@Test
	void testRequestSlot() {
		assertTrue(p3 == null);
		assertTrue(p4 == null);
		assertTrue(2 == t.getSlots().length);
		assertTrue(2 == t.getWaitingList().size());
		assertEquals(p1.getName(), "Angela");
		assertEquals(p2.getName(), "John");
		List<String> waitings = t.getWaitingList();
		assertEquals(waitings.get(0), "Nick");
		assertEquals(waitings.get(1), "Charles");
	}

	@Test
	void testCancelAndReassignSlot() {
		Player p5 = t.cancelAndReassignSlot(p1);
		assertEquals(p5.getName(), "Nick");
		assertEquals(t.getSlots()[0].getName(), "Nick");
		assertTrue(1 == t.getWaitingList().size());
	}

	@Test
	void testCancelWithEmptyWaitingList() {
		t.setWaitingList(new ArrayList<String>());
		assertTrue(0 == t.getWaitingList().size());
		Player p = t.cancelAndReassignSlot(p1);
		assertTrue(p==null);
		assertTrue(p1.getPlayerNumber()==0);
		assertTrue(t.getSlots()[0]==null);
	}
}
