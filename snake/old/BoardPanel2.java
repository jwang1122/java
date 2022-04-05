package snake;

import java.awt.Graphics;

import javax.swing.JPanel;

public class BoardPanel2 extends JPanel {
	private static final long serialVersionUID = 1L;
	private Snake3 snake;
	private Apple3 apple;
	
	public BoardPanel2(Snake3 snake, Apple3 apple) {
		this.snake =snake;
		this.apple = apple;
	}

	@Override
	public void paint(Graphics g) {
		for(int i =0; i< snake.bodies.size(); i++) {
			Position pos = snake.bodies.get(i);
			if(i==0)
				g.drawImage(snake.head, pos.x, pos.y, this);
			else
				g.drawImage(snake.tail, pos.x, pos.y, this);
				
		}
		System.out.println(apple.x + ","+apple.y);
		g.drawImage(apple.img, apple.x, apple.y, this);
	}
	
	

}
