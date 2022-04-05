package snake;

import java.awt.Color;
import game2D.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BoardPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	static final int DELAY = 140;
	static Hashtable<Integer, Size> arrowDirections = new Hashtable<>();
	static {
		arrowDirections.put(KeyEvent.VK_LEFT, new Size(-10, 0));
		arrowDirections.put(KeyEvent.VK_RIGHT, new Size(10, 0));
		arrowDirections.put(KeyEvent.VK_UP, new Size(0, -10));
		arrowDirections.put(KeyEvent.VK_DOWN, new Size(0, 10));		
	}
	
	private Timer timer;
	Snake snake;
	Apple apple;
	private Image backgroundImg;

	BoardPanel(Snake snake, Apple apple) {
		addKeyListener(new ArrowKey());
		setFocusable(true); // must call or no key response
		
		this.setPreferredSize(new Dimension(400, 300));
		this.snake = snake;
		this.apple = apple;
		timer = new Timer(DELAY, this); // create a time ticker for every DELAY
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
//		g.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(backgroundImg, 0, 0, this);
		g.setColor(Color.white);
		g.setFont(new Font("Calibri", Font.BOLD, 20));
		g.drawImage(snake.head, snake.getX(0), snake.getY(0), this);
		for (int i = 1; i < snake.getLength(); i++) {
			g.drawImage(snake.tail, snake.getX(i), snake.getY(i), this);
		}
		g.drawImage(apple.img, apple.getX(), apple.getY(),this);
		g.drawString(String.format("Score: %d", snake.getScore()), 300, 20);
		if(snake.gameOver) {
			timer.stop();
			g.setFont(new Font("Calibri", Font.BOLD, 35));
			g.drawString("Game Over!!", 100, 100);
		}
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
				Size speed = arrowDirections.get(key);
				snake.setSpeed(speed);
			}
		}
	}

	public void setGroundImage(Image groundImg) {
		this.backgroundImg = groundImg;
		
	}
}
