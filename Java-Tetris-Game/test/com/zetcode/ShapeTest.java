package com.zetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShapeTest {
	Shape shape;
	
	@BeforeEach
	void setUp() throws Exception {
		shape = new Shape();
		shape.setRandomShape();
	}

	@Test
	void testShape() {
		shape.setShape(Shape.Tetrominoe.TShape);
		shape.rotateLeft();
	}

}
