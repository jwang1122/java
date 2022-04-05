package snake;

import java.awt.Image;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game1 extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	
	private Snake snake; // DDD: Demand Driven Development
	private Apple apple;
	
	public Game1(){
		init();
		Image headImg = loadImage("head.png");
		Image tailImg = loadImage("dot.png");
		snake = new Snake(headImg, tailImg); // initialize objects
		Image appleImg = loadImage("apple.png");
		apple = new Apple(appleImg);
		JPanel mainPnl = new JPanel(); // no way for me to override paint() method
//		snake.draw(mainPnl);
//		apple.draw(mainPnl);
		add(mainPnl);
	}

	private void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Snake Eat Apple Game");
		this.setResizable(false);	
	}

	public Image loadImage(String filename) {
		URL url = getClass().getClassLoader().getResource("resources/" + filename);
//		System.out.println(url.getPath());
		return getToolkit().getImage(url);
	}

}
