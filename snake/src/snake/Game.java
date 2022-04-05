package snake;

import java.awt.Image;
import java.net.URL;

import javax.swing.JFrame;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	
	private Snake snake; // DDD: Demand Driven Development
	private Apple apple;
	
	public Game(){
		init();
		Image headImg = loadImage("head.png");
		Image tailImg = loadImage("dot.png");
		snake = new Snake(headImg, tailImg); // initialize objects
		Image appleImg = loadImage("apple1.png");
		apple = new Apple(appleImg);
		apple.locateApple();
		snake.setApple(apple);
		BoardPanel mainPnl = new BoardPanel(snake, apple);
		Image groundImg = loadImage("background1.jpg");
		mainPnl.setGroundImage(groundImg);
//		MoveSnake mainPnl = new MoveSnake(snake, apple);
//		ControlSnake mainPnl = new ControlSnake(snake, apple);
//		SnakeApple mainPnl = new SnakeApple(snake, apple);
		
		add(mainPnl);
	}

	private void init() {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Snake Eat Apple Game");
		this.setResizable(true);	
	}

	public Image loadImage(String filename) {
		URL url = getClass().getClassLoader().getResource("resources/" + filename);
//		System.out.println(url.getPath());
		return getToolkit().getImage(url);
	}

}
