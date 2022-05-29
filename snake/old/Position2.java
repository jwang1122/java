package snake;

import java.util.Random;

/**
 * This class will be used for 2D graphic games
 * @author John
 *
 */
public class Position2 {
	int x;
	int y;
	
	Position2(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	static Position2 randomPos(int width, int height) {
		Random rand = new Random();
		int x = Math.abs(rand.nextInt()) % (width-20);
		int y = Math.abs(rand.nextInt()) % (height-50);
		return new Position2(x, y);
	}
	
}