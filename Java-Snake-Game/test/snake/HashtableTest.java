package snake;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;
import java.util.Hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashtableTest {
	Hashtable<Integer, Integer> keys = new Hashtable<>();
	
	@BeforeEach
	void setUp() throws Exception {
		keys.put(KeyEvent.VK_LEFT, 110);
		keys.put(KeyEvent.VK_RIGHT, 120);
		keys.put(KeyEvent.VK_UP, 130);
		keys.put(KeyEvent.VK_DOWN, 140);
	}

	@Test
	void testContains() {
		if(keys.containsKey(37)) {
			assertTrue(110==keys.get(37));
		}
		if(keys.containsKey(39)) {
			assertTrue(120==keys.get(39));
		}
		if(keys.containsKey(38)) {
			assertTrue(130==keys.get(38));
		}
		if(keys.containsKey(40)) {
			assertTrue(140==keys.get(40));
		}
	}

}
