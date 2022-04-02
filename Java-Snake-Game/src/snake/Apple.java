package snake;

import java.awt.Image;

public class Apple {
	Image img;
	AbstractBoard board;
	Position position;
	
	Apple(AbstractBoard board){
		this.board = board;
		img = board.loadImage("apple.png");
	}
	
	void setPosition(Position p) {
		this.position = p;
	}
	
}
