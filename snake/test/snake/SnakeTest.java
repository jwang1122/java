package snake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game2D.*;

class SnakeTest {

	Snake snake;
	Apple apple;
	
	@BeforeEach
	void setUp() throws Exception {
		snake = new Snake(null, null);
		apple = new Apple(null);
		snake.setApple(apple);
	}

	@Test
	void testMove() {
		snake.setSpeed(new Size(0, 10));
		Rect oldr0 = snake.bodies.get(0);
		Rect oldr1 = snake.bodies.get(1);
		snake.move();
		assertEquals(snake.getLength(),3);
		assertTrue(snake.bodies.get(0).top==20);
		assertTrue(snake.bodies.get(1)==oldr0);
		assertTrue(snake.bodies.get(2)==oldr1);
		
	}

}
