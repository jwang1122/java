package game2D;

import java.util.Random;

/**
 * This class will be used for 2D graphic games
 * @author John
 *
 */
public class Position {
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public static Position randomPosition(int width, int height) {
		Random rand = new Random();
		int x = Math.abs(rand.nextInt()) % (width - 20);
		int y = Math.abs(rand.nextInt()) % (height - 50);
		return new Position(x, y);
	}

	public static Position randomPosition(int winWidth, int winHeight, int rectWidth, int rectHeight) {
		Random rand = new Random();
		int x = rand.nextInt(winWidth / rectWidth) * rectWidth;
		int y = rand.nextInt(winHeight / rectHeight) * rectHeight;
		Position pos = new Position(x, y);
		return pos;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
