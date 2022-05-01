package game2D;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositionTest {
	int winWidth = 640;
	int winHeight = 480;
	int rectWidth = 10;
	int rectHeight = 10;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRandomPosition() {
		Position pos = Position.randomPosition(winWidth, winHeight);
		int x = pos.getX();
		int y = pos.getY();
		assertTrue(x>=0);
		assertTrue(x<winWidth);
		assertTrue(y>=0);
		assertTrue(y<winWidth);
	}

	@Test
	void testGetRandomPosition() {
		Position pos = Position.randomPosition(winWidth, winHeight, rectWidth, rectHeight);
		int x = pos.getX();
		int y = pos.getY();
		assertTrue(x>=0);
		assertTrue(x<winWidth);
		assertTrue(y>=0);
		assertTrue(y<winWidth);
		assertTrue(x%rectWidth==0);
		assertTrue(y%rectHeight==0);
		
	}

}
