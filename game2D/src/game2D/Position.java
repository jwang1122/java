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
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public static Position randomPos(int width, int height) {
		Random rand = new Random();
		int x = Math.abs(rand.nextInt()) % (width-20);
		int y = Math.abs(rand.nextInt()) % (height-50);
		return new Position(x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
