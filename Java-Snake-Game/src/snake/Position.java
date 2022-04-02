package snake;

import java.util.Random;

public class Position {
	int x;
	int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Position getRandomPosition(int width, int height) {
		Random rand = new Random();
		int x = Math.abs(rand.nextInt()) % (width -20);
		int y = Math.abs(rand.nextInt()) % (height -50);
		return new Position(x, y);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Position)) {
			return false;
		}
		Position other = (Position) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}

}
