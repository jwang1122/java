package tetris;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import game2D.Rect;
import game2D.Size;

public class Tetris {
	static final int width = 20;
	static final int height = 20;
	static final Size speed = new Size(0,20);
	
	protected enum Tetrominoe {
		ZShape, SShape, LineShape, TShape, SquareShape, LShape, MirroredLShape
	}

	public static Color[] colors = new Color[7];

	static {
		colors[0] = new Color(31, 222, 145);
		colors[1] = new Color(222, 31, 190);
		colors[2] = new Color(31, 191, 222);
		colors[3] = new Color(108, 31, 222);
		colors[4] = new Color(255, 255, 0);
		colors[5] = new Color(0, 255, 255);
		colors[6] = new Color(127, 127, 255);
	}

	Tetrominoe type;
	int[][] currentShape;
	public Color color;
	int[][][] coordinates;
	ArrayList<Rect> shape;

	public Tetris() {
		coordinates = new int[][][] { // Coordinates array for all 7 shapes
				{ { 0, -1 }, { 0, 0 }, { -1, 0 }, { -1, 1 } }, // ZShape
				{ { 0, -1 }, { 0, 0 }, { 1, 0 }, { 1, 1 } }, // SShape
				{ { 0, -1 }, { 0, 0 }, { 0, 1 }, { 0, 2 } }, // LineShape
				{ { -1, 0 }, { 0, 0 }, { 1, 0 }, { 0, 1 } }, // TShape
				{ { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 } }, // SquareShape
				{ { -1, -1 }, { 0, -1 }, { 0, 0 }, { 0, 1 } }, // LShape
				{ { 1, -1 }, { 0, -1 }, { 0, 0 }, { 0, 1 } } // MirroredLShape
		};
		type = Tetrominoe.TShape;
//		currentShape = coordinates[Tetrominoe.TShape.ordinal()];
//		color = colors[Tetrominoe.TShape.ordinal()];
		setNextRandomShape();
	}

	public void setCurrentShape(Tetrominoe type) {
		currentShape = coordinates[type.ordinal()];
		color = colors[type.ordinal()];
	}

	public void setNextRandomShape() {
		Random rand = new Random();
		int index = rand.nextInt(7);
		currentShape = coordinates[index];
		color = colors[index];
	}

	public ArrayList<Rect> makeTetris() {
		int y = 0;
		int x = 0;
		if(shape==null) {
			shape = new ArrayList<Rect>();
		}else {
			x = shape.get(0).left;
			y = shape.get(0).top;
			shape.clear();
		}
		for (int i = 0; i < 4; i++) {
			int left = currentShape[i][0] * Tetris.width;
			int top = currentShape[i][1] * Tetris.height;
			Rect rect = new Rect(left, top, Tetris.width, Tetris.height);
			rect.move_ip(new Size(50, 20));
			rect.move_ip(new Size(x, y));
			shape.add(rect);
		}
		return shape;
	}

	public void rotateLeft() {
		Tetris t = new Tetris();
		for (int i = 0; i < 4; ++i) {
			t.setX(i, y(i));
			t.setY(i, -x(i));
		}
		currentShape = t.currentShape;
	}

	public void rotateRight() {
		Tetris t = new Tetris();
		for (int i = 0; i < 4; ++i) {
			t.setX(i, -y(i));
			t.setY(i, x(i));
		}
		currentShape = t.currentShape;
	}

	private void setX(int index, int x) {
		currentShape[index][0] = x;
	}

	private void setY(int index, int y) {
		currentShape[index][1] = y;
	}

	public int x(int index) {
		return currentShape[index][0];
	}

	public int y(int index) {
		return currentShape[index][1];
	}

	public ArrayList<Rect> getShape() {
		return makeTetris();
	}

	public void moveDown() {
		for(Rect rect : shape) {
			rect.move_ip(speed);
		}
	}

	public void moveLeft() {
		for(Rect rect : shape) {
			rect.move_ip(new Size(-20,0));
		}
	}

	public void moveRight() {
		for(Rect rect : shape) {
			rect.move_ip(new Size(20,0));
		}
	}

}