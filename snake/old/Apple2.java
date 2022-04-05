package snake;

import java.awt.Image;

import javax.swing.JPanel;

public class Apple2 {
	Image img;
	int x;
	int y;
	
	public Apple2(Image appleImg) {
		img = appleImg;
	}

	public void draw(JPanel mainPnl) {
		// TODO Auto-generated method stub
		
	}
	
	void locateApple() {
		Position pos = Position.randomPos(Game.WIDTH, Game.HEIGHT);
		x = pos.x;
		y = pos.y;
	}

}
