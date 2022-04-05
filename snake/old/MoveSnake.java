package snake;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MoveSnake extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	static final int DELAY = 140;
	
	private Timer timer;
	Snake3 snake;
	Apple3 apple;

	MoveSnake(Snake3 snake, Apple3 apple) {
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
}
