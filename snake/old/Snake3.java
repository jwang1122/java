package snake;

import java.awt.Image;
import java.util.ArrayList;

public class Snake3 {
	static final int left = 0;
	static final int right = 1;
	static final int up = 2;
	static final int down = 3;
	static final int hGap = 30;
	static final int vGap = 50;

	Image head;
//	AbstractBoard board;
	Image tail;
	int width = 10;
	int height = 10;
	int x = 10;
	int y = 10;
	int direction = down;
	ArrayList<Position> bodies = new ArrayList<>();

	Snake3(Image headImg, Image tailImg) {
		head = headImg;
		tail = tailImg;
		setHead(new Position(10,10));
		addTail(new Position(10,0));
		addTail(new Position(10,-10));
	}

	void setHead(Position point) {
		bodies.add(point);
	}

	void addTail(Position point) {
		bodies.add(point);
	}
	
	void setDirection(int direction) {
		this.direction = direction;
	}

	void move() {
		if(direction==down) {
			y += height; 
			if(y>=BoardPanel.HEIGHT-vGap) {
				direction = right;
			}
		}
		if(direction==right) {
			x+=width;
			if(x>=BoardPanel.WIDTH-hGap) {
				direction = up;
			}
		}
		if(direction==up) {
			y-=height;
			if(y<=0) {
				direction=left;
			}
		}
		if(direction==left) {
			x-=width;
			if(x<=0) {
				direction=down;
			}
		}
		for (int i = bodies.size()-1; i > 0; i--) {
			Position tmp = bodies.get(i-1); 
			bodies.set(i, tmp);
		}
		bodies.set(0, new Position(x, y));
	}
}
