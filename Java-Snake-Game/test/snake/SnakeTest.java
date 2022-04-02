package snake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SnakeTest {

	Snake snake;
	@BeforeEach
	void setUp() throws Exception {
		
		snake = new Snake(new Board());
		snake.setHead(new Position(10,10));
		snake.addTail(new Position(10,0));
		snake.addTail(new Position(10,-10));
	}

	@Test
	void testMove() {
		Position newP = new Position(10, 20);
		Position oldP0 = snake.bodies.get(0);
		Position oldP1 = snake.bodies.get(1);
		snake.move(newP);
		assertTrue(snake.bodies.size()==3);
		assertTrue(snake.bodies.get(0).equals(newP));
		assertTrue(snake.bodies.get(1).equals(oldP0));
		assertTrue(snake.bodies.get(2).equals(oldP1));
		
	}

}
