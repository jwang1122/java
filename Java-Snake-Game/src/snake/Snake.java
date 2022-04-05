package snake;

import java.awt.Image;
import java.util.ArrayList;

public class Snake {
	Image head;
	AbstractBoard board;
	Image tail;
	int width = 10;
	int height = 10;
	int x=10;
	int y=10;
	ArrayList<Position> bodies = new ArrayList<>();

	Snake(AbstractBoard board) {
		this.board = board;
		head = board.loadImage("head.png");
		tail = board.loadImage("dot.png");
		setHead(new Position(x, y));
		addTail(new Position(x, y - height));
		addTail(new Position(x, y - 2*height));
	}

	void setHead(Position point) {
		bodies.add(point);
	}

	void addTail(Position point) {
		bodies.add(point);
	}

	void move(Position point) {
		for (int i = bodies.size()-1; i > 0; i--) {
			Position tmp = bodies.get(i-1); 
			bodies.set(i, tmp);
		}
		bodies.set(0, point);
	}
}
