package tetris;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game2D.Rect;

class TetrisTest {

	Tetris tetris;
	
	@BeforeEach
	void setUp() throws Exception {
		tetris = new Tetris();
	}

	@Test
	void testClone() {
		int[][] shape = tetris.coordinates[0].clone();
		assertFalse(shape==tetris.coordinates[0]);
		assertEquals(shape[0][1], tetris.coordinates[0][0][1]);
	}
	
	@Test
	void testMakeTetris() {
		tetris.setCurrentShape(Tetris.Tetrominoe.TShape);
		ArrayList<Rect> rects = tetris.makeTetris();
		assertEquals(4, rects.size());
	}

}
