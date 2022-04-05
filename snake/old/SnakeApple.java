package snake;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import javax.swing.JPanel;
import javax.swing.Timer;

import snake.SnakeApple.ArrowKey;

public class SnakeApple extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	static final int DELAY = 140;
	static Hashtable<Integer, Integer> arrowDirections = new Hashtable<>();
	static {
		arrowDirections.put(KeyEvent.VK_LEFT, Snake.left);
		arrowDirections.put(KeyEvent.VK_RIGHT, Snake.right);
		arrowDirections.put(KeyEvent.VK_UP, Snake.up);
		arrowDirections.put(KeyEvent.VK_DOWN, Snake.down);		
	}
	
	private Timer timer;
	Snake snake;
	Apple apple;

	SnakeApple(Snake snake, Apple apple) {
		addKeyListener(new ArrowKey());
		setFocusable(true); // must call or no key response

		this.snake = snake;
		this.apple = apple;
		timer = new Timer(DELAY, this); // create a time ticker for every DELAY
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(snake.head, snake.getX(0), snake.getY(0), this);
		for (int i = 1; i < snake.getLength(); i++) {
			g.drawImage(snake.tail, snake.getX(i), snake.getY(i), this);
		}
		g.drawImage(apple.img, apple.getX(), apple.getY(),this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		snake.move();
		repaint();
	}
	
	class ArrowKey extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(arrowDirections.containsKey(key)) {
				int direction = arrowDirections.get(key);
//				snake.setDirection(direction);
			}
		}
	}
}
