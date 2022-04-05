package snake;

import java.awt.Image;
import java.util.ArrayList;
import game2D.*;

public class Snake {
	static final int left = 0;
	static final int right = 1;
	static final int up = 2;
	static final int down = 3;
	static final int hGap = 30;
	static final int vGap = 50;

	Image head;
	Image tail;
	Rect headRect; 
	int width = 10;
	int height = 10;
	int score = 0;
	boolean gameOver = false;
	Size size;
	ArrayList<Rect> bodies = new ArrayList<>();
	private Size speed = new Size(0, 10);
	private Apple apple;

	Snake(Image headImg, Image tailImg) {
		head = headImg;
		tail = tailImg;
		size = new Size(width, height);
		headRect = new Rect(new Position(10, 10), size);
		setHead(headRect);
		addTail();
		addTail();
	}

	int getX(int index) {
		return bodies.get(index).left;
	}

	int getY(int index) {
		return bodies.get(index).top;
	}

	void setHead(Rect rect) {
		bodies.add(rect);
	}

	void addTail() {
		bodies.add(new Rect(0, 0, width, height));
	}

	int getLength() {
		return bodies.size();
	}

	void move() {
		for (int i = bodies.size() - 1; i > 0; i--) {
			Rect tmp = bodies.get(i - 1);
			bodies.set(i, tmp);
		}
		headRect = headRect.copy(); // very important step!!! create a new head
		headRect.move_ip(speed);
		bodies.set(0, headRect);
		if(headRect.colliderect(apple.rect)) {
			apple.locateApple();
			addTail();
			score++;
		}
		if(outWindow()) {
			gameOver = true;
		}
	}

	boolean outWindow() {
		return headRect.left<0 || headRect.right>Game.WIDTH-hGap+width || headRect.top <0 || headRect.bottom>Game.HEIGHT-vGap+height;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setSpeed(Size speed) {
		this.speed = speed;
	}

	public void setApple(Apple apple) {
		this.apple = apple;	
	}
}
