package snake;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import javax.swing.JPanel;
import javax.swing.Timer;

import snake.ControlSnake.ArrowKey;

public class ControlSnake extends JPanel implements ActionListener {
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
	Snake3 snake;
	Apple3 apple;

	ControlSnake(Snake3 snake, Apple3 apple) {
		addKeyListener(new ArrowKey());
		setFocusable(true); // must call or no key response

		this.snake = snake;
		this.apple = apple;
		timer = new Timer(DELAY, this); // create a time ticker for every DELAY
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, BoardPanel.WIDTH, BoardPanel.HEIGHT);
		g.drawImage(snake.head, snake.bodies.get(0).x, snake.bodies.get(0).y, this);
		for (int i = 1; i < snake.bodies.size(); i++) {
			g.drawImage(snake.tail, snake.bodies.get(i).x, snake.bodies.get(i).y, this);
		}
		g.drawImage(apple.img, apple.x, apple.y,this);
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
				snake.setDirection(direction);
			}
		}
	}
}
