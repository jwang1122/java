package snake;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Hashtable;

import javax.swing.Timer;

public class RandomApple extends AbstractBoard implements ActionListener {
	private static final long serialVersionUID = 1L;
	static final int DELAY = 140;
	static final int left = 0;
	static final int right = 1;
	static final int up = 2;
	static final int down = 3;
	static Hashtable<Integer, Integer> arrowDirections = new Hashtable<>();
	static {
		arrowDirections.put(KeyEvent.VK_LEFT, left);
		arrowDirections.put(KeyEvent.VK_RIGHT, right);
		arrowDirections.put(KeyEvent.VK_UP, up);
		arrowDirections.put(KeyEvent.VK_DOWN, down);		
	}
	
	private Timer timer;
	Snake snake;
	int x = 10;
	int y = 10;
	int direction = down;
	Apple apple;
	
	public RandomApple() {
		addKeyListener(new ArrowKey());
		setFocusable(true); // must call or no key response
		
		snake = new Snake(this);
		snake.setHead(new Position(x, y));
		snake.addTail(new Position(x, y - snake.height));
		snake.addTail(new Position(x, y - 2*snake.height));
		apple = new Apple(this);
		Position p = Position.getRandomPosition(MainFrame.WIDTH, MainFrame.HEIGHT);
		apple.setPosition(p);
		
		timer = new Timer(DELAY, this); // create a time ticker for every DELAY
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		g.drawImage(snake.head, snake.bodies.get(0).x, snake.bodies.get(0).y, this);
		for (int i = 1; i < snake.bodies.size(); i++) {
			g.drawImage(snake.tail, snake.bodies.get(i).x, snake.bodies.get(i).y, this);
		}
		g.drawImage(apple.img, apple.position.x, apple.position.y,this);
	}

	public Image loadImage(String filename) {
		URL url = getClass().getClassLoader().getResource("resources/" + filename);
		Image image = getToolkit().getImage(url);
		return image;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(direction==down) {
			y += snake.height; 
			if(y>=MainFrame.HEIGHT-6*snake.height) {
				direction = right;
			}
		}
		if(direction==right) {
			x+=snake.width;
			if(x>=MainFrame.WIDTH-3*snake.width) {
				direction = up;
			}
		}
		if(direction==up) {
			y-=snake.height;
			if(y<=0) {
				direction=left;
			}
		}
		if(direction==left) {
			x-=snake.width;
			if(x<=0) {
				direction=down;
			}
		}
		snake.move(new Position(x, y));
		repaint();
	}
	
	class ArrowKey extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(arrowDirections.containsKey(key)) {
				direction = arrowDirections.get(key);
			}
		}
	}
}

