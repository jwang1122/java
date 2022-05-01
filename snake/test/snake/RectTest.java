package snake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game2D.Position;
import game2D.Rect;
import game2D.Size;

class RectTest {
	Rect rect1,rect2,rect3;
	Position pos;
	Size size;
	
	@BeforeEach
	void setUp() throws Exception {
		size = new Size(50,50);
		pos = new Position(100,100);
		rect1 = new Rect(pos, size);
	}

	@Test
	void testCollidepoint() {
		assertTrue(rect1.collidepoint(pos));
	}

}
