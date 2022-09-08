package basics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import katherine.Point;

class PointTest {

	Point p1, p2, p3, p4;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = new Point(-5, 6, "A");
		p2 = new Point(2, 1, "B");
		p3 = new Point(1, 2, "C");
		p4 = new Point(5, 5, "D");
	}

	@Test
	void testNegate() {
		Point expected = new Point(5, -6, "A");
		Point actual = Point.negate(p1);
		assertEquals(expected, actual);
	}

	@Test
	void testTranslate() {
		Point expected = new Point(-7, 5, "A'");
		p1.translate(p2);
		assertEquals(expected, p1);
	}
	
	@Test
	void testRotateAboutOrigin() {
		Point expected = new Point(-2.0, 1.0, "C'");
		p3.rotate(90);
		assertEquals(expected, p3);
	}

	@Test
	void testRotateAboutPoint() {
		Point expected = new Point(-2.0, 4.0, "D'");
		p4.rotate(90, p2);
		assertEquals(expected, p4);
	}

}
