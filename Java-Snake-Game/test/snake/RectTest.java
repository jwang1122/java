package snake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RectTest {
	Rect rect1, rect2, rect3, rect4;
	Position pos1;
	
	@BeforeEach
	void setUp() throws Exception {
		rect1 = new Rect(100,100,50,50);
		rect2 = new Rect(200, 200, 50, 50);
		rect3 = new Rect(110, 100, 60, 60);
		rect4 = new Rect(80, 110, 20, 20);
		pos1 = new Position(110, 110);
	}

	@Test
	void testColliderect() {
		assertFalse(rect1.colliderect(rect2));
		assertTrue(rect1.colliderect(rect3));
		assertFalse(rect2.colliderect(rect3));
		assertTrue(rect1.colliderect(rect4));
		assertTrue(rect4.colliderect(rect1));
	}

	@Test
	void testCollidepoint() {
		assertTrue(rect1.collidepoint(pos1));
		assertFalse(rect2.collidepoint(pos1));
	}

}
