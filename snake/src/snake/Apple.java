package snake;

import java.awt.Image;
import game2D.*;

public class Apple {
	Image img;
	Rect rect;
	Position pos = new Position(0, 0);
	Size size = new Size(10, 10);

	public Apple(Image appleImg) {
		img = appleImg;
		rect = new Rect(pos, size);
		locateApple();
	}

	void locateApple() {
		pos = Position.randomPosition(Game.WIDTH-20, Game.HEIGHT-50, size.width, size.height);
		rect.setTopLeft(pos);
	}
	
	int getX() {
		return pos.getX();
	}
	
	int getY() {
		return pos.getY();
	}
}
