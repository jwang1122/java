package snake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game2D.Position;

class PositionTest {
	Position pos;
	int winWidth = 640;
	int winHeight = 480;
	int rectWidth = 10;
	int rectHeight = 10;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testRandomPosition() {
		Position pos = Position.randomPosition(winWidth, winHeight, rectWidth, rectHeight);
		assertTrue(pos.getX()>=0);
		assertTrue(pos.getX()<winWidth);
		assertTrue(pos.getY()>=0);
		assertTrue(pos.getY()<winHeight);
	}

	void testGetRandomPosition() {
		
	}
}
