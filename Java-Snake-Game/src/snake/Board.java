package snake;

import java.awt.Graphics;

public class Board extends AbstractBoard {
	private static final long serialVersionUID = 1L;
	Snake snake;
	int x = 100;
	int y = 100;
	
	Board(){
		snake = new Snake(this);
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(snake.head, x, y, this);
		g.drawImage(snake.tail, x, y+snake.height, this);
	}
}
